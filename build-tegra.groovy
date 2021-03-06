pipeline {
    agent { label 'yocto'}
    stages {
        stage('scm') {
            steps {
                git branch: 'develop', url: 'https://github.com/krickwix/meta-gbeos.git'
                withEnv(['LANG="C"']) {
                    sh("git submodule update --init --recursive --jobs 32 tegra-distro")
                }
            }
        }
        stage("build") {
            steps {
                withEnv(['LANG="C"']) {
                    sh("cd tegra-distro && . setup-env --machine jetson-nano-devkit-emmc --distro tegrademo && \
                    MACHINE=jetson-nano-devkit-emmc bitbake demo-image-full && \
                    MACHINE=jetson-nano-devkit bitbake demo-image-full && \
                    MACHINE=jetson-xavier-nx-devkit bitbake demo-image-full && \
                    MACHINE=jetson-xavier-nx-devkit-tx2-nx bitbake demo-image-full")
                }
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