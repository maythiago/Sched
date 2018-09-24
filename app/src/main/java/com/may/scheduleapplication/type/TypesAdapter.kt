package com.may.scheduleapplication.type

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.may.scheduleapplication.R

class TypesAdapter(private val types: Array<String>) : RecyclerView.Adapter<TypeViewHolder>() {
    var itemClickListener: ((item: String) -> Any)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.types_item_view, parent, false)
        var click = { position: Int ->
            itemClickListener?.let { it.invoke(getItem(position)) }
        }
        return TypeViewHolder(view, click)
    }

    private fun getItem(position: Int): @ParameterName(name = "item") String {
        return types[position]
    }

    override fun getItemCount() = types.size

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        holder.description.text = types[position]
    }
}
