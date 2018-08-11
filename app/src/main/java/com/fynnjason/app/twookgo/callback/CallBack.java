package com.fynnjason.app.twookgo.callback;


public interface CallBack<T> {
    void success(T json);

    void failure(String msg);
}
