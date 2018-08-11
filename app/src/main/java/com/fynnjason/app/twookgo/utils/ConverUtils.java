package com.fynnjason.app.twookgo.utils;


import com.google.gson.Gson;
import com.google.gson.JsonIOException;

public class ConverUtils {
    private static Gson create() {
        return GsonHolder.sGson;
    }

    private static class GsonHolder {
        private static Gson sGson = new Gson();
    }

    public static <T> T fromJson(String json, Class<T> tClass) throws JsonIOException {
        return create().fromJson(json, tClass);
    }
}
