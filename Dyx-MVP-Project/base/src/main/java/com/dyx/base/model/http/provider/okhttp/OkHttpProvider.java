package com.dyx.base.model.http.provider.okhttp;

import com.dyx.base.model.http.callback.FileDownloadHttpCallBack;
import com.dyx.base.model.http.callback.FileUploadHttpCallBack;
import com.dyx.base.model.http.callback.StringHttpCallBack;
import com.dyx.base.model.http.provider.BaseHttpProvider;
import com.dyx.base.model.http.request.HttpRequest;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-05-16
 * Time      : 17:04
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class OkHttpProvider extends BaseHttpProvider {
    @Override
    public void loadString(HttpRequest request, StringHttpCallBack callBack) {

    }

    @Override
    public void uploadFile(HttpRequest request, FileUploadHttpCallBack callBack) {

    }

    @Override
    public void downloadFile(HttpRequest request, FileDownloadHttpCallBack callBack) {

    }
}