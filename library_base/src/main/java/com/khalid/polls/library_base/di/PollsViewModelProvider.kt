package com.khalid.polls.library_base.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/*
* @author Khalidtoak
* @since  2019-12-26
*
* Initializes ViewModel with ViewModel Factory
*/
@Suppress("UNCHECKED_CAST")
class PollsViewModelProvider {
    companion object{
        inline fun<reified T : ViewModel> of(fragment: Fragment, crossinline factory : () -> T) : T{
            val viewModelFactory = object : ViewModelProvider.Factory{
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                   return factory() as T
                }
            }
            return ViewModelProvider(fragment, viewModelFactory)[T::class.java]
        }

        inline  fun<reified T : ViewModel> of(fragmentActivity : FragmentActivity,  crossinline factory : () -> T) : T{
            val viewModelFactory = object : ViewModelProvider.NewInstanceFactory() {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return factory() as T
                }
            }
            return ViewModelProvider(fragmentActivity, viewModelFactory)[T::class.java]
        }
    }
}