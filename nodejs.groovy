job('NodeJS example') {
    scm {
        git('https://github.com/Gagandeep39/nodejs-docker-demo.git') {  node ->
            node / gitConfigName('DSL User')
            node / gitConfigEmail('singh.gagandeep3911@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell('npm install')
    }
}
