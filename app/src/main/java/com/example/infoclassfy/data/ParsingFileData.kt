package com.example.infoclassfy.data

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.core.content.FileProvider
import com.example.infoclassfy.MainActivity.filePath
import java.io.BufferedReader
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URI


fun parsingFileData(context:Context) {

    val file = File(filePath)
    val uri:Uri
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
        uri = FileProvider.getUriForFile(context,context.packageName+".fileprovider",
                file)
    }else{
        uri = Uri.fromFile(file)
    }
    context.grantUriPermission(context.packageName,uri, Intent.FLAG_GRANT_READ_URI_PERMISSION)


}