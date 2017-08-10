package ca.saraqi.adventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Intro1 extends AppCompatActivity {

    private TextView introText6;
    private TextView introText7;
    private TextView introText8;

    private int taps = 0;

    private Animation animFadeIn;

    @Override
    public void onBackPressed() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro1);

        introText6 = (TextView) findViewById(R.id.intro_text6);
        introText6.setVisibility(View.GONE);
        introText7 = (TextView) findViewById(R.id.intro_text7);
        introText7.setVisibility(View.GONE);
        introText8 = (TextView) findViewById(R.id.intro_text8);
        introText8.setVisibility(View.GONE);

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
    }


    public void showText(View view) {
        taps++;
        if(taps == 1) {
            introText6.setVisibility(View.VISIBLE);
            introText6.startAnimation(animFadeIn);
        }

        else if(taps == 2) {
            introText6.clearAnimation();
            introText7.setVisibility(View.VISIBLE);
            introText7.startAnimation(animFadeIn);
        }

        else if(taps == 3) {
            introText7.clearAnimation();
            introText8.setVisibility(View.VISIBLE);
            introText8.startAnimation(animFadeIn);
        }
        else {
            Intent intent = new Intent(this, Intro2.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}
