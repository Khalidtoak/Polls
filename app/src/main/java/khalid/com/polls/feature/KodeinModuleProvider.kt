package khalid.com.polls.feature

import org.kodein.di.Kodein

/*
* @author Khalidtoak
* @since  2019-12-28
*/
interface KodeinModuleProvider{
    val kodeinModule : Kodein.Module
}