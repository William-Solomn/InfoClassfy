package com.example.infoclassfy.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.infoclassfy.R
import java.io.File

class FileInitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_init)

    }
    fun readFile(filePath:String){
        var file=File(filePath)
        if(file.isDirectory){
            Log.d("ppp", "该路径有效"+filePath)
        }
    }
}