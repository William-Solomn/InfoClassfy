package com.example.infoclassfy.activity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.provider.ResourceEncoderRegistry;
import com.example.infoclassfy.R;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FileUploadActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String LAG = "FileUploadActivity";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_init);
        Log.d(LAG,"ok");
        Button btn_file_commit = findViewById(R.id.btn_file_commit);
        btn_file_commit.setOnClickListener(this);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            // 用户未选择任何文件，直接返回
            return;
        }
        Uri uri = data.getData(); // 获取用户选择文件的URI
        // 通过ContentProvider查询文件路径
        ContentResolver resolver = this.getContentResolver();
        Cursor cursor = resolver.query(uri, null, null, null, null);
        if (cursor == null) {
            // 未查询到，说明为普通文件，可直接通过URI获取文件路径
            String path = uri.getPath();
            return;
        }
        if (cursor.moveToFirst()) {
            // 多媒体文件，从数据库中获取文件的真实路径
            String path = cursor.getString(cursor.getColumnIndex("_data"));
        }
        cursor.close();
    }

    // 打开系统的文件选择器
    public void pickFile(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        //this.startActivityForResult(intent, RECEIVER_VISIBLE_TO_INSTANT_APPS);
        startActivityForResult(intent,1);


    }

    // 使用OkHttp上传文件
    public void uploadFile(File file) {
        OkHttpClient client = new OkHttpClient();
        MediaType contentType = MediaType.parse("text/plain"); // 上传文件的Content-Type
        RequestBody body = RequestBody.create(contentType, file); // 上传文件的请求体
        Request request = new Request.Builder()
                .url("39.105.116.248/file") // 上传地址
                .post(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                // 文件上传失败
                Log.i("Haoxueren", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // 文件上传成功
                if (response.isSuccessful()) {
                    Log.i("Haoxueren", "onResponse: " + response.body().string());
                } else {
                    Log.i("Haoxueren", "onResponse: " + response.message());
                }
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_file_commit:
                pickFile(v);
                break;
            default:
                break;
        }

    }


}
