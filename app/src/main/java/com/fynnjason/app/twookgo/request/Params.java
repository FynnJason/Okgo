package com.fynnjason.app.twookgo.request;

import com.fynnjason.app.twookgo.api.Api;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.request.PostRequest;

public class Params {

    /*用户登录*/
    public static PostRequest<String> login(String mobile, String password) {
        PostRequest<String> request = OkGo.<String>post(Api.LOGIN);
        request.params("mobile", mobile);
        request.params("password", password);
        return request;
    }

    /*用户信息*/
    public static PostRequest<String> user_info(String token) {
        PostRequest<String> request = OkGo.<String>post(Api.USER_INFO);
        request.headers("token", token);
        return request;
    }
}
