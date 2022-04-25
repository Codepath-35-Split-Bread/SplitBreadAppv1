package com.example.splitbread

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.security.acl.Group

class FriendFragAdapter(val context: Context, val friends: MutableList<Friends>) : RecyclerView.Adapter<FriendFragAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendFragAdapter.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_friends,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendFragAdapter.ViewHolder, position: Int) {
        val friend = friends.get(position)
        holder.bind(friend)
    }

    override fun getItemCount(): Int {
        return friends.size
    }

    // Clean all elements of the recycler
    fun clear() {
        friends.clear()
        notifyDataSetChanged()
    }

    // Add a list of items -- change to type used
    fun addAll(friendList: List<Friends>) {
        friends.addAll(friendList)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvFriendsName: TextView
        val ivFriendsProfile: ImageView
        val tvFriendsBalance: TextView

        init{
            tvFriendsName = itemView.findViewById(R.id.tvFriendsName)
            ivFriendsProfile = itemView.findViewById(R.id.ivFriendsProfile)
            tvFriendsBalance = itemView.findViewById(R.id.tvFriendsBalance)
        }

        fun bind(friend: Friends){
            tvFriendsBalance.text = friend.getExpense().toString()
            tvFriendsName.text = friend.getFriendsName()

           /* Glide.with(itemView.context).load(group.getImage()?.url).into(ivImage) */
        }
    }
}