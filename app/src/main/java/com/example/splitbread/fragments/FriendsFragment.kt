package com.example.splitbread.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.splitbread.FriendFragAdapter
import com.example.splitbread.Friends
import com.example.splitbread.R
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser

open class FriendsFragment : Fragment() {

    lateinit var friendsRecyclerView: RecyclerView

    lateinit var adapter: FriendFragAdapter

    var allFriends: MutableList<Friends> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_friends, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // set up views and click listeners

        friendsRecyclerView = view.findViewById(R.id.FriendsRecyclerView)

        adapter = FriendFragAdapter(requireContext(), allFriends as ArrayList<Friends>)
        friendsRecyclerView.adapter = adapter
        friendsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        queryGroups()
    }

    open fun queryGroups() {

        // Specify which class to query
        val query: ParseQuery<Friends> = ParseQuery.getQuery(Friends::class.java)

        query.include(Friends.KEY_USER)
        query.whereEqualTo(Friends.KEY_USER, ParseUser.getCurrentUser())
        query.addDescendingOrder("createdAt")

        query.findInBackground(object : FindCallback <Friends> {
            override fun done(friends: MutableList<Friends>?, e: ParseException?) {
                if (e != null) {
                    // Error
                    Log.e(TAG, "Error fetching friends" + e)
                } else {
                    if (friends != null) {
                        for (friend in friends) {
                            Log.i(
                                TAG, "Friend's Name: " + friend.getFriendsName()
                            )
                        }

                        allFriends.addAll(friends)
                        adapter.notifyDataSetChanged()

                    }
                }
            }

        })
    }

    companion object {
        const val TAG = "FriendFragment"
    }
}