package com.may.scheduleapplication.type

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.types_item_view.view.*

class TypeViewHolder(itemView: View, click: (Int) -> Any?) : RecyclerView.ViewHolder(itemView) {
    val description = itemView.tvTypesItemDescription

    init {
        itemView.setOnClickListener {
            click.invoke(adapterPosition)
        }
    }
}
