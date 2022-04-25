package com.example.splitbread

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroupFragAdapter(val context: Context, val groups: MutableList<Groups>) : RecyclerView.Adapter<GroupFragAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupFragAdapter.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_groups, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroupFragAdapter.ViewHolder, position: Int) {
        val group = groups.get(position)
        holder.bind(group)
    }

    override fun getItemCount(): Int {
        return groups.size
    }

    // Clean all elements of the recycler
    fun clear() {
        groups.clear()
        notifyDataSetChanged()
    }

    // Add a list of items -- change to type used
    fun addAll(groupList: List<Groups>) {
        groups.addAll(groupList)
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvGroupName: TextView
        val ivProfile: ImageView
        val tvBalance: TextView

        init{
            tvGroupName = itemView.findViewById(R.id.tvGroupName)
            ivProfile = itemView.findViewById(R.id.ivProfile)
            tvBalance = itemView.findViewById(R.id.tvBalance)
        }

        fun bind(group: Groups){
            tvBalance.text = group.getExpense().toString()
            tvGroupName.text = group.getGroupName()

            /* Glide.with(itemView.context).load(group.getImage()?.url).into(ivImage) */
        }
    }
}
