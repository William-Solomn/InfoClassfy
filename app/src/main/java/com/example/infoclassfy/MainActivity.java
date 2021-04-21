package com.example.infoclassfy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class MainActivity extends AppCompatActivity {
    private Button btn_fileInit;
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
                intent.setType("text/plain");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
               intent.setType("file/*.txt;file/*xls");
                startActivityForResult(intent, 0);

            }
        });
    }
}