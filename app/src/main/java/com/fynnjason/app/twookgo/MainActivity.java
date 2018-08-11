package com.fynnjason.app.twookgo;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fynnjason.app.twookgo.callback.CallBack;
import com.fynnjason.app.twookgo.model.LoginModel;
import com.fynnjason.app.twookgo.model.UserModel;
import com.fynnjason.app.twookgo.request.Request;
import com.fynnjason.app.twookgo.utils.ConverUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_login();
            }
        });
    }

    /*登录*/
    private void get_login() {
        Request.LOGIN("账号", "密码", new CallBack<String>() {
            @Override
            public void success(String json) {
                if (null != json) {
                    LoginModel.DataBean model = ConverUtils.fromJson(json, LoginModel.DataBean.class);
                    Log.e("MainActivity", "success: " + model.getToken());
                    //登录完成，获取用户信息
                    get_user_info(model.getToken());
                }
            }

            @Override
            public void failure(String msg) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*获取用户信息*/
    private void get_user_info(String token) {
        Request.USER_INFO(token, new CallBack<String>() {
            @Override
            public void success(String json) {
                if (null != json) {
                    UserModel.DataBean model = ConverUtils.fromJson(json, UserModel.DataBean.class);
                    Log.e("MainActivity", "success: " + model.getMobile());
                }
            }

            @Override
            public void failure(String msg) {
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
