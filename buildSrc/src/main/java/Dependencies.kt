/*
* @author Khalidtoak
* @since  2019-12-26
*/
object Versions{
    const val GRADLE_VERSION = "3.5.3"
    const val KOTLIN_VERSION = "1.3.61"
    const val ROOM_VERSION = "2.2.3"
    const val NAVIGATION_VERSION = "1.0.0"
    const val KODEIN_VERSION = "6.4.0"
    const val  LIFECYCLE_VERSION= "2.2.0-rc03"
    const val RETROFIT_VERSION = "2.6.0"
    const val VIEWPAGER2_VERSION = "1.0.0"
    const val CONSTRAINT_LAYOUT_VERSION = "1.1.3"
    const val KTX_VERSION = "1.1.0"
    const val COROUTINES_VERSION = "1.3.2"
    const val COROUTINES_ADAPTER_VERSION = "0.9.2"
    const val GLIDE_VERSION = "4.8.0"
    const val GROUPIE_VERSION = "2.3.0"
}

object Libraries{
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN_VERSION}"
    const val NAV_FRAGMENT =  "android.arch.navigation:navigation-fragment:${Versions.NAVIGATION_VERSION}"
    const val NAV_UI =  "android.arch.navigation:navigation-ui:${Versions.NAVIGATION_VERSION}"
    const val NAV_FRAG_KTX ="android.arch.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_VERSION}"
    const val NAV_UI_KTX =  "android.arch.navigation:navigation-ui-ktx:${Versions.NAVIGATION_VERSION}"
    const val ROOM = "androidx.room:room-runtime:${Versions.ROOM_VERSION}"
    const val ROOM_COMPILER ="androidx.room:room-compiler:${Versions.ROOM_VERSION}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM_VERSION}"
    const val COROUTINES_CORE ="org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES_VERSION}"
    const val COROUTINES_ANDROID ="org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES_VERSION}"
    //ViewModels
    const val LIFECYCLE_EXT = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFECYCLE_VERSION}"
    const val LIFECYCLE_VIEWMODEL_KTX ="androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VERSION}"
    //kODEIN FOR di
    const val KODEIN ="org.kodein.di:kodein-di-generic-jvm:${Versions.KODEIN_VERSION}"
    const val KODIEN_ANDROID_X ="org.kodein.di:kodein-di-framework-android-x:${Versions.KODEIN_VERSION}"
    //Better date and time support
    const val THIRTEEN_BP ="com.jakewharton.threetenabp:threetenabp:1.1.0"
    //Glide for image Loading
    const val GLIDE ="com.github.bumptech.glide:glide:${Versions.GLIDE_VERSION}"
    const val GLIDE_COMPILER ="com.github.bumptech.glide:compiler:${Versions.GLIDE_VERSION}"
    //Retrofit for making network calls
    const val RETROFIT ="com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    const val GSON =  "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_VERSION}"
    const val RETROFIT_COROUTINE_ADAPTER ="com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.COROUTINES_ADAPTER_VERSION}"
    //Groupie for easier recycler views
    const val GROUPIE = "com.xwray:groupie:${Versions.GROUPIE_VERSION}"
    const val GROUPIE_ANDROID_EXTENTIONS =  "com.xwray:groupie-kotlin-android-extensions:${Versions.GROUPIE_VERSION}"
    const val APP_COMPAT =  "androidx.appcompat:appcompat:1.1.0"
    const val KTX_CORE =  "androidx.core:core-ktx:${Versions.KTX_VERSION}"
    const val OTHER_GSON = "com.google.code.gson:gson:2.8.5"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT_VERSION}"
    //viewpager
    const val VIEW_PAGER_2 = "androidx.viewpager2:viewpager2:${Versions.VIEWPAGER2_VERSION}"
    //Just LiveData
    const val LIVE_DATA_KTX=  "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_VERSION}"
    const val LIFE_CYCLE_COMPILER =   "androidx.lifecycle:lifecycle-compiler:${Versions.LIFECYCLE_VERSION}"
    const val LIFE_CYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime:${Versions.LIFECYCLE_VERSION}"

    const val LEGACY_SUPPORT = "androidx.legacy:legacy-support-v4:1.0.0"
    //Tests
    const val JUNIT = "junit:junit:4.12"
    const val JUNIT_EXT = "androidx.test.ext:junit:1.1.1"
    const val ESPRESSO =  "androidx.test.espresso:espresso-core:3.2.0"
    const val MATERIAL_GOOGLE =  "com.google.android.material:material:1.0.0"
}
object ProjectDependencies {
    const val GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE_VERSION}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_VERSION}"
}