package com.khalid.polls.library_base.presentation

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.khalid.polls.library_base.BuildConfig
import org.kodein.di.KodeinTrigger
import org.kodein.di.android.kodein
/*
* Hell yeah!!*/
import org.kodein.di.Kodein as Codeine
import org.kodein.di.KodeinAware as CodeineAware
import org.kodein.di.android.retainedKodein
import org.kodein.di.generic.kcontext

/*
* @author Khalidtoak
* @since  2019-12-26
*
* Activity is kodeinAware for Di
*/
abstract class BaseActivity : AppCompatActivity(), CodeineAware{
    //layout to set content view on
    @get:LayoutRes
    protected abstract val layoutResId : Int
    private val parentDiet by kodein()
    final override val kodeinContext = kcontext<AppCompatActivity>(this)

    // retainedKodein will prevent recreation of kodeine instance when activity restarts
    val diet : Codeine by retainedKodein {
        extend(parentDiet)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
    }

    /*
    * For debug mode, trigger kodien eagerly, i.e all dependencies will be resolved eagerly
    * else , all dependencies can be resolved lazily instead*/
    final override val kodeinTrigger: KodeinTrigger?
        get() = if (BuildConfig.DEBUG) KodeinTrigger() else super.kodeinTrigger

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        kodeinTrigger?.trigger()
    }


}