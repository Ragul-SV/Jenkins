job('NodeJS Docker example') {
    scm {
        git('git://github.com/wardviane/docker-demo.git') { node ->
            node / gitConfigName('DSL User')
            node / gitConfigMail('jenkins-dsl@newtech.academy')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('ragulsv1999/docker-nodejs-demo')
            tag('$(GIT_REVISION,length=9)')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}