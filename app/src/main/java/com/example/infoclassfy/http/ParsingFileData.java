package com.example.infoclassfy.http;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.util.EncodingUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static com.example.infoclassfy.MainActivity.filePath;
import static com.example.infoclassfy.methods.getFileName.getFilename;

public class ParsingFileData {
        //获取拓展sd卡的设备装填
//        String sDStateString = Environment.getExternalStorageState();
//        //拥有可读，可写的权限
//        if(sDStateString.equals(Environment.MEDIA_MOUNTED)){
//            File SDFile = Environment.getExternalStorageDirectory();
//            String fileDirectoryPath = SDFile.getAbsolutePath()+File.separator+"测试文件夹";
//            File fileDirectory = new File(fileDirectoryPath);
//
//            //打开文件夹
//            File myFile = new File(fileDirectoryPath+File.separator+"MyFile.txt");
//
//            if(!fileDirectory.exists()){
//                //按照指定的路径创建文件夹
//                fileDirectory.mkdir();
//            }
//            if(!myFile.exists()){
//                try {
//                    myFile.createNewFile();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            String szOutText = "我丢 slakdfkls";
//            FileOutputStream outputStream = new FileOutputStream(myFile);
//            outputStream.write(szOutText.getBytes());
//            outputStream.close();
//        }
//        //拥有只读权限
//        else if (sDStateString.endsWith(Environment.MEDIA_MOUNTED_READ_ONLY)){
//            //TODO:获取储存设备的文件目录
//            File SDFile = android.os.Environment.getExternalStorageDirectory();
//            File myFile = new File(SDFile.getAbsolutePath()+File.separator+"MYFile.txt");
//            if (myFile.exists()){
//                FileInputStream inputStream = new FileInputStream(myFile);
//                byte[] buffer = new byte[1024];
//                inputStream.read(buffer);
//                inputStream.close();
//                Log.d("9999", "parsingData: "+ Arrays.toString(buffer));
//            }
//        }
//    }
        public static String readExternal(Context context, String filename) throws IOException {
            StringBuilder sb = new StringBuilder("");
            if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                filename = context.getExternalCacheDir().getAbsolutePath() + File.separator + filename;
                //打开文件输入流
                FileInputStream inputStream = new FileInputStream(filename);

                byte[] buffer = new byte[1024];
                int len = inputStream.read(buffer);
                //读取文件内容
                while(len > 0){
                    sb.append(new String(buffer,0,len));

                    //继续将数据放到buffer中
                    len = inputStream.read(buffer);
                }
                //关闭输入流
                inputStream.close();
            }
            return sb.toString();
        }

//    private List<ApacheBean> mList = new ArrayList<>();
//    String path = this.getFilesDir().getAbsolutePath() + File.separator + "test_file" + ".csv";
//    private void readCsv(String path) {
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));  // 防止出现乱码
//            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
//            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
//            for (CSVRecord csvRecord : csvRecords) {
//                ApacheBean apacheBean = new ApacheBean();
//                apacheBean.setId(Integer.parseInt(csvRecord.get("id")));
//                apacheBean.setName(csvRecord.get("name"));
//                apacheBean.setAge(Integer.parseInt(csvRecord.get("age")));
//                mList.add(apacheBean);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}
