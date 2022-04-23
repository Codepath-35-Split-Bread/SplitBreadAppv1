package com.example.splitbread

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.FileProvider
import com.parse.ParseFile
import com.parse.ParseUser
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class StartGroupActivity : AppCompatActivity() {

/*    val CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1034
    val photoFileName = "photo.jpg"
    var photoFile: File? = null

    lateinit var ivPreview: ImageView*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_group)

/*        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View? {*/
        //return inflater.inflate(R.layout.activity_start_group, container, false)

        findViewById<ImageView>(R.id.creategroupbutton).setOnClickListener {

            val groupName = findViewById<EditText>(R.id.groupnameinput).text.toString()

            // TODO: add members array

            createGroup(groupName)
        }
    }



    fun createGroup(groupName: String) {
        val group = Groups()

        group.setGroupName(groupName)
        group.saveInBackground { exception ->
            if (exception != null) {
                Log.e(TAG, "Error while saving")
                exception.printStackTrace()
                Toast.makeText(this, "Error saving", Toast.LENGTH_SHORT).show()
            } else {
                Log.i(TAG, "Successfully saved")
                goToAddExpenseActivity()
            }
        }
    }

    private fun goToAddExpenseActivity() {
        val intent = Intent(this@StartGroupActivity, AddExpenseActivity::class.java)
        startActivity(intent)
        finish()
    }

    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivPreview = view.findViewById(R.id.groupimage)

        view.findViewById<Button>(R.id.creategroupbutton).setOnClickListener {

            val groupName = view.findViewById<EditText>(R.id.groupnameinput).text.toString()
            val user = ParseUser.getCurrentUser()
            if (photoFile != null) {
                createGroup(groupName, user, photoFile!!)
            } else {
                (photoFile as Nothing?)?.printStackTrace()
                Toast.makeText(this, "Error signing up", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<ImageView>(R.id.groupimage).setOnClickListener {
            onLaunchCamera()
        }
    }

    fun onLaunchCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        photoFile = getPhotoFileUri(photoFileName)

        if (photoFile != null) {
            val fileProvider: Uri =
                FileProvider.getUriForFile(this, "com.codepath.fileprovider", photoFile!!)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider)

            if (intent.resolveActivity(this.packageManager) != null) {
                startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE)
            }
        }
    }

    fun getPhotoFileUri(fileName: String): File {
        val mediaStorageDir =
            File(this.getExternalFilesDir(Environment.DIRECTORY_PICTURES), TAG)

        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()) {
            Log.d(TAG, "failed to create directory")
        }

        return File(mediaStorageDir.path + File.separator + fileName)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == AppCompatActivity.RESULT_OK) {
                val takenImage = BitmapFactory.decodeFile(photoFile!!.absolutePath)

                ivPreview.setImageBitmap(takenImage)
            } else {
                Toast.makeText(this, "Picture wasn't taken!", Toast.LENGTH_SHORT).show()
            }
        }
    }*/
    
    companion object{
        const val TAG = "StartGroupActivity"
    }
}