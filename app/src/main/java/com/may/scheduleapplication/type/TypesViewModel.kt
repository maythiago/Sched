package com.may.scheduleapplication.type

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TypesViewModel : ViewModel() {
    val itemSelected: MutableLiveData<String> = MutableLiveData()
    fun onItemClicked(click: String) {
        itemSelected.postValue(click)
    }
}
