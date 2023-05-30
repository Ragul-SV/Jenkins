job('NodeJS Example') {
    scm {
        git('https://github.com/wardviaene/docker-demo.git') { node ->
        node / gitConfigName('DSL User')
        node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('*/5 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        shell("npm install")
    }
}