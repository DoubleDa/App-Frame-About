package com.dyx.base.model.http;

import com.dyx.base.model.http.callback.FileDownloadHttpCallBack;
import com.dyx.base.model.http.callback.FileUploadHttpCallBack;
import com.dyx.base.model.http.callback.StringHttpCallBack;
import com.dyx.base.model.http.provider.BaseHttpProvider;
import com.dyx.base.model.http.provider.okhttp.OkHttpProvider;
import com.dyx.base.model.http.request.HttpRequest;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-05-16
 * Time      : 16:41
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class HttpUtil {
    private static HttpUtil mInstance;
    public static final int GET = 0;
    public static final int POST = 1;
    private BaseHttpProvider mProvider;

    private HttpUtil() {
        mProvider = new OkHttpProvider();
    }

    public static HttpUtil getInstance() {
        if (mInstance == null) {
            synchronized (HttpUtil.class) {
                if (mInstance == null) {
                    mInstance = new HttpUtil();
                }
            }
        }
        return mInstance;
    }

    /**
     * 加载字符串
     */
    public void loadString(HttpRequest request, StringHttpCallBack callBack) {
        mProvider.loadString(request, callBack);
    }

    /**
     * 上传文件
     */
    public void uploadFile(HttpRequest request, FileUploadHttpCallBack callBack) {
        mProvider.uploadFile(request, callBack);
    }

    /**
     * 下载文件
     */
    public void downloadFile(HttpRequest request, FileDownloadHttpCallBack callBack) {
        mProvider.downloadFile(request, callBack);
    }
}  