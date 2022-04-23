package com.example.splitbread

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.parse.FindCallback
import com.parse.ParseException
import com.parse.ParseQuery
import com.parse.ParseUser

class AddActivity : AppCompatActivity() {

    lateinit var groupsRecyclerView: RecyclerView
    lateinit var friendsRecyclerView: RecyclerView

    lateinit var adapter: GroupAdapter
    lateinit var madapter: FriendAdapter

    var allGroups: MutableList<Groups> = mutableListOf()
    var allFriends: MutableList<Friends> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        findViewById<TextView>(R.id.groupstextView).setOnClickListener{
            goToAddExpenseActivity()
        }

        findViewById<TextView>(R.id.friendstextView).setOnClickListener{
            goToAddExpenseActivity()
        }


    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        groupsRecyclerView = findViewById<RecyclerView>(R.id.groups_recyclerView)

        adapter = GroupAdapter(this, allGroups as ArrayList<Groups>)
        groupsRecyclerView.adapter = adapter
        groupsRecyclerView.layoutManager = LinearLayoutManager(this)

        queryGroups()


        friendsRecyclerView = findViewById<RecyclerView>(R.id.friends_recyclerView)

        madapter = FriendAdapter(this, allFriends as ArrayList<Friends>)
        friendsRecyclerView.adapter = adapter
        friendsRecyclerView.layoutManager = LinearLayoutManager(this)

        queryFriends()
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

    open fun queryFriends() {

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
                            Log.i(TAG, "Username: " + friend.getUser()?.username
                            )
                        }

                        allFriends.addAll(friends)
                        adapter.notifyDataSetChanged()

                    }
                }
            }

        })
    }

    private fun goToAddExpenseActivity() {
        val intent = Intent(this@AddActivity, AddExpenseActivity::class.java)
        startActivity(intent)
        finish()
    }

/*    private fun goToAddExpenseActivity() {
        val intent = Intent(this@AddActivity, AddExpenseActivity::class.java)
        startActivity(intent)
        finish()
    }*/

    companion object{
        const val TAG = "AddActivity"
    }

}