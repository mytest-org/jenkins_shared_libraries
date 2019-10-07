
def prBuild = [scmId: UUID.randomUUID().toString(),
                    projectName: 'eureka-server',
                    scmRepositoryOwner: 'mytest-org',
                    scmRepository: 'eureka-server',
                    scmApiUrl: 'https://api.github.com',
                    scmApiCredentialsId: '617bab8b-39fe-43f0-a2a6-a82628d85442'
                    ]

// Creating multi-branch pipeline for Pull Request Job
multibranchPipelineJob("GAP/${prBuild.projectName}_PR_Build") {
    branchSources {
        github {
            id("${prBuild.scmId}")
            scanCredentialsId("${prBuild.scmApiCredentialsId}")
            apiUri("${prBuild.scmApiUrl}")
            repoOwner("${prBuild.scmRepositoryOwner}")
            repository("${prBuild.scmRepository}")
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


def testPublishBuild = [scmId: UUID.randomUUID().toString(),
               projectName: 'eureka-server',
               scmRepositoryOwner: 'mytest-org',
               scmRepository: 'eureka-server',
               scmApiUrl: 'https://api.github.com',
               scmApiCredentialsId: '617bab8b-39fe-43f0-a2a6-a82628d85442'
]

// Creating multi-branch pipeline for build, test, and publish job
multibranchPipelineJob("GAP/${testPublishBuild.projectName}_Test_Publish") {
    branchSources {
        github {
            id("${testPublishBuild.scmId}")
            scanCredentialsId("${testPublishBuild.scmApiCredentialsId}")
            apiUri("${testPublishBuild.scmApiUrl}")
            repoOwner("${testPublishBuild.scmRepositoryOwner}")
            repository("${testPublishBuild.scmRepository}")
            includes('master')
        }
    }  // end of branchSources
    factory {
        workflowBranchProjectFactory {
            scriptPath('Jenkinsfile')
        }
    }
}