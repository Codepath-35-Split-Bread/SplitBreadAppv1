package com.example.splitbread

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.splitbread.fragments.AddFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.splitbread.fragments.GroupsFragment
import com.example.splitbread.fragments.FriendsFragment
import com.parse.*
import java.io.File



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager

        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener{

                item ->

            var fragmentToShow: Fragment? = null
            when(item.itemId){

                R.id.groups -> {
                    fragmentToShow = GroupsFragment()
                }
               R.id.friends -> {
                    fragmentToShow = FriendsFragment()
               }
                R.id.add -> {
                    fragmentToShow = AddFragment()
                }
                R.id.activity -> {
                    Toast.makeText(this,"Activity Screen",Toast.LENGTH_SHORT).show()
                }
                R.id.profile -> {
                    Toast.makeText(this,"Profile Screen",Toast.LENGTH_SHORT).show()
                }
            }

            if (fragmentToShow != null){
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()
            }
            //Returning true says that we've handled the user interaction on the item
            true
        }

        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.friends

        /*val btnAddFriends = findViewById<Button>(R.id.addFriends)

        btnAddFriends.setOnClickListener{
            startActivity(Intent(this,AddFriendsActivity::class.java))
        } */
    }

    companion object{
        const val TAG = "MainActivity"
    }
}