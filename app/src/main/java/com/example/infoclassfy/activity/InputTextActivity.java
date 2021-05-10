package com.example.infoclassfy.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infoclassfy.R;

public class InputTextActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "InputTextActivity";
    EditText inputTitleEdt, inputContentEdt;
    Button inputUploadBtn;
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
                Log.d(TAG,"title = " + title);
                Log.d(TAG,"content = " + content);
                Toast.makeText(this,"上传成功",Toast.LENGTH_LONG).show();
                break;
        }

    }
}