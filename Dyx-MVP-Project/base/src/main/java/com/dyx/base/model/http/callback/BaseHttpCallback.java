package com.dyx.base.model.http.callback;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-05-16
 * Time      : 16:59
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public abstract class BaseHttpCallback<T> {
    public void onStart() {
    }

    public void onEnd() {
    }

    public abstract void onResponse(T response);

    public abstract void onError(String error);
}  