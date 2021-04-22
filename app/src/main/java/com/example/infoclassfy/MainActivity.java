package com.example.infoclassfy;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Button btn_fileInit;
    public static final String XLS = "application/vnd.ms-excel application/x-excel";
    public static final String XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_fileInit=findViewById(R.id.fileInit);


        btn_fileInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用系统文件管理器打开指定路径目录
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                 //intent.setDataAndType(Uri.fromFile(dir.getParentFile()), "file/*.txt");
                //intent.setType("file/*.txt"); //华为手机mate7不支持
                intent.setType("text/plain|XLS|XLSX");
                intent.addCategory(Intent.CATEGORY_OPENABLE);

                startActivityForResult(intent, 0);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(getApplicationContext(),"文件的内容是："+String.valueOf(resultCode),Toast.LENGTH_LONG);
        Log.d("2222", String.valueOf(data));
    }
}