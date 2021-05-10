package com.example.infoclassfy.activity

import android.content.Intent
import android.os.Bundle
import android.provider.DocumentsProvider
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.example.infoclassfy.MainActivity.filePath
import com.example.infoclassfy.R
import com.example.infoclassfy.data.fileType
import com.example.infoclassfy.methods.getFileName.*
import kotlinx.android.synthetic.main.activity_file_init.*
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.lang.Exception

class FileInitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_init)

        fileInfo(filetype)
        tv_typeText.setText(getFilename(filePath))

        btnFileCommit.setOnClickListener{
            try {
                val file=File(filePath)
                val intent = Intent("android.intent.action.VIEW")
                intent.addCategory("android.intent.category.DEFAULT")
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

//                val uri=Uri.fromFile(file)

                val uri= FileProvider.getUriForFile(this,application.packageName+".provider",file)

                intent.setDataAndType(uri,"application/vnd.ms-excel")
                Log.d("555", "图片被单击")
                startActivity(intent)
            }catch (e:Exception){
                Toast.makeText(this,"这有问题"+e,Toast.LENGTH_SHORT).show()
                Log.d("555", "onCreate: "+e)
            }

    }

    }
    fun readFile(filePath:String){
        var file=File(filePath)
        if(file.isDirectory){
            Log.d("ppp", "该路径有效"+filePath)
        }
    }
    fun fileInfo(s:String){
        when(s){
            "0"->{
                iv_typePic.setImageResource(R.drawable.xlsx_icon)

                }
            "1"->{
                iv_typePic.setImageResource(R.drawable.txt_icon)
            }
            "2"->{
                iv_typePic.setImageResource(R.drawable.xls_icon)
            }
        }
    }
    fun getFileContent(file:File):String{
        var content=""
        if(!file.isDirectory){
            if(file.name.endsWith("txt")){
                val instream=FileInputStream(file)

                val inputreader=InputStreamReader(instream,"UTF-8")
                val bufferedReader=BufferedReader(inputreader)
                var line=""


            }
        }
        return ""
    }

}