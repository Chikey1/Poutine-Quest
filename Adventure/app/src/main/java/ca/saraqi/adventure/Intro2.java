package ca.saraqi.adventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Intro2 extends AppCompatActivity {

    private TextView introText10;
    private TextView introText11;
    private TextView introText12;

    private int taps = 0;

    private Animation animFadeIn;

    @Override
    public void onBackPressed() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);

        introText10 = (TextView) findViewById(R.id.intro_text10);
        introText10.setVisibility(View.GONE);
        introText11 = (TextView) findViewById(R.id.intro_text11);
        introText11.setVisibility(View.GONE);
        introText12 = (TextView) findViewById(R.id.intro_text12);
        introText12.setVisibility(View.GONE);

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
    }


    public void showText(View view) {
        taps++;
        if(taps == 1) {
            introText10.setVisibility(View.VISIBLE);
            introText10.startAnimation(animFadeIn);
        }

        else if(taps == 2) {
            introText10.clearAnimation();
            introText11.setVisibility(View.VISIBLE);
            introText11.startAnimation(animFadeIn);
        }

        else if(taps == 3) {
            introText11.clearAnimation();
            introText12.setVisibility(View.VISIBLE);
            introText12.startAnimation(animFadeIn);
        }
        else {
            Intent intent = new Intent(this, Challenge1.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}
