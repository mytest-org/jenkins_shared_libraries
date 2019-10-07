projectName = 'eureka-server'
scmRepositoryUrl = 'https://github.com/mytest-org/eureka-server.git'
scmCredentialsId = 'GIT_CREDENTIALS'
scmApiCredentialsId = '617bab8b-39fe-43f0-a2a6-a82628d85442'

multibranchPipelineJob("GAP/${projectName}_PR_Build") {
    branchSources {
        github {
            id("f04e2d72-fa29-4cd9-8de3-5b28243675fc")
            scanCredentialsId("${scmApiCredentialsId}")
            //        checkoutCredentialsId("${scmCredentialsId}")
            apiUri("https://api.github.com")
            repoOwner("mytest-org")
            repository("eureka-server")
            buildForkPRHead(false)
            buildForkPRMerge(false)
            buildOriginBranch(false)
            buildOriginBranchWithPR(false)
            buildOriginPRHead(false)
            buildOriginPRMerge(true)
        }
    }  // end of branchSources
    factory {
        workflowBranchProjectFactory {
            scriptPath('Jenkinsfile')
        }
    }
}