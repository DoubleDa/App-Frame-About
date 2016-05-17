package com.dyx.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.com.mvplibrary.R;


/**
 * Created by fangxiao on 15/12/28.
 */
public class BaseUtil {
    //�?天的秒数
    public static final long ONE_DAY_TIME = 24 * 60 * 60;

    /**
     * 获取屏幕分辨�?
     *
     * @param context
     * @return
     */
    public static int getWidth(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        return screenWidth;
    }

    public static int getHeight(Activity context) {
        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenHeigt = dm.heightPixels;
        return screenHeigt;
    }

    /**
     * 判断链表是否为空
     *
     * @param list
     * @return true:为Null或�?�size�?0
     */
    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }


    /**
     * 判断链表第某个位置是否为�?
     *
     * @param list
     * @param index
     * @return true:为Null或�?�size�?0
     */
    public static boolean isEmpty(List<?> list, int index) {
        return list == null || list.size() == 0 || list.size() <= index;
    }


    /**
     * 获取年月日时�?
     */
    public static String getNYYMMDD() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String yymmddString = sdf.format(new Date());
        return yymmddString;
    }


    /**
     * 获取年月日时�?
     */
    public static String getNYYMMDD(int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        long now = date.getTime();
        long next = now + day * ONE_DAY_TIME * 1000;
        String yymmddString = sdf.format(next);
        return yymmddString;
    }

    //分享
    public static void share(Context context, String questionTitle, String questionUrl) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        //noinspection deprecation
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        share.putExtra(Intent.EXTRA_TEXT, questionTitle + " " + questionUrl + " 分享自Anthony Github");
        context.startActivity(Intent.createChooser(share,"分享至�?��?��??"));
    }


    //替换html标签
    public static String delHTMLTag(String htmlStr) {
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); //过滤script标签

        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); //过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); //过滤html标签

        return htmlStr.trim(); //返回文本字符�?
    }

}
