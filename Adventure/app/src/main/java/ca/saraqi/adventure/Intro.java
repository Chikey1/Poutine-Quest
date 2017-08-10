package ca.saraqi.adventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Intro extends AppCompatActivity {

    @Override
    public void onBackPressed() { }

    private TextView introText1;
    private TextView introText2;
    private TextView introText3;
    private TextView introText4;

    private int taps = 0;

    private Animation animFadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        introText1 = (TextView) findViewById(R.id.intro_text1);
        introText1.setVisibility(View.GONE);
        introText2 = (TextView) findViewById(R.id.intro_text2);
        introText2.setVisibility(View.GONE);
        introText3 = (TextView) findViewById(R.id.intro_text3);
        introText3.setVisibility(View.GONE);
        introText4 = (TextView) findViewById(R.id.intro_text4);
        introText4.setVisibility(View.GONE);

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
    }

    public void showText(View view) {
        taps++;
        if(taps == 1) {
            introText1.setVisibility(View.VISIBLE);
            introText1.startAnimation(animFadeIn);
        }

        else if(taps == 2) {
            introText1.clearAnimation();
            introText2.setVisibility(View.VISIBLE);
            introText2.startAnimation(animFadeIn);
        }

        else if(taps == 3) {
            introText2.clearAnimation();
            introText3.setVisibility(View.VISIBLE);
            introText3.startAnimation(animFadeIn);
        }
        else if(taps == 4) {
            introText3.clearAnimation();
            introText4.setVisibility(View.VISIBLE);
            introText4.startAnimation(animFadeIn);
        }
        else {
            Intent intent = new Intent(this, Intro1.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }



}
