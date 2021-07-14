package com.example.infoclassfy.activity

import android.os.Build
import android.os.Bundle
import android.view.animation.TranslateAnimation
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.infoclassfy.R
import com.example.infoclassfy.activity.InputTextActivity.inputTextData
import com.example.infoclassfy.activity.InputTextActivity.result
import com.example.infoclassfy.http.ParsingTextData.Companion.getTexts
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.activity_result_view.*
import java.util.*
import kotlin.random.Random

class ResultView : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_view)

        textTitle.setText(inputTextData.TextTitle)
        textContent.setText(inputTextData.TextContent)
        textAnimationStart()

        //TODO:

        val barChart:BarChart=initBarChart(ChartTest)//初始化柱状图
        val barData:BarData = setBartdata()//调用方法初始化模拟数据
        barChart.data=barData//这里将模拟数据用于柱状图，在柱状图显示
        barChart.invalidate()//让柱状图在填充数据后刷新
        //基本完成了柱状图的初步使用

    }
    /*
    * 此方法用于设置柱状图的数据
    * */
    fun setBartdata():BarData{


        val entries: ArrayList<BarEntry> = ArrayList<BarEntry>()//TODO:这改过
        //这用for训话为容器填充数据

        for (i in 1..9){
            var barEntry = BarEntry(i.toFloat(),Random.nextFloat())//这不是浮点数
            entries.add(barEntry)
        }
        val barDataSet = BarDataSet(entries,"财经  房产  教育  科技  军事  汽车  体育  游戏  娱乐")//这里设置数据集
//        val barDataSet = BarDataSet(entries,"1:财经 2:房产 3:教育 4:科技 5:军事 6:汽车 7:体育 8:游戏 9:娱乐")//这里设置数据集
        val barData = BarData(barDataSet)
        return barData//返回可用于柱状图的数据

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun textAnimationStart(){
        val translateAnimationForTitle = TranslateAnimation(0F, 0F, 0F, -150F);
        val translateAnimationForContent = TranslateAnimation(0F, 0F, 0F, -450F);
        val translateAnimationForResult = TranslateAnimation(0F, 0F, 0F, -50F)

        translateAnimationForTitle.fillAfter = true         //it can keep it after the animation
        translateAnimationForContent.fillAfter = true         //it can keep it after the animation
        translateAnimationForResult.fillAfter = true         //it can keep it after the animation
        translateAnimationForTitle.duration = 1000    // the animation will keep 1500 ms
        translateAnimationForContent.duration = 1000    // the animation will keep 1500 ms
        translateAnimationForResult.duration = 1000    // the animation will keep 1500 ms
        textTitle.animation = translateAnimationForTitle
        textContent.animation = translateAnimationForContent
        textResult.animation = translateAnimationForResult

        textResult.text= getTexts(result).substring(getTexts(result).length - 3)
//        val barChart: BarChart? =null
//        ChartTest = initBarChart(barChart)

    }
    /*
    * 用于初始化柱状图
    * */
    fun initBarChart(barChart: BarChart):BarChart{
        barChart.description=null
        barChart.setDrawBarShadow(false)//设置柱状图每根柱子的阴影不显示
        barChart.setDrawValueAboveBar(true)//设置每根柱子的数值显示
        val xAxis:XAxis = barChart.xAxis//获取柱状图的x轴
        val yAxisLeft:YAxis = barChart.axisLeft//获取柱状图左侧的y轴
        val yAXisRigth:YAxis = barChart.axisRight//获取柱状图右侧的y轴

        setAxis(xAxis, yAxisLeft, yAXisRigth)

        return barChart//返回的是初始化完成的
    }
    /*
    * 设置柱状图的x轴和y轴
    *
    * */
    fun setAxis(xAxis: XAxis, leftYaxis: YAxis, rightYaxis: YAxis){

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM)//设置x周在柱状图底部显示
        xAxis.setAxisLineWidth(1F)//设置宽度
        xAxis.setAxisMinimum(0F)//从0开始画
        xAxis.setDrawAxisLine(true)//显示x轴线
        xAxis.setDrawGridLines(false)//设置x轴的表格线不显示
        xAxis.setEnabled(true)//设置x轴显示

        leftYaxis.axisMinimum=0f
        leftYaxis.setDrawGridLines(false)
        leftYaxis.setDrawAxisLine(true)
        leftYaxis.axisLineWidth=1F
        leftYaxis.isEnabled=true

        rightYaxis.axisMinimum=0f
        rightYaxis.setDrawGridLines(false)
        rightYaxis.setDrawAxisLine(true)
        rightYaxis.axisLineWidth=1F
        rightYaxis.isEnabled=true
    }

}