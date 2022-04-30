package com.example.splitbread

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FriendAdapter(val context: Context, val friends: List<Friends>)
    : RecyclerView.Adapter<FriendAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendAdapter.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.friends, parent, false)
        return FriendAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val friend = friends.get(position)
        holder.bind(friend)
    }

    override fun getItemCount(): Int {
        return friends.size
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val friendstextView: TextView

        init {
            friendstextView = itemView.findViewById(R.id.friendstextView)
        }

        fun bind(friend: Friends){
            friendstextView.text = friend.getFriendsName()
        }
    }

}