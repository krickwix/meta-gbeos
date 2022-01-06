pipeline {
    agent { label 'yocto'}
    stages {
        stage('scm') {
            steps {
                git branch: 'develop', url: 'https://github.com/krickwix/meta-gbeos.git'
                withEnv(['all_proxy=http://proxy.esl.cisco.com:80','GIT_TRACE_PACKET=true']) {
                    sh("all_proxy=http://proxy.esl.cisco.com:80 git submodule update --init --recursive --jobs 32")
                }
            }
        }
        stage("build") {
            steps {
                sh("cd tegra-distro && . setup-env --machine jetson-nano-devkit-emmc --distro tegrademo && \
                for i in "jetson-nano-devkit-emmc jetson-nano-devkit jetson-xavier-nx-devkit jetson-nano-xavier-nx-devkit-tx2-nx"; do MACHINE=$i bitbake demo-image-full;done")
            }
        }
        stage("artefacts") {
            steps {
                archiveArtifacts artifacts: 'tegra-distro/build/tmp/deploy/images/**/*.tegraflash.tar.gz',
                   allowEmptyArchive: true,
                   fingerprint: true,
                   onlyIfSuccessful: true
                minio bucket: 'gbear-yocto-images', 
                   credentialsId: 'minio_gbear-user',
                   targetFolder: 'jenkins-build/',
                   host: 'http://10.60.16.240:9199', 
                   includes: 'tegra-distro/build/tmp/deploy/images/**/*.tegraflash.tar.gz'
            }
        }
    }
    post {
        // Clean after build
        always {
            cleanWs()
        }
    }
}