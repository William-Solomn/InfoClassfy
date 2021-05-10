package com.example.infoclassfy.activity.HistoryRecyclerView;

public class HistoryInfo {

    private String title;//新闻标题

    private String content;//新闻内容

    private String classification;//新闻分类结果

    public HistoryInfo(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
