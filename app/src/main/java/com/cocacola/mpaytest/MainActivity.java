package com.cocacola.mpaytest;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.macau.pay.sdk.OpenSdk;
import com.macau.pay.sdk.base.ConstantBase;
import com.macau.pay.sdk.base.PayResult;
import com.macau.pay.sdk.interfaces.OpenSdkInterfaces;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //callMpayPayment();

                /*long timespan = System.currentTimeMillis();
                Intent intent = new Intent("extra.mdm.request");
                intent.putExtra("Timestamp",(timespan- 10*60*3600)/1000);
                intent.putExtra("Cmd",0x006);
                intent.putExtra("Milliseconds",(timespan- 10*60*3600));
                sendBroadcast(intent);
                String result2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((timespan- 10*60*3600));*/
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void callMpayPayment() {
        try {
            /*Map<String, String> paramsMap = new HashMap<>();
            paramsMap.put("service", "mpay.online.trade.precreate");
            paramsMap.put("org_id", "888534816531603");
            paramsMap.put("channel_type", "2");
            paramsMap.put("sign_type", "MD5");
            paramsMap.put("format", "JSON");
            paramsMap.put("timestamp", String.valueOf(System.currentTimeMillis()));
            paramsMap.put("nonce_str", "WAx4XSsF24");
            paramsMap.put("version", "1.1.0");
            paramsMap.put("out_trans_id", "12");
            paramsMap.put("pay_channel", "mpay");
            paramsMap.put("total_fee", "0.1");
            paramsMap.put("subject", "easy!易洗訂單");
            paramsMap.put("currency", "MOP");
            paramsMap.put("product_code", "MP_APP_PAY");
            paramsMap.put("sign", "MD5");
            Map<String, String> extend_params = new HashMap();
            extend_params.put("sub_merchant_name", "萬洋匯");
            extend_params.put("sub_merchant_id", "888534816531603");
            extend_params.put("sub_merchant_industry", "4816");
            paramsMap.put("extend_params", new Gson().toJson(extend_params));*/
            //String params = new Gson().toJson(paramsMap);
            String params = "{\"nonce_str\":\"9eb3a6e932484d4089f746f9f78d8395\",\"extend_params\":{\"sub_merchant_name\":\"萬洋匯\",\"sub_merchant_id\":\"888534816531603\",\"sub_merchant_industry\":\"4816\"},\"subject\":\"西装2套*3,\",\"format\":\"JSON\",\"sign\":\"8dda38aff40ac9e3e16e5336b3971591\",\"it_b_pay\":\"5m\",\"notify_url\":\"https://www.easyapp.life/order/mpayNotify\",\"body\":\"西装2套*3,\",\"product_code\":\"MP_APP_PAY\",\"version\":\"1.1.0\",\"out_trans_id\":\"C202201071853226180001\",\"service\":\"mpay.trade.mobile.pay\",\"org_id\":\"888534816531603\",\"total_fee\":\"254.72\",\"pay_channel\":\"mpay\",\"currency\": \"MOP\",\"channel_type\": \"1\",\"sign_type\": \"MD5\",\"timestamp\": \"1641552802630\"}";
            OpenSdk.setEnvironmentType(2);
            OpenSdk.setMPayAppId(ConstantBase.ConnectUrl_UAT);
            OpenSdk.newPayAll(this, params, new OpenSdkInterfaces() {
                @Override
                public void OpenSDKInterfaces(PayResult payResult) {

                    Toast.makeText(MainActivity.this, "result:" + new Gson().toJson(payResult), Toast.LENGTH_LONG).show();
                }

                @Override
                public void AliPayInterfaces(PayResult payResult) {
                    Toast.makeText(MainActivity.this, "2" + new Gson().toJson(payResult), Toast.LENGTH_LONG).show();
                }

                @Override
                public void MPayInterfaces(PayResult payResult) {
                    Toast.makeText(MainActivity.this, "3" + new Gson().toJson(payResult), Toast.LENGTH_LONG).show();
                }

                @Override
                public void WeChatPayInterfaces(PayResult payResult) {
                    Toast.makeText(MainActivity.this, "4" + new Gson().toJson(payResult), Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}