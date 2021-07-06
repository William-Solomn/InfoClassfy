package com.example.infoclassfy.activity;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infoclassfy.R;
import com.example.infoclassfy.data.InputTextData;

public class InputTextActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "InputTextActivity";
    EditText inputTitleEdt, inputContentEdt;
    Button inputUploadBtn;

    public static InputTextData inputTextData;              //  Property values can be viewed globally

    Animation animation;        //animation about EditText&Button
    private String title, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_text);

        inputTitleEdt = findViewById(R.id.input_title_edt);
        inputContentEdt = findViewById(R.id.input_content_edt);
        inputUploadBtn = findViewById(R.id.input_upload_btn);

        inputUploadBtn.setOnClickListener(this);







    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.input_upload_btn:
                title = inputTitleEdt.getText().toString();
                content = inputContentEdt.getText().toString();
                inputTextData = new InputTextData(title,content);
                Log.d(TAG,"title = " + title);
                Log.d(TAG,"content = " + content);
                Toast.makeText(this,"上传成功",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this,ResultView.class);
                startActivity(intent);
                break;
        }

    }
}