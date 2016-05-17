package com.dyx.base.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by Jaeger on 16/2/14.
 *
 * Email: chjie.jaeger@gamil.com
 * GitHub: https://github.com/laobie
 */
public class StatusBarUtil {

    public static final int DEFAULT_STATUS_BAR_ALPHA = 112;

    /**
     * 设置状�?�栏颜色
     *
     * @param activity �?要设置的 activity
     * @param color    状�?�栏颜色�?
     */
    public static void setColor(Activity activity, int color) {
        setColor(activity, color, DEFAULT_STATUS_BAR_ALPHA);
    }

    /**
     * 设置状�?�栏颜色
     *
     * @param activity       �?要设置的activity
     * @param color          状�?�栏颜色�?
     * @param statusBarAlpha 状�?�栏透明�?
     */
    public static void setColor(Activity activity, int color, int statusBarAlpha) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().setStatusBarColor(calculateStatusColor(color, statusBarAlpha));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 生成�?个状态栏大小的矩�?
            View statusView = createStatusBarView(activity, color, statusBarAlpha);
            // 添加 statusView 到布�?�?
            ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
            decorView.addView(statusView);
            setRootView(activity);
        }
    }

    /**
     * 设置状�?�栏纯色 不加半�?�明效果
     *
     * @param activity �?要设置的 activity
     * @param color    状�?�栏颜色�?
     */
    public static void setColorNoTranslucent(Activity activity, int color) {
        setColor(activity, color, 0);
    }

    /**
     * 设置状�?�栏颜色(5.0以下无半透明效果,不建议使�?)
     *
     * @param activity �?要设置的 activity
     * @param color    状�?�栏颜色�?
     */
    public static void setColorDiff(Activity activity, int color) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // 生成�?个状态栏大小的矩�?
        View statusView = createStatusBarView(activity, color);
        // 添加 statusView 到布�?�?
        ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
        decorView.addView(statusView);
        setRootView(activity);
    }

    /**
     * 使状态栏半�?�明
     *
     * 适用于图片作为背景的界面,此时�?要图片填充到状�?�栏
     *
     * @param activity �?要设置的activity
     */
    public static void setTranslucent(Activity activity) {
        setTranslucent(activity, DEFAULT_STATUS_BAR_ALPHA);
    }

    /**
     * 使状态栏半�?�明
     *
     * 适用于图片作为背景的界面,此时�?要图片填充到状�?�栏
     *
     * @param activity       �?要设置的activity
     * @param statusBarAlpha 状�?�栏透明�?
     */
    public static void setTranslucent(Activity activity, int statusBarAlpha) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        setTransparent(activity);
        addTranslucentView(activity, statusBarAlpha);
    }

    /**
     * 设置状�?�栏全�?�明
     *
     * @param activity �?要设置的activity
     */
    public static void setTransparent(Activity activity) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        transparentStatusBar(activity);
        setRootView(activity);
    }

    /**
     * 使状态栏透明(5.0以上半�?�明效果,不建议使�?)
     *
     * 适用于图片作为背景的界面,此时�?要图片填充到状�?�栏
     *
     * @param activity �?要设置的activity
     */
    public static void setTranslucentDiff(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 设置状�?�栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            setRootView(activity);
        }
    }

    /**
     * 为DrawerLayout 布局设置状�?�栏变色
     *
     * @param activity     �?要设置的activity
     * @param drawerLayout DrawerLayout
     * @param color        状�?�栏颜色�?
     */
    public static void setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int color) {
        setColorForDrawerLayout(activity, drawerLayout, color, DEFAULT_STATUS_BAR_ALPHA);
    }

    /**
     * 为DrawerLayout 布局设置状�?�栏颜色,纯色
     *
     * @param activity     �?要设置的activity
     * @param drawerLayout DrawerLayout
     * @param color        状�?�栏颜色�?
     */
    public static void setColorNoTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int color) {
        setColorForDrawerLayout(activity, drawerLayout, color, 0);
    }

    /**
     * 为DrawerLayout 布局设置状�?�栏变色
     *
     * @param activity       �?要设置的activity
     * @param drawerLayout   DrawerLayout
     * @param color          状�?�栏颜色�?
     * @param statusBarAlpha 状�?�栏透明�?
     */
    public static void setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int color, int statusBarAlpha) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        // 生成�?个状态栏大小的矩�?
        View statusBarView = createStatusBarView(activity, color);
        // 添加 statusBarView 到布�?�?
        ViewGroup contentLayout = (ViewGroup) drawerLayout.getChildAt(0);
        contentLayout.addView(statusBarView, 0);
        // 内容布局不是 LinearLayout �?,设置padding top
        if (!(contentLayout instanceof LinearLayout) && contentLayout.getChildAt(1) != null) {
            contentLayout.getChildAt(1).setPadding(0, getStatusBarHeight(activity), 0, 0);
        }
        // 设置属�??
        ViewGroup drawer = (ViewGroup) drawerLayout.getChildAt(1);
        drawerLayout.setFitsSystemWindows(false);
        contentLayout.setFitsSystemWindows(false);
        contentLayout.setClipToPadding(true);
        drawer.setFitsSystemWindows(false);

        addTranslucentView(activity, statusBarAlpha);
    }

    /**
     * 为DrawerLayout 布局设置状�?�栏变色(5.0以下无半透明效果,不建议使�?)
     *
     * @param activity     �?要设置的activity
     * @param drawerLayout DrawerLayout
     * @param color        状�?�栏颜色�?
     */
    public static void setColorForDrawerLayoutDiff(Activity activity, DrawerLayout drawerLayout, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 生成�?个状态栏大小的矩�?
            View statusBarView = createStatusBarView(activity, color);
            // 添加 statusBarView 到布�?�?
            ViewGroup contentLayout = (ViewGroup) drawerLayout.getChildAt(0);
            contentLayout.addView(statusBarView, 0);
            // 内容布局不是 LinearLayout �?,设置padding top
            if (!(contentLayout instanceof LinearLayout) && contentLayout.getChildAt(1) != null) {
                contentLayout.getChildAt(1).setPadding(0, getStatusBarHeight(activity), 0, 0);
            }
            // 设置属�??
            ViewGroup drawer = (ViewGroup) drawerLayout.getChildAt(1);
            drawerLayout.setFitsSystemWindows(false);
            contentLayout.setFitsSystemWindows(false);
            contentLayout.setClipToPadding(true);
            drawer.setFitsSystemWindows(false);
        }
    }

    /**
     * �? DrawerLayout 布局设置状�?�栏透明
     *
     * @param activity     �?要设置的activity
     * @param drawerLayout DrawerLayout
     */
    public static void setTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout) {
        setTranslucentForDrawerLayout(activity, drawerLayout, DEFAULT_STATUS_BAR_ALPHA);
    }

    /**
     * �? DrawerLayout 布局设置状�?�栏透明
     *
     * @param activity     �?要设置的activity
     * @param drawerLayout DrawerLayout
     */
    public static void setTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int statusBarAlpha) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        setTransparentForDrawerLayout(activity, drawerLayout);
        addTranslucentView(activity, statusBarAlpha);
    }

    /**
     * �? DrawerLayout 布局设置状�?�栏透明
     *
     * @param activity     �?要设置的activity
     * @param drawerLayout DrawerLayout
     */
    public static void setTransparentForDrawerLayout(Activity activity, DrawerLayout drawerLayout) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            return;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        ViewGroup contentLayout = (ViewGroup) drawerLayout.getChildAt(0);
        // 内容布局不是 LinearLayout �?,设置padding top
        if (!(contentLayout instanceof LinearLayout) && contentLayout.getChildAt(1) != null) {
            contentLayout.getChildAt(1).setPadding(0, getStatusBarHeight(activity), 0, 0);
        }

        // 设置属�??
        ViewGroup drawer = (ViewGroup) drawerLayout.getChildAt(1);
        drawerLayout.setFitsSystemWindows(false);
        contentLayout.setFitsSystemWindows(false);
        contentLayout.setClipToPadding(true);
        drawer.setFitsSystemWindows(false);
    }

    /**
     * �? DrawerLayout 布局设置状�?�栏透明(5.0以上半�?�明效果,不建议使�?)
     *
     * @param activity     �?要设置的activity
     * @param drawerLayout DrawerLayout
     */
    public static void setTranslucentForDrawerLayoutDiff(Activity activity, DrawerLayout drawerLayout) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 设置状�?�栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 设置内容布局属�??
            ViewGroup contentLayout = (ViewGroup) drawerLayout.getChildAt(0);
            contentLayout.setFitsSystemWindows(true);
            contentLayout.setClipToPadding(true);
            // 设置抽屉布局属�??
            ViewGroup vg = (ViewGroup) drawerLayout.getChildAt(1);
            vg.setFitsSystemWindows(false);
            // 设置 DrawerLayout 属�??
            drawerLayout.setFitsSystemWindows(false);
        }
    }

    /**
     * 添加半�?�明矩形�?
     *
     * @param activity       �?要设置的 activity
     * @param statusBarAlpha 透明�?
     */
    private static void addTranslucentView(Activity activity, int statusBarAlpha) {
        ViewGroup contentView = (ViewGroup) activity.findViewById(android.R.id.content);
        // 移除半�?�明矩形,以免叠加
        if (contentView.getChildCount() > 1) {
            contentView.removeViewAt(1);
        }
        contentView.addView(createTranslucentStatusBarView(activity, statusBarAlpha));
    }

    /**
     * 生成�?个和状�?�栏大小相同的彩色矩形条
     *
     * @param activity �?要设置的 activity
     * @param color    状�?�栏颜色�?
     * @return 状�?�栏矩形�?
     */
    private static View createStatusBarView(Activity activity, int color) {
        // 绘制�?个和状�?�栏�?样高的矩�?
        View statusBarView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            getStatusBarHeight(activity));
        statusBarView.setLayoutParams(params);
        statusBarView.setBackgroundColor(color);
        return statusBarView;
    }

    /**
     * 生成�?个和状�?�栏大小相同的半透明矩形�?
     *
     * @param activity �?要设置的activity
     * @param color    状�?�栏颜色�?
     * @param alpha    透明�?
     * @return 状�?�栏矩形�?
     */
    private static View createStatusBarView(Activity activity, int color, int alpha) {
        // 绘制�?个和状�?�栏�?样高的矩�?
        View statusBarView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            getStatusBarHeight(activity));
        statusBarView.setLayoutParams(params);
        statusBarView.setBackgroundColor(calculateStatusColor(color, alpha));
        return statusBarView;
    }

    /**
     * 设置根布�?参数
     */
    private static void setRootView(Activity activity) {
        ViewGroup rootView = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
        rootView.setFitsSystemWindows(true);
        rootView.setClipToPadding(true);
    }

    /**
     * 使状态栏透明
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private static void transparentStatusBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 创建半�?�明矩形 View
     *
     * @param alpha 透明�?
     * @return 半�?�明 View
     */
    private static View createTranslucentStatusBarView(Activity activity, int alpha) {
        // 绘制�?个和状�?�栏�?样高的矩�?
        View statusBarView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            getStatusBarHeight(activity));
        statusBarView.setLayoutParams(params);
        statusBarView.setBackgroundColor(Color.argb(alpha, 0, 0, 0));
        return statusBarView;
    }

    /**
     * 获取状�?�栏高度
     *
     * @param context context
     * @return 状�?�栏高度
     */
    private static int getStatusBarHeight(Context context) {
        // 获得状�?�栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }

    /**
     * 计算状�?�栏颜色
     *
     * @param color color�?
     * @param alpha alpha�?
     * @return �?终的状�?�栏颜色
     */
    private static int calculateStatusColor(int color, int alpha) {
        float a = 1 - alpha / 255f;
        int red = color >> 16 & 0xff;
        int green = color >> 8 & 0xff;
        int blue = color & 0xff;
        red = (int) (red * a + 0.5);
        green = (int) (green * a + 0.5);
        blue = (int) (blue * a + 0.5);
        return 0xff << 24 | red << 16 | green << 8 | blue;
    }
}
