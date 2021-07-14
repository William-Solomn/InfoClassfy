package com.example.infoclassfy.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.example.infoclassfy.activity.HomePageActivity;
import com.example.infoclassfy.http.HttpUtil;
import com.example.infoclassfy.methods.BingPic;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static android.view.View.GONE;
import static java.security.AccessController.getContext;

public class bgPicture {
    private String bingPicURL = new String();
    public String getBingPicURL(){
        Log.d("bgPicture","getBingPicURL-LoadBingPic url is:" + bingPicURL);
        return this.bingPicURL;
    }

    public void loadBingPic(){
        String requestBingpic = "https://api.xygeng.cn/Bing/url/";
        Log.d("bgPicture","LoadBingPic sendOk will be on");

        HttpUtil.sendOkHttpRequest(requestBingpic, new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.d("bgPicture","LoadBingPic sendOk fail");
                        e.printStackTrace();
                    }
                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String bingPicJson = response.body().string();//获取必应背景图的链接
                        bingPicURL = parseJSONWithGSON(bingPicJson);//从Json中获取url
                        Log.d("bgPicture","LoadBingPic url is:" + bingPicURL);


                    }
                }
        );
    }

    private String parseJSONWithGSON(String jsonData){
        Gson gson = new Gson();
        String  bingPic = gson.fromJson(jsonData, BingPic.class).getData();
        if (bingPic.startsWith("http://")) {
            bingPic = bingPic.replace("http://", "https://");
        }
        return bingPic;
    }

}
