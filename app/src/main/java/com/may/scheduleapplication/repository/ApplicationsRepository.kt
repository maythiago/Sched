package com.may.scheduleapplication.repository

import com.may.scheduleapplication.model.ApplicationViewModel

interface ApplicationsRepository {
    fun loadingApplications(): List<ApplicationViewModel>

}

