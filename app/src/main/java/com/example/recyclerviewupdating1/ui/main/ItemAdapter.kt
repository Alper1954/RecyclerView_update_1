package com.example.recyclerviewupdating1.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewupdating1.R


class ItemAdapter(private val dataset: List<String>, val callbackClickItem: (Int) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_value)
        val btn_remove: Button = view.findViewById(R.id.btn_remove) //selected button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = item
        holder.btn_remove.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                callbackClickItem(holder.adapterPosition)
                notifyDataSetChanged()
            }
        })
    }

    override fun getItemCount(): Int = dataset.size
}