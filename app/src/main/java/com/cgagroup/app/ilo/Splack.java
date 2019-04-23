package com.cgagroup.app.ilo;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splack);
        checkConnection();

        ImageView img = (ImageView)findViewById(R.id.cycal);
        Animation aniSlide = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoomout);
        img.startAnimation(aniSlide);
    }
    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
    public void checkConnection(){
        if(isOnline()){
            Thread background = new Thread() {
                public void run() {

                    try {
                        sleep(3*1000);

                        Intent intent = new Intent(Splack.this, MainActivity.class);
                        startActivity(intent);
                        finish();

                    } catch (Exception e) {

                    }
                }
            };

            // start thread
            background.start();
        }else{
////            Intent intent = new Intent(Splack_Activity.this,Fall_Internet.class);
//            startActivity(intent);
        }
    }
}
