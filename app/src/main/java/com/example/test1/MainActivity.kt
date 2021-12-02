package com.example.test1

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest
import com.github.dhaval2404.imagepicker.ImagePicker;

var uri: Uri=Uri.parse("")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val loadImage = findViewById<Button>(R.id.loadBtn)
        loadImage.setOnClickListener {
            ImagePicker.with(this)
                //.galleryOnly()
                //.cropSquare()	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                //.maxResultSize(50, 50)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start();
        }

        val actionBar =  supportActionBar
        actionBar!!.title = "Mobile Development Team"

        val secondActivityBtn = findViewById<Button>(R.id.secondActivityBtn)
        secondActivityBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.setData(uri)
            startActivity(intent)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
         uri = data?.data!!
         val msgConfirm = findViewById<TextView>(R.id.textConfirmation)
         msgConfirm.setVisibility(View.VISIBLE)

    }
}