package com.example.splitbread.fragments

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.splitbread.*
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser


class AddFragment : Fragment() {

    lateinit var groupsRecyclerView: RecyclerView
    lateinit var friendsRecyclerView: RecyclerView

    lateinit var adapter: GroupAdapter
    lateinit var madapter: FriendAdapter

    var allGroups: MutableList<Groups> = mutableListOf()
    var allFriends: MutableList<Friends> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        groupsRecyclerView = view.findViewById<RecyclerView>(R.id.groups_recyclerView)

        adapter = GroupAdapter(requireContext(), allGroups as ArrayList<Groups>)
        groupsRecyclerView.adapter = adapter
        groupsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        queryGroups()


        friendsRecyclerView = view.findViewById<RecyclerView>(R.id.friends_recyclerView)

        madapter = FriendAdapter(requireContext(), allFriends as ArrayList<Friends>)
        friendsRecyclerView.adapter = madapter
        friendsRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        queryFriends()

       view.findViewById<Button>(R.id.addgroupbutton).setOnClickListener{
            goToStartGroupActivity()
        }

        view.findViewById<Button>(R.id.addfriendbutton).setOnClickListener{
               goToAddFriendsActivity()
        }

         /*  view.findViewById<Button>(R.id.canceladd).setOnClickListener{
               goToMainActivity()
           }

           view.findViewById<TextView>(R.id.groupstextView).setOnClickListener{
               goToAddExpenseActivity()
           }

           view.findViewById<TextView>(R.id.friendstextView).setOnClickListener{
               goToAddExpenseActivity()
           } */
    }


    fun queryGroups() {

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

    fun queryFriends() {

        // Specify which class to query
        val query: ParseQuery<Friends> = ParseQuery.getQuery(Friends::class.java)

        query.include(Friends.KEY_USER)

        query.whereEqualTo(Friends.KEY_USER, ParseUser.getCurrentUser())
        query.addDescendingOrder("createdAt")
        query.findInBackground(object : FindCallback<Friends> {
            override fun done(friends: MutableList<Friends>?, e: ParseException?) {
                if (e != null) {
                    // Error
                    Log.e(TAG, "Error fetching friends" + e)
                } else {
                    if (friends != null) {
                        for (friend in friends) {
                            Log.i(TAG, "Username: " + friend.getFriendsName()
                            )
                        }

                        allFriends.addAll(friends)

                        madapter.notifyDataSetChanged()

                    }
                }
            }

        })
    }

    private fun goToAddExpenseActivity() {
        val intent = Intent(getActivity(), AddExpenseActivity::class.java)
        startActivity(intent)
    }

    private fun goToStartGroupActivity() {
        val intent = Intent(getActivity(), StartGroupActivity::class.java)
        startActivity(intent)
    }

    private fun goToAddFriendsActivity() {
        val intent = Intent(getActivity(), AddFriendsActivity::class.java)
        startActivity(intent)
    }

    private fun goToMainActivity() {
        val intent = Intent(getActivity(), MainActivity::class.java)
        startActivity(intent)
    }

    companion object{
        const val TAG = "AddFragment"
    }

}