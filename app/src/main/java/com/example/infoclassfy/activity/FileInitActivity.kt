package com.example.infoclassfy.activity

import android.content.Context
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.infoclassfy.MainActivity.filePath
import com.example.infoclassfy.R
import com.example.infoclassfy.methods.getFileName.filetype
import com.example.infoclassfy.methods.getFileName.getFilename
import kotlinx.android.synthetic.main.activity_file_init.*
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import org.apache.commons.csv.CSVRecord
import org.apache.http.util.EncodingUtils
import java.io.*
import java.util.*


class FileInitActivity  {

class FileInitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_init)

        fileInfo(filetype)
        tv_typeText.setText(getFilename(filePath))

        btnFileCommit.setOnClickListener {
            try {
//                val file = File(filePath)
//                val intent = Intent("android.intent.action.VIEW")
//                intent.addCategory("android.intent.category.DEFAULT")
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//
////                val uri=Uri.fromFile(file)
//
//                val uri = FileProvider.getUriForFile(this, application.packageName + ".provider", file)
//
//                intent.setDataAndType(uri, "application/vnd.ms-excel")
//                Log.d("555", "图片被单击")
//                startActivity(intent)
//                Toast.makeText(this, "bei dian le ", Toast.LENGTH_SHORT).show()
//                Toast.makeText(this, readExternal(this, getFilename(filePath)), Toast.LENGTH_SHORT).show()

                val file = File( applicationContext.externalCacheDir!!.absolutePath + File.separator + getFilename(filePath))

                val file2 = File("/storage/emulated/0/"+filePath.substring(filePath.indexOf('/')+10))
                filePath=file2.toString()
                val file1 = File(filePath)
                Toast.makeText(this, file1.exists().toString()+getFileContent(file1), Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {


            }



        }

    }

    @Throws(IOException::class)
    fun parsingData() {
        //获取拓展sd卡的设备装填
        val sDStateString = Environment.getExternalStorageState()
        //拥有可读，可写的权限
        if (sDStateString == Environment.MEDIA_MOUNTED) {
            val SDFile = Environment.getExternalStorageDirectory()
            val fileDirectoryPath = SDFile.absolutePath + File.separator + "测试文件夹"
            val fileDirectory = File(fileDirectoryPath)

            //打开文件夹
            val myFile = File(fileDirectoryPath + File.separator + "MyFile.txt")
            if (!fileDirectory.exists()) {
                //按照指定的路径创建文件夹
                fileDirectory.mkdir()
            }
            if (!myFile.exists()) {
                try {
                    myFile.createNewFile()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            val szOutText = "我丢 slakdfkls"
            val outputStream = FileOutputStream(myFile)
            outputStream.write(szOutText.toByteArray())
            outputStream.close()
        } else if (sDStateString.endsWith(Environment.MEDIA_MOUNTED_READ_ONLY)) {
            //TODO:获取储存设备的文件目录
            val SDFile = Environment.getExternalStorageDirectory()
            val myFile = File(SDFile.absolutePath + File.separator + "MYFile.txt")
            if (myFile.exists()) {
                val inputStream = FileInputStream(myFile)
                val buffer = ByteArray(1024)
                inputStream.read(buffer)
                inputStream.close()
                Log.d("9999", "parsingData: " + Arrays.toString(buffer))
            }
        }
    }

    fun readFile(filePath: String) {
        var file = File(filePath)
        if (file.isDirectory) {
            Log.d("ppp", "该路径有效" + filePath)
        }
    }

    fun fileInfo(s: String) {
        when (s) {
            "0" -> {
                iv_typePic.setImageResource(R.drawable.xlsx_icon)

            }
            "1" -> {
                iv_typePic.setImageResource(R.drawable.txt_icon)
            }
            "2" -> {
                iv_typePic.setImageResource(R.drawable.xls_icon)
            }
            "3" -> {
                iv_typePic.setImageResource(R.drawable.csv_icon)
            }
        }
    }

    fun getFileContent(file: File): String {


//                val iStream = FileInputStream(file)
//
//                val isr = InputStreamReader(iStream,"gbk")
//                val bufferedReader = BufferedReader(isr)
        val fis = FileInputStream(file)
        val length:Int = fis.available()
        val buffer = ByteArray(length)
        fis.read(buffer)
        val res = EncodingUtils.getString(buffer,"UTF-8")
        fis.close()


        return res
    }


//    private val mList: List<ApacheBean> = ArrayList<Any>()
//    var path = this.filesDir.absolutePath.toString() + File.separator + "test_file" + ".csv"
//    private fun readCsv(path: String) {
//        try {
//            val reader = BufferedReader(InputStreamReader(FileInputStream(path), "UTF-8")) // 防止出现乱码
//            val csvParser = CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())
//            val csvRecords: Iterable<CSVRecord> = csvParser.records
//            for (csvRecord in csvRecords) {
//                val apacheBean = ApacheBean()
//                apacheBean.setId(csvRecord["id"].toInt())
//                apacheBean.setName(csvRecord["name"])
//                apacheBean.setAge(csvRecord["age"].toInt())
//                mList.add(apacheBean)
//            }
//        } catch (e: FileNotFoundException) {
//            e.printStackTrace()
//        } catch (e: IOException) {
//            e.printStackTrace()
//        }
//    }


}