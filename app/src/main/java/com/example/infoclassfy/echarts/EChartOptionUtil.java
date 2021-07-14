package com.example.infoclassfy.echarts;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Pie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EChartOptionUtil {

//    /**
//     * 封装折线图的option
//     * @param xAxis x轴的相关配置
//     * @param yAxis y轴的相关配置
//     * @return 返回封装好的折线图的option
//     */
//    public static GsonOption getLineChartOptions(Object[] xAxis, Object[] yAxis) {}
//
//
//    /**
//     * 封装饼图的option
//     * @param data  待传入的饼图的数据
//     * @return 返回封装好的饼图的option
//     */
//    public static GsonOption getPieChartOptions(List<Map<String, Object>> data) {}

    /**
     * 封装柱状图的option
     * @param xAxis x 轴的相关数据
     * @param yAxis y 轴的相关数据
     * @return 返回封装好的柱状图的option
     */
    public static GsonOption getBarChartOptions(Object[] xAxis, Object[] yAxis){
        GsonOption option = new GsonOption();
        option.title("柱状图");
        option.legend("年龄");
        option.tooltip().trigger(Trigger.axis);

        ValueAxis valueAxis = new ValueAxis();
        option.yAxis(valueAxis);//添加y轴，将y轴设置为值轴

        CategoryAxis categorxAxis = new CategoryAxis();
        categorxAxis.data(xAxis);//设置x轴的类目属性
        option.xAxis(categorxAxis);//添加x轴

        Bar bar = new Bar();
        //设置饼图的相关属性
        bar.name("销量").data(yAxis).itemStyle().normal().setBarBorderColor("rgba(0,0,0,0.4)");
        option.series(bar);

        return option;
    }
}
