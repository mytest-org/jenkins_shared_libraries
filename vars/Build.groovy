import org.gap.build.ExecuteBuild
import org.gap.ioc.ContextRegistry

def call(String tool, args) {
    ContextRegistry.registerDefaultContext(this)

    def executeBuild = new ExecuteBuild(tool, args)
    executeBuild.build()

}
