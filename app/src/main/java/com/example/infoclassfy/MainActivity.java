package com.example.infoclassfy;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.infoclassfy.activity.FileInitActivity;
import com.example.infoclassfy.activity.HistoryInfoActivity;

import org.jetbrains.annotations.NotNull;

import static com.example.infoclassfy.data.getFileName.getFilename;


public class MainActivity extends AppCompatActivity {
    private Button btn_fileInit;
    private Button btn_historyInfo;
    private Button btn_inputText;

    public static String filePath;

    public static final String XLS = "application/vnd.ms-excel application/x-excel";
    public static final String XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_fileInit=findViewById(R.id.fileInit);
        btn_historyInfo = findViewById(R.id.historyInfo);
        btn_inputText = findViewById(R.id.inputText);

        listener();




    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        assert data != null;
        if(!getFilename(data.toString()).equals("file error")){
            Intent intent = new Intent(MainActivity.this,FileInitActivity.class);
            startActivity(intent);
        }
        Toast.makeText(getApplicationContext(),"文件的路径是："+getFilename(data.toString()),Toast.LENGTH_LONG).show();
        filePath=getFilename((data.toString()));
        Log.d("sss", String.valueOf(data));

        Log.d("2222", getFilename(data.toString()));

    }



    private void listener(){
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
        btn_historyInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HistoryInfoActivity.class);
                startActivity(intent);
            }
        });
        btn_inputText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FileInitActivity.class);
                startActivity(intent);
            }
        });
    }
}