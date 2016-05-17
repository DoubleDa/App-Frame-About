package com.dyx.base.ui;

import android.view.View;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-05-16
 * Time      : 17:30
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public interface BaseView {
    /**
     * 显示加载进度
     */
    void showLoading(String msg);

    /**
     * 隐藏进度
     */
    void hideLoading();

    /**
     * 显示错误信息
     */
    void showError(String msg, View.OnClickListener onClickListener);

    /**
     * 显示空视图
     */
    void showEmpty(String msg, View.OnClickListener onClickListener);

    /**
     * 显示空视图（包含图片）
     */
    void showEmpty(String msg, View.OnClickListener onClickListener, int imgId);

    /**
     * 显示网络错误
     */
    void showNetError(View.OnClickListener onClickListener);
}  