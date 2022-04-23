package com.example.splitbread

import android.app.Application
import com.parse.Parse
import com.parse.ParseObject

class SplitBreadApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        ParseObject.registerSubclass(Groups::class.java)
        ParseObject.registerSubclass(Friends::class.java)

        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build());
    }
}