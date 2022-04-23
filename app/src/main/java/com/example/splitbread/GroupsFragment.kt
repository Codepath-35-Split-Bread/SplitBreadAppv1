package com.example.splitbread

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser

class GroupsFragment : Fragment() {

    lateinit var groupsRecyclerView: RecyclerView

    lateinit var adapter: GroupAdapter

    var allGroups: MutableList<Groups> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_groups, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // set up views and click listeners

        groupsRecyclerView = view.findViewById(R.id.groupsRecyclerView)

        // Steps to populate RecyclerView
        // 1. create layout for each row in list
        // 2. create data source for each row(Post class)
        // 3. create adapter that will bridge data and row layout
        // 4. set adapter on RecyclerView
        adapter = GroupAdapter(requireContext(), allGroups as ArrayList<Groups>)
        groupsRecyclerView.adapter = adapter
        // 5. set layout manager on RecyclerView
        groupsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        queryGroups()
    }

    open fun queryGroups() {

        // Specify which class to query
        val query: ParseQuery<Groups> = ParseQuery.getQuery(Groups::class.java)

        query.include(Groups.KEY_USER)
        query.whereEqualTo(Groups.KEY_USER, ParseUser.getCurrentUser())
        query.addDescendingOrder("createdAt")
        query.findInBackground(object : FindCallback<Groups> {
            override fun done(groups: MutableList<Groups>?, e: ParseException?) {
                if (e != null) {
                    // Error
                    Log.e(TAG, "Error fetching groups" + e)
                } else {
                    if (groups != null) {
                        for (group in groups) {
                            Log.i(TAG, "Group Name: " + group.getGroupName()
                            )
                        }

                        allGroups.addAll(groups)
                        adapter.notifyDataSetChanged()

                    }
                }
            }

        })
    }

    companion object {
        const val TAG = "FeedFragment"
    }
}