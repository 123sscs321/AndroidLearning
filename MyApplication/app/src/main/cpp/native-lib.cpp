//
// Created by ge.wei on 2019/5/10.
//

#include <jni.h>
#include <string.h>

extern "C"

JNIEXPORT jstring
JNICALL
Java_com_byd_myapplication_jniutil_JniUtils_getJni
        (JNIEnv *env,
         jclass type) {
    return env->NewStringUTF("Hello Jni!");
}