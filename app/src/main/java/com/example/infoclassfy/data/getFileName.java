package com.example.infoclassfy.data;

import android.util.Log;

import java.io.File;

public class getFileName {
    public static String getFilename(String filename){

        //上传文件的类型仅限于“.txt”、“.xls”、“。xlsx”
        if(filename.contains(".xlsx")){
            return filename.substring(filename.lastIndexOf("//")+2,filename.indexOf(".xlsx")+5);
        }else if(filename.contains(".txt")){
            return filename.substring(filename.lastIndexOf("//")+2,filename.indexOf(".txt")+4);
        }else if(filename.contains(".xls")){
            return filename.substring(filename.lastIndexOf("//")+2,filename.indexOf(".xls")+4);
        }

//        File fname=new File(filename.trim());

        return "file error";
//        return "上传问价的格式仅限于.txt .xls .xlsx";
    }
}
