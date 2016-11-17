package cn.com.asinstancemodel.okhttputils;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by lenovo on 2016/11/17.
 */
public class OkHttpUtils {

    //创建okHttpClient对象
    protected OkHttpClient okHttpClient = new OkHttpClient();
    //创建一个Request
    Request request;
    //new call
    Call call;

    public OkHttpUtils(String url){
        request = new Request.Builder().url(url).build();
        call = okHttpClient.newCall(request);
    }

    //get请求


}
