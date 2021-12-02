package com.example.test1

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val uri: Uri? = intent.data;
        setContentView(R.layout.activity_second)

        val loadedImage = findViewById<ImageView>( R.id.imageViewLoaded2)
        // Use Uri object instead of File to avoid storage permissions
        loadedImage.setImageURI(uri)

        val actionBar =  supportActionBar
        actionBar!!.title = "Start Detection"
        actionBar.setDisplayHomeAsUpEnabled(true)

    }
}