package cn.com.asinstancemodel.handlerutils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by lenovo on 2016/11/17.
 */
public class HandlerUtils extends Handler {

    static HandlerUtils handlerUtils ;

    private HandlerUtils(){
        handlerUtils = new HandlerUtils();
    }

    public static Handler getHandler(){
        if(handlerUtils == null){
            handlerUtils = new HandlerUtils();
        }
        return handlerUtils;
    }

}
