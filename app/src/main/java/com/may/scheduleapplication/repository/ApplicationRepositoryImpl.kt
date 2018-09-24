package com.may.scheduleapplication.repository

import android.content.Intent
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import com.may.scheduleapplication.model.ApplicationViewModel


class ApplicationRepositoryImpl(val packageManager: PackageManager) : ApplicationsRepository {
    override fun loadingApplications(): List<ApplicationViewModel> {
        val mainIntent = Intent(Intent.ACTION_MAIN, null)
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER)
        return packageManager
                .getInstalledApplications(0)
                .filter { (it.flags and ApplicationInfo.FLAG_SYSTEM) == 0 }
                .map {
                    ApplicationViewModel(it.loadIcon(packageManager), it.packageName,
                            packageManager.getApplicationLabel(it).toString())
                }
                .sortedBy { it.name }
    }

}