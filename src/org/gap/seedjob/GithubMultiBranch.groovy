package org.gap.seedjob

import javaposse.jobdsl.dsl.DslFactory

class GithubMultiBranch {

    String projectName
    String pipelineName
//    String scmRepositoryUrl
    String scmRepositoryOwner
    String scmRepository
    String scmCredentialsId
    String scmApiUrl
    String buildForkPRHead
    String buildForkPRMerge
    String buildOriginBranch
    String buildOriginBranchWithPR
    String buildOriginPRHead
    String buildOriginPRMerge
    def scmId = UUID.randomUUID().toString()

    void build(DslFactory dslFactory) {
        def job = dslFactory.multibranchPipelineJob(pipelineName) {
            displayName(projectName)
            branchSources {
                github {
                    id("${scmId}")
                    scanCredentialsId("${scmCredentialsId}")
                    apiUri("${scmApiUrl}")
                    repoOwner("${scmRepositoryOwner}")
                    repository("${scmRepository}")
                    buildForkPRHead(${buildForkPRHead})
                    buildForkPRMerge(${buildForkPRMerge})
                    buildOriginBranch(${buildOriginBranch})
                    buildOriginBranchWithPR(${buildOriginBranchWithPR})
                    buildOriginPRHead(${buildOriginPRHead})
                    buildOriginPRMerge(${buildOriginPRMerge})
                }
            }  // end of branchSources

            factory {
                workflowBranchProjectFactory {
                    scriptPath('Jenkinsfile')
                }
            }
        }
    }  // end of build method

} // end of class
