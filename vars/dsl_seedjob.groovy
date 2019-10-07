@Library('jenkins_shared_libraries_git') _
//import org.gap.seedjob.GithubMultiBranch

def Pipeline = new GithubMultiBranch(
        projectName: 'eureka-server',
        pipelineName: "${projectName}_PR_Build",
        scmRepositoryOwner: 'mytest-org',
        scmRepository: 'eureka-server',
        scmCredentialsId: '617bab8b-39fe-43f0-a2a6-a82628d85442',
        scmApiUrl: 'https://api.github.com',
        buildForkPRHead: 'false',
        buildForkPRMerge: 'false',
        buildOriginBranch: 'false',
        buildOriginBranchWithPR: 'false',
        buildOriginPRHead: 'false',
        buildOriginPRMerge: 'true'
).build(this)
