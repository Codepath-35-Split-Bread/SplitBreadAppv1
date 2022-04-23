package com.example.splitbread

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroupAdapter(val context: Context, val groups: List<Groups>)
    : RecyclerView.Adapter<GroupAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupAdapter.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.groups, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupAdapter.ViewHolder, position: Int) {
        val group = groups.get(position)
        holder.bind(group)
    }

    override fun getItemCount(): Int {
        return groups.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val groupstextview: TextView

        init {
            groupstextview = itemView.findViewById(R.id.groupstextView)
        }

        fun bind(group: Groups){
            groupstextview.text = group.getGroupName()
        }
    }

}