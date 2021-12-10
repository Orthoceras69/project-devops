#!groovy
println('------------------------------------------------------------------Import Job CI/Job1')
def pipelineScript = new File('/var/jenkins_config/jobs/job1-pipeline.groovy').getText("UTF-8")

pipelineJob('CI/Job1') {
    description("Job Pipline 1")
    parameters {
        stringParam {
            name('BRANCH')
            defaultValue('master')
            description("nom de la branche à selectionner")
            trim(false)
        }

        booleanParam{
            name('SKIP_TESTS')
            defaultValue(true)
            description("Boolean pour contrôler l'éxecution des tests")
        }

        choice{
            name('VERSION_TYPE')
            choices(['SNAPSHOT','RELEASE'])
            description("renommer le jar")
        }

        stringParam{
            name('VERSION')
            defaultValue('1')
            description("Version du jar")
            trim(false)
        }
    }
    definition {
        cps {
            script(pipelineScript)
            sandbox()
        }
    }
}