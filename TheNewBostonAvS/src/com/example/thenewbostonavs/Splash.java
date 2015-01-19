package com.example.thenewbostonavs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by AvanSchuijlenborgh on 24-11-2014.
 */
public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle AvsLovesBacon) {
        super.onCreate(AvsLovesBacon);
        setContentView(R.layout.splash);

        Thread timer = new Thread(){
           public void run (){
            try{
                sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally{
                Intent openMainActivity = new Intent("com.example.thenewbostonavs.MENU" );
                startActivity(openMainActivity);
            }
           }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
