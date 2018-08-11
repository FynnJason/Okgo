package com.fynnjason.app.twookgo.request;

import com.fynnjason.app.twookgo.callback.CallBack;
import com.fynnjason.app.twookgo.encypt.Encypt;
import com.fynnjason.app.twookgo.model.BaseModel;
import com.fynnjason.app.twookgo.utils.ConverUtils;
import com.google.gson.JsonIOException;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class Request {

    /*用户登录*/
    public static void LOGIN(String mobile, String password, CallBack<String> callBack) {
        Params.login(mobile, password).execute(mCallback(callBack));
    }

    /*用户信息*/
    public static void USER_INFO(String token, CallBack<String> callBack) {
        Params.user_info(token).execute(mCallback(callBack));
    }

    /**
     * 统一接口返回封装
     *
     * @param callBack
     * @return
     */
    private static StringCallback mCallback(final CallBack<String> callBack) {
        return new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                //获取data:的位置
                int i = response.body().indexOf("\"data\":");
                //获取data:后面的string
                String json = response.body().substring(i + 7, response.body().length() - 1);
                //加密json数据，重写写入json
                String endJson = response.body().replace(json, "\"" + Encypt.en(json) + "\"");
                try {
                    BaseModel baseModel = ConverUtils.fromJson(endJson, BaseModel.class);
                    if (baseModel.getCode() == 200) {
                        //解密返回json
                        String deJson = Encypt.de(baseModel.getData());
                        //判断有无数据，根据自身公司实际情况，看写不写这句话，比如列表数据，有的公司是特定的code说明无更多数据，有的公司code永远是200，只叫你判断返回的数组是不是空
                        if (deJson.equals("[]")) {
                            callBack.success(null);
                        } else {
                            callBack.success(deJson);
                        }
                    } else {
                        callBack.failure(baseModel.getMsg());
                    }
                } catch (JsonIOException e) {
                    callBack.failure(e.getMessage());
                }
            }

            @Override
            public void onError(Response<String> response) {
                callBack.failure("联网失败");
            }
        };
    }
}
