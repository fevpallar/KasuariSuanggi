/*====================================
 Author : fevly pallar
 Contact : fevly.pallar@gmail.com
========================================*/
#include <jni.h>
#include <string>
#include <vector>

static std::vector<char> vect;
extern "C" JNIEXPORT jbyteArray JNICALL
Java_com_fevly_kasuarixsuanggi_MainActivity_getCurrentVectorState(JNIEnv* env, jobject /* this */) {

    jbyteArray jArray = env->NewByteArray(vect.size());// vector ke java byte array
    env->SetByteArrayRegion(jArray, 0, vect.size(), reinterpret_cast<jbyte*>(vect.data()));
    return jArray;
}

extern "C" JNIEXPORT void JNICALL
Java_com_fevly_kasuarixsuanggi_MainActivity_addElement(JNIEnv* env, jobject /* this */, jbyte newElement) {
    vect.push_back(static_cast<char>(newElement));
}



/*
extern "C" JNIEXPORT jstring JNICALL
Java_com_fevly_kasuarixsuanggi_MainActivity_getStringSample(
        JNIEnv* env,
        jobject */
/* this *//*
) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}*/
