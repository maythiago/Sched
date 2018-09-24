package com.may.scheduleapplication.applicationslist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.may.scheduleapplication.model.ApplicationViewModel
import com.may.scheduleapplication.repository.ApplicationsRepository

class ApplicationsListViewModel(val repository: ApplicationsRepository) : ViewModel() {
    private val mApplications: MutableLiveData<List<ApplicationViewModel>> = MutableLiveData()
    private val mApplicationSelected: MutableLiveData<ApplicationViewModel> = MutableLiveData()
    val applications: MutableLiveData<List<ApplicationViewModel>>
        get() = mApplications
    val applicationSelected: MutableLiveData<ApplicationViewModel>
        get() = mApplicationSelected

    fun onCreate() {
        if (mApplications.value == null || mApplications.value!!.isEmpty()) {
            var loadingApplications = repository.loadingApplications()
            mApplications.postValue(loadingApplications)
        }
    }

    fun onItemSelected(application: ApplicationViewModel) {
        mApplicationSelected.postValue(application)
    }

}