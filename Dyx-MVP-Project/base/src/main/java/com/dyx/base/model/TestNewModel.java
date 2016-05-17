package com.dyx.base.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Author    : Yongxinda(yongxinda89@gmail.com)
 * Version   : 1.0
 * Date      : 2016-05-16
 * Time      : 16:34
 * Summary   :
 * Copyright : Copyright (c) 2016
 */
public class TestNewModel implements Parcelable {
    private String id;
    private String author_id;
    private String tab;
    private String content;
    private String title;
    private String last_reply_at;
    private boolean good;
    private boolean top;
    private int reply_count;
    private int visit_count;
    private String create_at;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.author_id);
        dest.writeString(this.tab);
        dest.writeString(this.content);
        dest.writeString(this.title);
        dest.writeString(this.last_reply_at);
        dest.writeByte(good ? (byte) 1 : (byte) 0);
        dest.writeByte(top ? (byte) 1 : (byte) 0);
        dest.writeInt(this.reply_count);
        dest.writeInt(this.visit_count);
        dest.writeString(this.create_at);
    }

    public TestNewModel() {
    }

    protected TestNewModel(Parcel in) {
        this.id = in.readString();
        this.author_id = in.readString();
        this.tab = in.readString();
        this.content = in.readString();
        this.title = in.readString();
        this.last_reply_at = in.readString();
        this.good = in.readByte() != 0;
        this.top = in.readByte() != 0;
        this.reply_count = in.readInt();
        this.visit_count = in.readInt();
        this.create_at = in.readString();
    }

    public static final Parcelable.Creator<TestNewModel> CREATOR = new Parcelable.Creator<TestNewModel>() {
        @Override
        public TestNewModel createFromParcel(Parcel source) {
            return new TestNewModel(source);
        }

        @Override
        public TestNewModel[] newArray(int size) {
            return new TestNewModel[size];
        }
    };
}