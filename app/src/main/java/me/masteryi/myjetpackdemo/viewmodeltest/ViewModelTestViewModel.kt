package me.masteryi.myjetpackdemo.viewmodeltest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class ViewModelTestViewModel : ViewModel() {
    val data = MutableLiveData(0)
    val str = data.map {
        it.toString()
    }

    fun updateData(value: Int) {
        data.postValue((data.value ?: 0) + value)
    }
}