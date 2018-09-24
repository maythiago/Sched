package com.may.scheduleapplication.applicationslist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.applications_item_view.view.*

class ApplicationViewHolder(itemView: View, clickListener: (Int) -> Unit?) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.ivApplicationsItemName
    val icon: ImageView = itemView.ivApplicationsItemIcon

    init {
        itemView.setOnClickListener { v ->
            clickListener.invoke(adapterPosition)
        }
    }
}