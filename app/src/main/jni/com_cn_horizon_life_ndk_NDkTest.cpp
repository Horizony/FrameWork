#include <com_cn_horizon_life_ndk_NDkTest.h>
#include <string.h>
JNIEXPORT jstring JNICALL Java_com_cn_horizon_life_ndk_NDkTest_hello(JNIEnv *env, jclass object){
    return env->NewStringUTF("我是来自NDK的C++");
}