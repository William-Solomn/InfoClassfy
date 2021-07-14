package com.example.infoclassfy.http

import okhttp3.*
import java.io.File

class PostFile {
    fun postFile(file:File) {
//        Thread {
//            try {
//                val url = "http://" +  + "/upload"
//                val file = File("/sdcard/image.png")
//                val fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file)
//                val requestBody = MultipartBody.Builder()
//                        .setType(MultipartBody.FORM)
//                        .addFormDataPart("uploadfile", "image.png", fileBody)
//                        .build()
//                val request = Request.Builder()
//                        .url(url)
//                        .post(requestBody)
//                        .build()
//                val httpBuilder = OkHttpClient.Builder()
//                val okHttpClient = httpBuilder
//                        .connectTimeout(10, java.util.concurrent.TimeUnit.SECONDS)
//                        .writeTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
//                        .build()
//                val response = okHttpClient.newCall(request).execute()
//                val responseStr = response.body?.string()
//
//            } catch (e: Exception) {
//
//            }
//        }.start()
    }
}