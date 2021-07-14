package com.example.infoclassfy.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.infoclassfy.R;
import com.example.infoclassfy.data.InputTextData;
import com.example.infoclassfy.echarts.EChartOptionUtil;
import com.example.infoclassfy.echarts.EChartView;
import com.example.infoclassfy.http.ParsingTextData;
import com.example.infoclassfy.http.PostText;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;


public class InputTextActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "33333";
    EditText inputTitleEdt, inputContentEdt;
    Button inputUploadBtn;
//    private EChartView barChart;

    public static InputTextData inputTextData;//  Property values can be viewed globally
    public static String result;

    Animation animation;        //animation about EditText&Button
    private String title, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_text);

        inputTitleEdt = findViewById(R.id.input_title_edt);
        inputContentEdt = findViewById(R.id.input_content_edt);
        inputUploadBtn = findViewById(R.id.input_upload_btn);
//        barChart = findViewById(R.id.barChart);


//        barChart.setWebViewClient(new WebViewClient(){
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                refreshBarChart();
//            }
//        });
        inputUploadBtn.setOnClickListener(this);






    }

//    private void refreshBarChart() {
//        //定义一个数组x，用来显示星期几
//        Object[] x = new Object[]{
//                "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
//        };
//        //用来显示每天对应的数据
//        Object[] y = new Object[]{
//                820, 932, 901, 934, 1290, 1330, 1320
//        };
//        //刷新图标
//        barChart.refreshEchartsWithOption(EChartOptionUtil.getBarChartOptions(x,y));
//    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.input_upload_btn:

                result=null;//这里要是改成result = "";就会闪退

                title = inputTitleEdt.getText().toString();
                content = inputContentEdt.getText().toString();
                inputTextData = new InputTextData(title,content);
                Log.d(TAG,"title = " + title);
                Log.d(TAG,"content = " + content);

//                Log.d("3232", "onClick: "+PostText.Companion.postMessage(inputTextData)); //使用kotlin的伴生类实现方法的静态化
//                Log.d("22222", "onClick: "+ParsingTextData.Companion.getTexts(this,inputTextData));
//
//                Toast.makeText(this,"上传成功"+ParsingTextData.Companion.getTexts(this,inputTextData),Toast.LENGTH_LONG).show();

                PostText.Companion.postMessage(inputTextData);
                while (true){
                    if(result!=null){
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            Log.d(TAG, "onClick: "+ParsingTextData.Companion.getTexts(result));
                        }
                        break;

                    }
                }
                Intent intent = new Intent(this,ResultView.class);
                startActivity(intent);
                break;
        }

    }
}