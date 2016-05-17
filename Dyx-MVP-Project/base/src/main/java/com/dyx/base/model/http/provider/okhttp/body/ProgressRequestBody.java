package com.dyx.base.model.http.provider.okhttp.body;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;

import okio.BufferedSink;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-05-16
 * Time      : 17:25
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class ProgressRequestBody extends RequestBody{
    @Override
    public MediaType contentType() {
        return null;
    }

    @Override
    public void writeTo(BufferedSink bufferedSink) throws IOException {

    }
}