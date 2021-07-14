package com.example.infoclassfy.http

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.infoclassfy.activity.InputTextActivity.*
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
        fun getProbability(jsonString: String):DoubleArray{
            val jo = JSONObject(jsonString)
            maxIndex = jo.getString("max").toInt()
            result = jo.getString("result").toString()
            val textProbability = jo.getString("probability")
            val jsonArray = textProbability.toCharArray()//把list的值转为json数组对象。
            // val jsonArray= JSONArray. //把list的值转为json数组对象。

            var textProbability1=textProbability.replace("[", "")
            var textProbability2=textProbability1.replace("]", "")

            val split: List<String> = textProbability2.split(",")
            Log.d("33333", "getProbability1: " + split[0])

            val myList = DoubleArray(9)
            for (i in 0..8){
                myList[i]=java.lang.Double.parseDouble(split[i])
            }

            Log.d("33333", "getProbability2: " +
                    "maxIndex:" + maxIndex
                    + "result:" + result
                    + "textProbability" + "    " + (textProbability is String) + "    " + Arrays.toString(myList))
            return myList
        }

    }
}