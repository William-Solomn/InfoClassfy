package com.example.infoclassfy.activity;


import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.infoclassfy.MainActivity;
import com.example.infoclassfy.R;
import com.example.infoclassfy.activity.HistoryRecyclerView.HistoryInfo;
import com.example.infoclassfy.methods.MaskImageView;
import com.zhouwei.blurlibrary.EasyBlur;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "HomePageActivity";
    //必应背景图片
    private MaskImageView bingPicImg;
    //bgPicture类用于 获取加载链接
    private bgPicture bgPicforUrl = new bgPicture();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        Button btn_home_txtInput = findViewById(R.id.btn_home_txtInput);
        Button btn_home_fileInput = findViewById(R.id.btn_home_fileInput);
        Button btn_home_history = findViewById(R.id.btn_home_history);
        //设置Button监听
        btn_home_txtInput.setOnClickListener(this);
        btn_home_fileInput.setOnClickListener(this);
        btn_home_history.setOnClickListener(this);

        if(Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
                    getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        //设置Button透明度
        View vTxt = findViewById(R.id.btn_home_txtInput);
        vTxt.getBackground().setAlpha(60);
        View vFile = findViewById(R.id.btn_home_fileInput);
        vFile.getBackground().setAlpha(100);
        /*View vHis = findViewById(R.id.btn_home_history);
        vHis.getBackground().setAlpha(80);*/

        //设置必应每日一图
        bingPicImg = (MaskImageView) findViewById(R.id.imgView_homeBg_bingPic);
        if(bgPicforUrl.getBingPicURL()==null){
            //调用loadBingPic()方法开始加载
            Log.d("HomePageActivity","Class bgPicture - sendOkHttpRequest will be on");
            bgPicforUrl.loadBingPic();
            if(bgPicforUrl.getBingPicURL()==null){
                Log.d("HomePageActivity","Class bgPicture - sendOkHttpRequest Fail"+bgPicforUrl.getBingPicURL());
            }else{
                String url = bgPicforUrl.getBingPicURL();//"https://cn.bing.com/th?id=OHR.LighthouseWave_ZH-CN5731015881_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp";
                Log.d("HomePageActivity","第二次加载成功"+url);
                Glide.with(this).load(url)
                        //设置高斯模糊
                        .apply(bingPicImg.setGaussBlur())//这是重点
                        .into(bingPicImg);
                bingPicImg.setMaskColor(1);//设置蒙版颜色
                //bingPicImg.showMask();//显示蒙版
                //bingPicImg.dismissMask();//隐藏蒙版
            }

        }else{
            Log.d("HomePageActivity",bgPicforUrl.getBingPicURL());
            String url = "https://cn.bing.com/th?id=OHR.SharkAwareness_ZH-CN6069597614_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp";//"https://cn.bing.com/th?id=OHR.LighthouseWave_ZH-CN5731015881_1920x1080.jpg&rf=LaDigue_1920x1080.jpg&pid=hp";
            Glide.with(this).load(url)
                    //设置高斯模糊
                    .apply(bingPicImg.setGaussBlur())//这是重点
                    .into(bingPicImg);
            bingPicImg.setMaskColor(1);//设置蒙版颜色
            //bingPicImg.showMask();//显示蒙版
            //bingPicImg.dismissMask();//隐藏蒙版
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_home_txtInput:
                Toast.makeText(this,"单挑输入",Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_home_fileInput:
                Toast.makeText(this,"文件导入",Toast.LENGTH_LONG).show();
                Intent file_intent = new Intent(HomePageActivity.this, FileUploadActivity.class);
                startActivity(file_intent);
                break;
            case R.id.btn_home_history:
                Toast.makeText(this,"历史记录",Toast.LENGTH_LONG).show();
                Intent history_intent = new Intent(HomePageActivity.this, HistoryInfoActivity.class);
                startActivity(history_intent);
                break;
            default:
                break;
        }

    }
}
