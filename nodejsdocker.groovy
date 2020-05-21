job('NodeJS Docker example') {
    scm {
        git('https://github.com/Gagandeep39/nodejs-docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('gagandeep39')
            node / gitConfigEmail('singh.gagandeep3911@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs14.3')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('wardviaene/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('docker')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}