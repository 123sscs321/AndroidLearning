package com.byd.myapplication.utils;
import android.Manifest.permission;
public class AutoUnboxingTest {

    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 150;                  // 将3自动装箱成Integer类型
        Integer c = 150;
        System.out.println(a==b); // false 两个引用没有引用同一对象
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较

        int firstFlag=2;
        firstFlag |=1 |2|58;
        System.out.println(firstFlag);
    }

}
