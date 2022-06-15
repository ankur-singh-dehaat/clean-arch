import org.gradle.api.Plugin
import org.gradle.api.Project

class ModulePlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.run {
            apply("com.android.library")
            apply("org.jetbrains.kotlin.android")
            apply("kotlin-kapt")
            apply("dagger.hilt.android.plugin")
        }
    }
}
