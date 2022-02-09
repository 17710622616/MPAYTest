package com.cocacola.mpaytest;

import android.app.Application;

import ali.websocket.AliSocketCallBack;
import ali.websocket.AliSocketClient;

public class TestApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AliSocketClient.getInstance().WebSocket_Register("{\"name\":\"registerJsonString\"}", new AliSocketCallBack() {
            @Override
            public void onResponse(String s) {
                System.out.println("rgt resp:" + s);
            }

            @Override
            public void onFailure(Exception e) {
                e.getStackTrace();
            }
        });
    }
}
