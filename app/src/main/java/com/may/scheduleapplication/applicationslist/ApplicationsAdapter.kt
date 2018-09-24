package com.may.scheduleapplication.applicationslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.may.scheduleapplication.R
import com.may.scheduleapplication.model.ApplicationViewModel

class ApplicationsAdapter : RecyclerView.Adapter<ApplicationViewHolder>() {
    var itens = mutableListOf<ApplicationViewModel>()
    var itemClickListener: ((position: Int) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplicationViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.applications_item_view, parent, false)
        val clickListener = { position: Int ->
            itemClickListener?.invoke(position)
        }
        return ApplicationViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: ApplicationViewHolder, position: Int) {
        var item = getItem(position)
        with(holder) {
            Glide.with(itemView)
                    .load(item.icon)
                    .into(icon)
            name.text = item.name
        }
    }

    fun getItem(position: Int) = itens.get(position)

    override fun getItemCount() = itens.size

    fun replace(applications: List<ApplicationViewModel>) {
        var itemCount = itemCount
        itens.clear()
        notifyItemRangeRemoved(0, itemCount)
        itens.addAll(applications)
        notifyItemRangeInserted(0, getItemCount())
    }
}

