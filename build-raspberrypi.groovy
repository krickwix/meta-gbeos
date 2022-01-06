pipeline {
    agent { label 'yocto'}
    stages {
        stage('scm') {
            steps {
                git branch: 'develop', url: 'https://github.com/krickwix/meta-gbeos.git'
                withEnv(['LANG=C','all_proxy=http://proxy.esl.cisco.com:80','GIT_TRACE_PACKET=true']) {
                    sh("all_proxy=http://proxy.esl.cisco.com:80 git submodule update --init --jobs 16")
                }
            }
        }
        stage("build") {
            steps {
                withEnv(['LANG=C']) {
                    sh("cd rpi-distro && . setupenv && for i in 'raspberrypi4-64 raspberrypi3-64';do MACHINE=$i bitbake gbeos-dev;done")
                }
            }
        }
        stage("artefacts") {
            steps {
                archiveArtifacts artifacts: 'rpi-distro/build/tmp/deploy/images/**/*.wic.bz2',
                   allowEmptyArchive: true,
                   fingerprint: true,
                   onlyIfSuccessful: true
                archiveArtifacts artifacts: 'rpi-distro/build/tmp/deploy/images/**/*.bmap',
                   allowEmptyArchive: true,
                   fingerprint: true,
                   onlyIfSuccessful: true
                minio bucket: 'gbear-yocto-images', 
                   credentialsId: 'minio_gbear-user',
                   targetFolder: 'jenkins-build/',
                   host: 'http://10.60.16.240:9199', 
                   includes: 'rpi-distro/build/tmp/deploy/images/**/*.bmap'
                minio bucket: 'gbear-yocto-images', 
                   credentialsId: 'minio_gbear-user',
                   targetFolder: 'jenkins-build/',
                   host: 'http://10.60.16.240:9199', 
                   includes: 'rpi-distro/build/tmp/deploy/images/**/*.wic.bz2'
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