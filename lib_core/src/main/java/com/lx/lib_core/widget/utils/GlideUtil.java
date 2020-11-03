package com.lx.lib_core.widget.utils;

import android.app.PendingIntent;
import android.content.Context;
import android.view.animation.Transformation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.lx.lib_core.R;

public
/**
 *@author : 阿森
 *@date : 2020-11-03 09:57
 *@params : 
 *@description:
 */
class GlideUtil {

    private static GlideUtil instance;

    public static GlideUtil getInstance() {
        if(instance == null) {
            instance = new GlideUtil();
        }
        return instance;
    }

    public void showImg(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).placeholder(R.drawable.loading_grey).error(R.drawable.error).into(imageView);
    }

    public void showCircleImg(Context context, String url, ImageView imageView) {
        Glide.with(context).load(url).transform(new CircleCrop()).placeholder(R.drawable.loading_grey).error(R.drawable.error).into(imageView);
    }

    public void showConnerImg(Context context, String url, ImageView imageView,int radius) {
        RoundedCorners roundedCorners = new RoundedCorners(radius);
        RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners);
        Glide.with(context).load(url).apply(requestOptions).placeholder(R.drawable.loading_grey).error(R.drawable.error).into(imageView);
    }

}
