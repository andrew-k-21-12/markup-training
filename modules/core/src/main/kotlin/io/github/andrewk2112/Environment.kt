package io.github.andrewk2112

/**
 * Descriptions and configurations of the current environment.
 */
object Environment {

    // Utility.

    /**
     * A build mode this application can run under.
     */
    enum class BuildMode { DEVELOPMENT, PRODUCTION }



    // Public.

    /** Root project name configured in Gradle. */
    val projectName: String = js("PROJECT_NAME").unsafeCast<String>()

    /** Current build mode of this application. */
    val buildMode: BuildMode by lazy {
        for (buildMode in BuildMode.values()) {
            if (buildMode.name.equals(js("BUILD_MODE").unsafeCast<String>(), ignoreCase = true)) {
                return@lazy buildMode
            }
        }
        BuildMode.DEVELOPMENT
    }

}
