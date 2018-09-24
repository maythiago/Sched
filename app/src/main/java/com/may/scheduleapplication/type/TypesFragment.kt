package com.may.scheduleapplication.type

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.may.scheduleapplication.R
import com.may.scheduleapplication.applicationslist.ApplicationsListFragment
import kotlinx.android.synthetic.main.types_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class TypesFragment : Fragment() {
    val mViewModel: TypesViewModel by viewModel()
    val mAdapter by lazy {
        TypesAdapter(resources.getStringArray(R.array.types))
    }

    companion object {
        fun newInstance() = TypesFragment()
        const val TAG = "TypesFragment"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.itemSelected.observe(this, Observer {
            activity!!.supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.flApplicationsListCurrentFragment,
                            ApplicationsListFragment.newInstance(),
                            ApplicationsListFragment.TAG)
                    .commit()
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.types_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvTypesList.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
        }
        mAdapter.itemClickListener = {
            mViewModel.onItemClicked(it)
        }
    }
}
