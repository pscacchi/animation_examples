package ar.scacchipa.animation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelPoll: ViewModel() {

    private val _agreePoint = MutableLiveData(0)
    val agreePoint: LiveData<Int> = _agreePoint

    private val _disagreeButtonPosition = MutableLiveData<Boolean>( )
    val disagreeButtonPosition: LiveData<Boolean> = _disagreeButtonPosition


    fun onClickAgreeButton() {
        _agreePoint.value = (_agreePoint.value?:0) + 1
    }

    fun onClickDisagreeButton() {
        _disagreeButtonPosition.value = (_disagreeButtonPosition.value?:false).not()
    }
}