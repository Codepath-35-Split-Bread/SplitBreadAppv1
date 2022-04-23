package com.example.splitbread

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroupFragAdapter(val context: Context, val groups: List<Groups>) :
    RecyclerView.Adapter<GroupFragAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupFragAdapter.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.fragment_groups, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupFragAdapter.ViewHolder, position: Int) {
        val group = groups.get(position)
        holder.bind(group)
    }

    override fun getItemCount(): Int {
        return groups.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProfile = itemView.findViewById<ImageView>(R.id.ivProfile)
        val tvGroupName = itemView.findViewById<TextView>(R.id.tvGroupName)
        val tvGroupBalance = itemView.findViewById<TextView>(R.id.tvBalance)

        /*   init {
               groupstextview = itemView.findViewById(R.id.groupstextView)
           } */

        fun bind(group: Groups){
            tvGroupName.text = group.getGroupName()
            tvGroupBalance.text = group.getExpense().toString()

        }
    }
}
