package com.khalid.polls.library_base.presentation

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.khalid.polls.library_base.BuildConfig
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.KodeinContext
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.kcontext

/*
* @author Khalidtoak
* @since  2019-12-26
*/
abstract  class BaseFragment : Fragment(), KodeinAware{
    //layout to set content view on
    @get:LayoutRes
    protected abstract val layoutResId : Int

    override val kodeinContext: KodeinContext<*> = kcontext<Fragment>(this)
    override val kodein: Kodein by kodein()

    override val kodeinTrigger: KodeinTrigger?
        get() = if (BuildConfig.DEBUG) KodeinTrigger() else super.kodeinTrigger

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Trigger kodien here
        kodeinTrigger?.trigger()
    }
}