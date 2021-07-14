package com.example.infoclassfy.http

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import org.json.JSONObject
import java.util.*

class ParsingTextData {
    fun fun1(){}
    companion object{
        @RequiresApi(Build.VERSION_CODES.O)
        fun getTexts(resultBase64: String): String {
            val jo = JSONObject(resultBase64)
            val base64string=JSONObject(jo.getString("data")).getString("result").toString()


            //将result的base64编码解析出来
            val decoder = Base64.getDecoder()

            val bytes: ByteArray = decoder.decode(base64string)

            val text = String(bytes)

            return text
        }

    }
}