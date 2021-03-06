package ca.saraqi.adventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Challenge1 extends AppCompatActivity {

    private TextView text1;
    private TextView text2;
    private TextView text3;

    private int taps = 0;

    private Animation animFadeIn;

    @Override
    public void onBackPressed() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge1);

        text1 = (TextView) findViewById(R.id.challenge1_text2);
        text1.setVisibility(View.GONE);
        text2 = (TextView) findViewById(R.id.challenge1_text3);
        text2.setVisibility(View.GONE);
        text3 = (TextView) findViewById(R.id.challenge1_text4);
        text3.setVisibility(View.GONE);

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
    }


    public void showText(View view) {
        taps++;
        if(taps == 1) {
            text1.setVisibility(View.VISIBLE);
            text1.startAnimation(animFadeIn);
        }

        else if(taps == 2) {
            text1.clearAnimation();
            text2.setVisibility(View.VISIBLE);
            text2.startAnimation(animFadeIn);
        }

        else if(taps == 3) {
            text2.clearAnimation();
            text3.setVisibility(View.VISIBLE);
            text3.startAnimation(animFadeIn);
        }
        else {
            Intent intent = new Intent(this, Instructions1.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}
