package cn.com.asinstancemodel.base;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import cn.com.asinstancemodel.R;

public abstract class BaseActivity extends Activity  implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());
        initView();
        setListener();
    }

    protected abstract int getLayoutResID();

    protected void initView(){}

    protected android.view.View getLayoutView(int v){
        return findViewById(v);
    }

    @Override
    public void onClick(View view) {

    }

    protected  void setListener(){}

}
