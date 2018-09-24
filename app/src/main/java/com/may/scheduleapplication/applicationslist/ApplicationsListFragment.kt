package com.may.scheduleapplication.applicationslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.may.scheduleapplication.R
import com.may.scheduleapplication.utils.IScheduleIntentManager
import kotlinx.android.synthetic.main.applications_list_view.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ApplicationsListFragment : Fragment() {
    private val mViewModel: ApplicationsListViewModel by viewModel()
    private val mManager: IScheduleIntentManager by inject()

    private val mAdapter = ApplicationsAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.applications_list_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvApplicationsList.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }

        mViewModel.applications.observe(this, Observer {
            mAdapter.replace(it)
        })
        mViewModel.applicationSelected.observe(this, Observer { item ->
            item?.let {
                val intentForPackage = activity!!.packageManager!!.getLaunchIntentForPackage(it.packageName)
                mManager.schedule(intentForPackage)
            }
        })
        mAdapter.itemClickListener = { position ->
            val item = mAdapter.getItem(position)
            mViewModel.onItemSelected(item)
        }
        mViewModel.onCreate()
    }

    companion object {
        fun newInstance() = ApplicationsListFragment()
        const val TAG = "ApplicationsListFragment"
    }
}