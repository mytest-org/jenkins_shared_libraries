import org.gap.build.BuildGradle
import org.gap.ioc.ContextRegistry

def call(String goals) {
    ContextRegistry.registerDefaultContext(this)

    def buildGradle = new BuildGradle(goals)
    buildGradle.build()
}
