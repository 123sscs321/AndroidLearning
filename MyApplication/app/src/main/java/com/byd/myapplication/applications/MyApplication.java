package com.byd.myapplication.applications;

import android.app.Application;

import com.byd.myapplication.BuildConfig;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        //定义json类型
        String JSON_CONTENT = "{\"weatherinfo\":{\"city\":\"北京\",\"cityid\":\"101010100\"," +
                "\"temp\":\"18\",\"WD\":\"东南风\",\"WS\":\"1级\",\"SD\":\"17%\",\"WSE\":\"1\"," +
                "\"time\":\"17:05\",\"isRadar\":\"1\",\"Radar\":\"JC_RADAR_AZ9010_JB\"," +
                "\"njd\":\"暂无实况\",\"qy\":\"1011\",\"rain\":\"0\"}}";
        //定义xml类型
        String XML_CONTENT = "<china dn=\"nay\"><city quName=\"黑龙江\" pyName=\"heilongjiang\" " +
                "cityname=\"哈尔滨\" state1=\"1\" state2=\"1\" stateDetailed=\"多云\"/><city quName=\"吉林\"" +
                " pyName=\"jilin\" " +
                "cityname=\"长春\" state1=\"0\" state2=\"0\" stateDetailed=\"晴\"/><city quName=\"辽宁\" " +
                "pyName=\"liaoning\" " +
                "cityname=\"沈阳\" state1=\"1\" state2=\"0\" stateDetailed=\"多云转晴\"/><city " +
                "quName=\"海南\" pyName=\"hainan\" " +
                "cityname=\"海口\" state1=\"22\" state2=\"21\" stateDetailed=\"中到大雨转小到中雨\"/></china>";
        //定义list类型
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add(" ge.wei ");
        //定义map类型
        Map<String, String> map = new HashMap<>();
        map.put("hello_key", "Hello");
        map.put("name_key", " ge.wei ");
        //定义数组类型
        int[] a = new int[5];

        //初始化通用的Logger
        Logger.addLogAdapter(new AndroidLogAdapter());
        //初始化化定制的Logger
        /*FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  //（可选）是否显示线程信息。 默认值为true
                .methodCount(2)         // （可选）要显示的方法行数。 默认2
                .methodOffset(7)        // （可选）隐藏内部方法调用到偏移量。 默认5
                // （可选）更改要打印的日志策略。 默认LogCat
                .tag(TAG)   //（可选）每个日志的全局标记。 默认PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
        //初始化可以隐藏日志的Logger
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return BuildConfig.DEBUG;
            }
        });
        //初始化可以将日志保存到文件中
        Logger.addLogAdapter(new DiskLogAdapter());
        //初始化可以保存特定的TAG到文件中
        FormatStrategy mFormatStrategy = CsvFormatStrategy.newBuilder()
                .tag(TAG)
                .build();
        Logger.addLogAdapter(new DiskLogAdapter(mFormatStrategy));

        //打印Json数据
        Logger.json(JSON_CONTENT);
        //打印xml数据
        Logger.xml(XML_CONTENT);
        //打印list的数据
        Logger.d(list);
        //打印Map的数据
        Logger.d(map);
        //打印异常
        try {
            a[2] = a[3];
            a[6] = 10;
        } catch (Exception e) {
            Logger.e(e, "error");
        }*/
    }
}
