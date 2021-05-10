package com.example.infoclassfy.activity;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.infoclassfy.R;
import com.example.infoclassfy.activity.HistoryRecyclerView.HistoryInfo;
import com.example.infoclassfy.activity.HistoryRecyclerView.HistoryInfoAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class HistoryInfoActivity extends AppCompatActivity {

    List<HistoryInfo>historyInfoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_info);

        initData();
        RecyclerView recyclerView = findViewById(R.id.history_recView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        final HistoryInfoAdapter historyInfoAdapter = new HistoryInfoAdapter(historyInfoList);
        recyclerView.setAdapter(historyInfoAdapter);

    }


    private void initData(){
        //SimpleDateFormat formatter   =   new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
        //Date curDate =  new Date(System.currentTimeMillis());
        //String   time   =   formatter.format(curDate);
        Random random = new Random();
        //for(int i = 0; i < random.nextInt(5)+1; i++){
        for(int i = 0; i < 10; i++){
            HistoryInfo historyInfo = new HistoryInfo("重大喜讯",getRandomLengthContent("软件本新闻文本分类Android正在开发中，敬请期待！ "));
            historyInfoList.add(historyInfo);
        }
    }

    private  String getRandomLengthContent(String content){
        Random random=new Random();
        int length=random.nextInt(20)+1;
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<length;i++){
            builder.append(content);
        }
        return builder.toString();
    }
}