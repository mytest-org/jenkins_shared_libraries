def scmId = UUID.randomUUID().toString()
projectName = 'eureka-server'
pipelineName = "GAP/${projectName}_PR_Build"
scmRepository = 'eureka-server'
scmRepositoryOwner = 'mytest-org'
scmApiUrl = 'https://api.github.com'
scmCredentialsId = 'GIT_CREDENTIALS'
scmApiCredentialsId = '617bab8b-39fe-43f0-a2a6-a82628d85442'

multibranchPipelineJob("${pipelineName}") {
    branchSources {
        github {
            id("${scmId}")
            scanCredentialsId("${scmApiCredentialsId}")
            apiUri("${scmApiUrl}")
            repoOwner("${scmRepositoryOwner}")
            repository("${scmRepository}")
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