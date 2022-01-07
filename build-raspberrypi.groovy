pipeline {
    agent { label 'yocto'}
    stages {
        stage('scm') {
            steps {
                git branch: 'refactor', url: 'https://github.com/krickwix/meta-gbeos.git'
                withEnv(['LANG=C']) {
                    sh("git submodule update --init --jobs 32")
                }
            }
        }
        stage("build") {
            steps {
                withEnv(['LANG=C']) {
                    sh("cd rpi-distro && . setupenv && \
                    MACHINE=raspberrypi4-64 bitbake gbeos-dev && \
                    MACHINE=raspberrypi3-64 bitbake gbeos-dev")
                }
            }
        }
        stage('image') {
            steps {
                sh(
                "cd $WORKSPACE/rpi-distro/build/tmp/deploy/images/raspberrypi4-64 && \
                bmaptool copy --bmap gbeos-dev-raspberrypi4-64.wic.bmap \
                    gbeos-dev-raspberrypi4-64.wic.bz2 \
                    gbeos-dev-raspberrypi4-64.img && \
                cd $WORKSPACE/rpi-distro/build/tmp/deploy/images/raspberrypi3-64 && \
                bmaptool copy --bmap gbeos-dev-raspberrypi3-64.wic.bmap \
                    gbeos-dev-raspberrypi3-64.wic.bz2 \
                    gbeos-dev-raspberrypi3-64.img"
                )
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
                archiveArtifacts artifacts: 'rpi-distro/build/tmp/deploy/images/**/*.img',
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