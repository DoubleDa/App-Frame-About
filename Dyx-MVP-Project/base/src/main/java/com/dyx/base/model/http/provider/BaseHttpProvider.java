package com.dyx.base.model.http.provider;

import com.dyx.base.BaseApplication;
import com.dyx.base.model.http.callback.FileDownloadHttpCallBack;
import com.dyx.base.model.http.callback.FileUploadHttpCallBack;
import com.dyx.base.model.http.callback.StringHttpCallBack;
import com.dyx.base.model.http.request.HttpRequest;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-05-16
 * Time      : 16:46
 * Summary   : 提供http基本操作：加载字符串、上传文件、下载文件、加载本地文件
 * Copyright : Copyright (c) 2016
 */
public abstract class BaseHttpProvider {
    /**
     * 加载字符串
     */
    public abstract void loadString(HttpRequest request, StringHttpCallBack callBack);

    /**
     * 上传文件
     */
    public abstract void uploadFile(HttpRequest request, FileUploadHttpCallBack callBack);

    /**
     * 下载文件
     */
    public abstract void downloadFile(HttpRequest request, FileDownloadHttpCallBack callBack);

    /**
     * 加载本地文件
     */
    protected void loadLocalFile(String path, StringHttpCallBack callBack) {
        try {
            String result = FileUtil.getString(BaseApplication.getInstance(), path);
            callBack.onResponse(result);
        } catch (Exception e) {
            callBack.onError(e.getMessage());
        }
    }
}  