package com.khalid.polls.library_base.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.properties.Delegates

/*
* @author Khalidtoak
* @since  2019-12-26
*/
abstract class BaseViewModel<screenState : ScreenState, screenAction : ScreenAction>(initialState: ScreenState) :
    ViewModel() {
    private val stateMutableLiveData = MutableLiveData<ScreenState>()
    val stateLiveData = stateMutableLiveData as LiveData<ScreenState>

    //Prevents multiple states emitting the same LiveData from being emitted more than once
    protected var state by Delegates.observable(initialState){ _, _, newValue ->
        stateMutableLiveData.value = newValue
    }
    fun sendAction(){
        onSendActionCalled()
    }
    fun getData(){
        onGetDataCalled()
    }
    protected abstract  fun onGetDataCalled()
    protected abstract fun onSendActionCalled()
}