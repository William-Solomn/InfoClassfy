package com.example.infoclassfy.http

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File
import java.io.IOException

class RemoteServer {
    private val client = OkHttpClient()

    fun postString(url:String,postbody:String) {

        /*
        val postBody = """
        |Releases
        |--------
        |
        | * _1.0_ May 6, 2013
        | * _1.1_ June 15, 2013
        | * _1.2_ August 11, 2013
        |""".trimMargin()

        */

        val request = Request.Builder()
                .url(url)
                .post(postbody.toRequestBody(MEDIA_TYPE_MARKDOWN))
                .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            println(response.body!!.string())
        }
    }
    fun postFile(url:String,file:File){
        var request = Request.Builder()
                .url(url)
                .post(file.asRequestBody(MEDIA_TYPE_MARKDOWN))
                .build()

        client.newCall(request).execute().use{ response->
            
        }

    }
    companion object {
        val MEDIA_TYPE_MARKDOWN = "text/x-markdown; charset=utf-8".toMediaType()
    }
}