package com.dyx.base.model.http.callback;

import java.io.File;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-05-16
 * Time      : 16:52
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public abstract class FileDownloadHttpCallBack extends BaseHttpCallback<File> {
    public abstract void onProgress(long byteCount, long contentLength, boolean done);
}  