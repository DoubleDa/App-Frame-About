package com.dyx.base.ui.widget.loading;

import android.content.Context;
import android.view.View;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-05-16
 * Time      : 17:53
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public interface IHandleViewHelper {
    /**
     * 获取当前layout
     */
    View getCurrentLayout();

    /**
     * 恢复view
     */
    void restoreView();

    /**
     * 显示layout
     */
    void showLayout(View view);

    /**
     * 从layout提取view
     */
    View inflateView(int layoutId);

    /**
     * 获取上下文
     */
    Context getContext();

    /**
     * 获取View
     */
    View getView();
}  