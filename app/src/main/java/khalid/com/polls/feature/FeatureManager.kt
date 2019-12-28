package khalid.com.polls.feature

import khalid.com.polls.BuildConfig

/*
* @author Khalidtoak
* @since  2019-12-27
* Using reflection to access module content since we can't access the modules directly
*/
private const val featurePackagePrefix = "khalid.com.polls.feature"
val kodeineModules = arrayOf("authentication").map {
    "$featurePackagePrefix.$it.FeatureKodeinModule"
}.map {
    try {
        Class.forName(it).kotlin.objectInstance as KodeinModuleProvider
    } catch (e : ClassNotFoundException){
        throw ClassNotFoundException("Module class was not found")
    }
}.map {
    it.kodeinModule
}