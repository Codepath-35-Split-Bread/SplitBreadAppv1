package com.example.splitbread

import com.parse.ParseClassName
import com.parse.ParseObject
import com.parse.ParseUser
import org.json.JSONArray

@ParseClassName("Groups")
class Groups : ParseObject() {

    // 1. get and set for user
    fun setUser(User: ParseUser){
        put(KEY_USER, User)
    }

    fun getUser(): ParseUser? {
        return getParseUser(KEY_USER)
    }

    // 2. get and set for group Name
    fun getGroupName() : String? {
        return getString(KEY_GROUP_NAME)
    }

    fun setGroupName(GroupName: String){
        put(KEY_GROUP_NAME, GroupName)
    }

    // 3. get and set for Description
    fun getDescription() : String? {
        return getString(KEY_DESCRIPTION)
    }

    fun setDescription(Description: String){
        put(KEY_DESCRIPTION, Description)
    }

    // 4. get and set for Expense
    fun getExpense() : Int? {
        return getInt(KEY_EXPENSE)
    }

    fun setExpense(Expense: Int){
        put(KEY_DESCRIPTION, Expense)
    }

    // 5. get and set for Members
    fun getMembers() : JSONArray? {
        return getJSONArray(KEY_MEMBERS)
    }

    fun setMembers(Members: JSONArray){
        put(KEY_DESCRIPTION, Members)
    }

    companion object{
        const val KEY_USER = "User"
        const val KEY_GROUP_NAME = "GroupName"
        const val KEY_DESCRIPTION = "Description"
        const val KEY_EXPENSE = "Expense"
        const val KEY_MEMBERS = "Members"
    }
}