package com.dyx.base;

import android.app.Application;

import com.apkfuns.logutils.LogUtils;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-05-16
 * Time      : 16:15
 * Summary   : Application抽象类
 * Copyright : Copyright (c) 2016
 */
public abstract class BaseApplication extends Application {
    private static BaseApplication mInstance;

    public static BaseApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        /**
         * 初始化各个功能模块
         */
        //初始化打印log信息
        initLogUtil();
    }

    private void initLogUtil() {
        LogUtils.configTagPrefix = "***dayongxin***";
        LogUtils.configAllowLog = true;
    }
}