package ca.saraqi.adventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Completed3 extends AppCompatActivity {

    private TextView text1;
    private TextView text2;

    private int taps = 0;

    private Animation animFadeIn;

    @Override
    public void onBackPressed() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed3);

        text1 = (TextView) findViewById(R.id.completed3_text2);
        text1.setVisibility(View.GONE);
        text2 = (TextView) findViewById(R.id.completed3_text3);
        text2.setVisibility(View.GONE);

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

        else {
            Intent intent = new Intent(this, Ending1.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }
}
