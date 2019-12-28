import kotlin.reflect.full.memberProperties

/*
* @author Khalidtoak
* @since  2019-12-26
*/


/*
* Feature prefix to denote DFM module*/
private const val FEATURE_PREFIX = ":feature_"

/*
* All Modules are accessed via reflection
* */
object ModuleDependencies {
    const val APP = ":app"
    const val FEATURE_AUTH = FEATURE_PREFIX + "authentication"
    const val LIBRARY_BASE = ":library_base"

    /*
* Returns all modules from the constatnt values in this class and converts to A set*/
    fun getAllModules() = ModuleDependencies::class.memberProperties.filter { it.isConst }
        .map { it.getter.call().toString() }.toSet()

    /*
* Gets all modules starting with the feature prefix*/
    fun getDfms() = getAllModules().filter { it.startsWith(FEATURE_PREFIX) }.toSet()
    fun getMutableDfms() = getDfms().toMutableSet()
}