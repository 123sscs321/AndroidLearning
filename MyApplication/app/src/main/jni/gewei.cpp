//
// Created by ge.wei on 2019/2/28.
//

#include <jni.h>
#include <com_byd_myapplication_jniutil_JniUtils.h>

/*
 * Class:     com_byd_myapplication_jniutil_JniUtils
 * Method:    getGewei
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_byd_myapplication_jniutil_JniUtils_getGewei
  (JNIEnv *ge, jclass jclass){
     return ge->NewStringUTF("Hello Ge Wei!");
  }

