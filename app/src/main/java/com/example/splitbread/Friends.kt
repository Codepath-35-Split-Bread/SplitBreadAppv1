package com.example.splitbread

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser

@ParseClassName("Friends")
class Friends : ParseObject() {

    // 1. get and set for user
    fun setUser(User: ParseUser){
        put(KEY_USER, User)
    }

    fun getUser(): ParseUser? {
        return getParseUser(KEY_USER)
    }

    // 2. get and set for group Name
    fun getFriendsName() : String? {
        return getString(KEY_FRIENDS_NAME)
    }

    fun setFriendsName(FriendsName: String){
        put(KEY_FRIENDS_NAME, FriendsName)
    }

    // 3. get and set for Description
    fun getDescription() : String? {
        return getString(KEY_DESCRIPTION)
    }

    fun serDescription(Description: String){
        put(KEY_DESCRIPTION, Description)
    }

    // 4. get and set for Expense
    fun getExpense() : Int? {
        return getInt(KEY_EXPENSE)
    }

    fun setExpense(Expense: Int){
        put(KEY_DESCRIPTION, Expense)
    }


    companion object{
        const val KEY_USER = "User"
        const val KEY_FRIENDS_NAME = "FriendsName"
        const val KEY_DESCRIPTION = "Description"
        const val KEY_EXPENSE = "Expense"
    }
}