package com.example.infoclassfy.http

import android.util.Log
import com.example.infoclassfy.activity.InputTextActivity.result
import com.example.infoclassfy.data.InputTextData
import okhttp3.*
import java.io.IOException


class PostText {



    fun fun1(){}
    companion object{
        fun postMessage(inputTextData: InputTextData){
            var string :String = ""
            val url = "http://39.105.116.248/news"
            Thread{

                val client = OkHttpClient()

                var formBody = FormBody.Builder()
                        .add("title", inputTextData.TextTitle)
                        .add("detail", inputTextData.TextContent)
                        .build()
                Log.d("3232", "postMessage: 到了第26行")
                val request: Request =  Request.Builder()
                        .url(url)
                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .post(formBody)
                        .build()
                formBody.contentType()

                val call: Call = client.newCall(request)
                call.enqueue(object : Callback {


                    override fun onFailure(call: Call, e: IOException) {
                        TODO("Not yet implemented")
                    }

                    override fun onResponse(call: Call, response: Response) {

                        string= response.body!!.string()
                        result=string

                        Log.d("33333", "onResponse: "+string)
                    }
                })


            }.start()


        }
    }



}