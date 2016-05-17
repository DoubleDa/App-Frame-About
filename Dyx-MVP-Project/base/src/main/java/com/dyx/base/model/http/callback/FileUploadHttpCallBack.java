package com.dyx.base.model.http.callback;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-05-16
 * Time      : 16:50
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public abstract class FileUploadHttpCallBack extends BaseHttpCallback<String> {
    public abstract void onProgress(long byteCount, long contentLength, boolean done);
}