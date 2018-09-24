package com.may.scheduleapplication.applicationslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.may.scheduleapplication.R
import com.may.scheduleapplication.type.TypesFragment


class ApplicationsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
                .beginTransaction()
                .add(R.id.flApplicationsListCurrentFragment,
                        TypesFragment.newInstance(),
                        TypesFragment.TAG)
                .commit()
    }

    companion object {
        const val TAG = "ApplicationsListActivity"
    }
}
