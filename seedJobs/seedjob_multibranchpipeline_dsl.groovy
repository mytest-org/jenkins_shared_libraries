projectName = 'eureka-server'
scmRepositoryUrl = 'https://gitlab.mynisum.com/devops/eureka-server.git'
scmCredentialsId = 'gitlab_cred'

multibranchPipelineJob("${projectName}") {
    branchSources {
        branchSource {
            source {
                git {
                    id('dd847135-8391-4f66-a54c-7f8781dc3119')
                    remote("${scmRepositoryUrl}")
                    credentialsId("${scmCredentialsId}")
                }
            }
        }
    }
    factory {
        workflowMultiBranchProjectFactory {
            scriptPath('Jenkinsfile')
        }
    }
}


/*
multibranchPipelineJob("${projectName}") {
    displayName "${projectName}"
    description "multi-branch pipeline job for ${projectName}"
    configure {
        it / sources / 'data' / 'jenkins.branch.BranchSource' << {
            source(class: 'jenkins.plugins.git.GitSCMSource') {
                id(uuid)
                remote("${scmRepositoryUrl}")
                credentialsId("${scmCredentialsId}")
                includes('*')
                excludes('')
                ignoreOnPushNotifications('false')
                traits {
                    'jenkins.plugins.git.traits.BranchDiscoveryTrait'()
                }
            }
            // default strategy when sourcing from a branch
            strategy(class: "jenkins.branch.NamedExceptionsBranchPropertyStrategy") {
                defaultProperties(class: "java.util.Arrays\$ArrayList") {
                    a(class: "jenkins.branch.BranchProperty-array") {
                        // don't trigger builds
                        "jenkins.branch.NoTriggerBranchProperty"()
                    }
                }
                // exceptions to the default strategy
                namedExceptions(class: "java.util.Arrays\$ArrayList") {
                    a(class: "jenkins.branch.NamedExceptionsBranchPropertyStrategy\$Named-array") {
                        "jenkins.branch.NamedExceptionsBranchPropertyStrategy_-Named"() {
                            // for the brach named `master` trigger builds
                            //   (this is default behaviour if no branch properties are specified)
                            props(class: "empty-list")
                            name("master")
                        }
                    }
                }
            }
        }
        // customise the branch project factory
        it / factory(class: "org.jenkinsci.plugins.workflow.multibranch.WorkflowBranchProjectFactory") << {
            // pipeline jobs will have their script path set to `pipelines/customPipeline.groovy`
            scriptPath("Jenkinsfile")
        }
    }
}
*/