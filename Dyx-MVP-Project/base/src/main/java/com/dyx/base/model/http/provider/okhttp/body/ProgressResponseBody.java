package com.dyx.base.model.http.provider.okhttp.body;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import okio.BufferedSource;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-05-16
 * Time      : 17:25
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class ProgressResponseBody extends ResponseBody{
    @Override
    public MediaType contentType() {
        return null;
    }

    @Override
    public long contentLength() throws IOException {
        return 0;
    }

    @Override
    public BufferedSource source() throws IOException {
        return null;
    }
}