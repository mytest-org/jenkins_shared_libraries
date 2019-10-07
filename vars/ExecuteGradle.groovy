import org.gap.build.BuildGradle
import org.gap.build.ExecuteBuild
import org.gap.ioc.ContextRegistry

def call(String tool, args) {
    ContextRegistry.registerDefaultContext(this)

//    def buildGradle = new BuildGradle(goals)
//    buildGradle.build()

    def executeBuild = new ExecuteBuild(tool, args)
    executeBuild.build()

}
