projectName = 'eureka-server'
//scmRepositoryUrl = 'https://gitlab.mynisum.com/devops/eureka-server.git'
scmRepositoryUrl = 'https://github.com/mytest-org/eureka-server.git'
//scmCredentialsId = 'gitlab_cred'

multibranchPipelineJob("GAP/${projectName}_PR_Build") {
    branchSources {
        git {
            id('dd847135-8391-4f66-a54c-7f8781dc3119')
            remote("${scmRepositoryUrl}")
//            credentialsId("${scmCredentialsId}")
            includes('*')
            excludes('')
        }
    }
    factory {
        workflowBranchProjectFactory {
            scriptPath('Jenkinsfile')
        }
    }
}