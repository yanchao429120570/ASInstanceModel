package cn.com.asinstancemodel.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.PersistableBundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import cn.com.asinstancemodel.R;
import cn.com.asinstancemodel.base.BaseActivity;
import cn.com.asinstancemodel.handlerutils.HandlerUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends BaseActivity{

    Button bt,pBt;
    TextView tv;
    ImageView iv;
    String url = "https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3993198700,3740241574&fm=58";
    //更新
    

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        bt = (Button)getLayoutView(R.id.bt);
        pBt = (Button) getLayoutView(R.id.pBt);
        tv = (TextView)getLayoutView(R.id.tv);
        iv = (ImageView) getLayoutView(R.id.iv);
    }

    //创建okHttpClient对象
    OkHttpClient okHttpClient = new OkHttpClient();
    //创建一个Request
    Request request = new Request.Builder().url(url).build();
    //new call
    Call call = okHttpClient.newCall(request);

    @Override
    protected  void setListener(){
        pBt.setOnClickListener(this);
        bt.setOnClickListener(this);
    }

    int clickTimes = 0;

    @Override
    public void onClick(View view) {
        tv.setText("" + (++clickTimes));
        int id = view.getId();
        switch (id){
            case R.id.bt:
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.i("TAG","回调失败");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.i("TAG", "回调成功" + Thread.currentThread().getName());
                        InputStream is = response.body().byteStream();
                        final Bitmap bp = BitmapFactory.decodeStream(is);
                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                iv.setImageBitmap(bp);
                            }
                        });
                    }
                });
                break;
            case R.id.pBt:

                break;
        }
    }


}
