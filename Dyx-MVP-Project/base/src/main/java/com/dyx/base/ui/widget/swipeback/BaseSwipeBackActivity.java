package com.dyx.base.ui.widget.swipeback;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-05-16
 * Time      : 18:07
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public interface BaseSwipeBackActivity {
    public abstract SwipeBackLayout getSwipeBackLayout();

    public abstract void setSwipeBackEnable(boolean enable);

    public abstract void scrollFinishActivity();
}  