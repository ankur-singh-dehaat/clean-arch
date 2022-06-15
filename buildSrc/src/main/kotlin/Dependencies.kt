object Dagger {
    val dagger by lazy { "com.google.dagger:hilt-android:${Versions.dagger}" }
    val daggerCompiler by lazy { "com.google.dagger:hilt-compiler:${Versions.dagger}" }
}

object UnitTesting {
    val jUnit4 by lazy { "junit:junit:${Versions.jUnit}" }
}

object Android {
    val activity by lazy { "androidx.activity:activity-ktx:${Versions.activity}" }
    val fragment by lazy { "androidx.fragment:fragment-ktx:${Versions.fragment}" }
    val core by lazy { "androidx.core:core-ktx:${Versions.core}" }
    val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}" }
    val material by lazy { "com.google.android.material:material:1.6.1" }
}

object Kotlin {
    val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}" }
}

object Modules {
    val common by lazy { ":common" }
}
