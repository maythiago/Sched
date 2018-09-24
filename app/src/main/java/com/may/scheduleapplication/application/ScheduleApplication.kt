package com.may.scheduleapplication.application

import android.app.Application
import android.content.pm.PackageManager
import com.may.scheduleapplication.applicationslist.ApplicationsListViewModel
import com.may.scheduleapplication.repository.ApplicationRepositoryImpl
import com.may.scheduleapplication.repository.ApplicationsRepository
import com.may.scheduleapplication.type.TypesViewModel
import com.may.scheduleapplication.utils.IScheduleIntentManager
import com.may.scheduleapplication.utils.ScheduleIntentManager
import org.koin.android.ext.android.startKoin
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

class ScheduleApplication : Application() {
    val modules = module {
        single<PackageManager> { androidContext().packageManager }
        single<ApplicationsRepository> { ApplicationRepositoryImpl(get()) }
        single<IScheduleIntentManager> { ScheduleIntentManager(get()) }
        viewModel { ApplicationsListViewModel(get()) }
        viewModel { TypesViewModel() }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(modules))
    }
}
