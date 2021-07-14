package com.example.infoclassfy.methods;

import android.util.Log;

import java.io.File;
import com.example.infoclassfy.MainActivity.*;
import com.example.infoclassfy.data.fileType;

public class getFileName {

    public static String  filetype;

    public static String getFilePath(String filename){

        //上传文件的类型仅限于“.txt”、“.xls”、“。xlsx”
        if(filename.contains(".xlsx")){
            com.example.infoclassfy.data.fileType fileTypee=new fileType(0);
            filetype="0";
            return filename.substring(filename.lastIndexOf("//")+2,filename.indexOf(".xlsx")+5);
        }else if(filename.contains(".txt")){
            com.example.infoclassfy.data.fileType fileTypee=new fileType(1);
            filetype="1";
            return filename.substring(filename.lastIndexOf("//")+2,filename.indexOf(".txt")+4);
        }else if(filename.contains(".xls")){
            com.example.infoclassfy.data.fileType fileTypee=new fileType(2);
            filetype="2";
            return filename.substring(filename.lastIndexOf("//")+2,filename.indexOf(".xls")+4);
        }else if(filename.contains(".csv")){
            com.example.infoclassfy.data.fileType fileTypee = new fileType(3);
            filetype="3";
            return filename.substring(filename.lastIndexOf("//")+2, filename.indexOf(".csv")+4);
        }

//        File fname=new File(filename.trim());

        return "file error";
//        return "上传问价的格式仅限于.txt .xls .xlsx";
    }
    public static String getFilename(String path){

        return path.substring(path.lastIndexOf("/")+1);
    }


}
