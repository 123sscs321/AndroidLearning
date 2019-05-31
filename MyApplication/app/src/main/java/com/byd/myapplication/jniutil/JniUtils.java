package com.byd.myapplication.jniutil;

public class JniUtils {

    static {
        System.loadLibrary("gewei");
        System.loadLibrary("native-lib");
    }

    public static native String getGewei();

    public static native String getJni();

}
