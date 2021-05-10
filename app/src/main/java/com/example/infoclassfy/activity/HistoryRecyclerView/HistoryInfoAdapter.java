package com.example.infoclassfy.activity.HistoryRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import com.example.infoclassfy.R;

import java.util.List;

public class HistoryInfoAdapter extends RecyclerView.Adapter<HistoryInfoAdapter.ViewHolder> {

    public List<HistoryInfo>mHistoryInfoList;//全局变量

    public HistoryInfoAdapter(List<HistoryInfo> HistoryInfoList){
        mHistoryInfoList = HistoryInfoList;
    }


    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, content, classification;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.history_item_title_tv);
            content = itemView.findViewById(R.id.history_item_content_tv);
            classification = itemView.findViewById(R.id.history_item_classification_tv);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_info_item,parent,false);
        final ViewHolder historyViewHolder = new ViewHolder(view);
        historyViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(), "即将跳转至数据统计界面", Toast.LENGTH_LONG).show();
            }
        });
        return historyViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HistoryInfo historyInfo = mHistoryInfoList.get(position);
        holder.title.setText(historyInfo.getTitle());
        holder.content.setText(historyInfo.getContent());
        holder.classification.setText(historyInfo.getClassification());
    }

    @Override
    public int getItemCount() {
        return mHistoryInfoList.size();
    }





}
