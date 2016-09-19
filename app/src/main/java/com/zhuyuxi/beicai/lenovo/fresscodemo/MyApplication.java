package com.zhuyuxi.beicai.lenovo.fresscodemo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

/**
 * Created by lenovo on 2016/9/19.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //基本使用的初始化方法
     //   Fresco.initialize(this);
        //渐进式JPEG图的初始化方法
        ImagePipelineConfig config=ImagePipelineConfig.newBuilder(this)
                .build();
        Fresco.initialize(this,config);
    }
}
