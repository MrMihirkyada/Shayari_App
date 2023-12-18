package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Splash_Screen_Activity extends AppCompatActivity
{

    ImageView imgShayari;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (Build.VERSION.SDK_INT >= 21)
        {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.Blue));
        }

        initview();
    }

    private void initview()
    {

        imgShayari = findViewById(R.id.imgShayari);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
//                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation);
//                imgShayari.startAnimation(rotate);

                Animation blink = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
                imgShayari.startAnimation(blink);

                Intent i = new Intent(Splash_Screen_Activity.this, Recycler_View_Activity.class);
                startActivity(i);
                finish();
            }
        },2000);

    }
}