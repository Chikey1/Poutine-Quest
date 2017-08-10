package ca.saraqi.adventure;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Game2Result extends AppCompatActivity {
    private boolean[] choice;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private ImageView image;
    private int textPresent = 1;
    private int currentResult = 1;
    private Animation animFadeIn;

    @Override
    public void onBackPressed() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2_result);
        choice = getIntent().getBooleanArrayExtra("EXTRA_CHOICES");
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);

        labelElements();
        initialVisibility();
    }


    public void next(View view) {
        if(textPresent == 4){
            if(currentResult == 3 && choice[2]){
                Intent intent = new Intent(this, Completed2.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
            else
                nextResult();
        }
        else if (currentResult == 3){
            result3();
        }
        else if (currentResult == 2){
            result2();
        }
        else {
            result1();
        }
    }

    private void nextResult(){
        if(!choice[currentResult-1]){
            Intent intent = new Intent(this, Gameover.class);
            intent.putExtra("EXTRA_ROUND", 2);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            return;
        }

        text1.setVisibility(View.GONE);
        text2.setVisibility(View.GONE);
        text3.setVisibility(View.GONE);
        text4.setVisibility(View.GONE);
        image.setVisibility(View.GONE);
        text4.clearAnimation();
        if(currentResult == 1){
            text1.setText(R.string.game2_result2text);
            text1.setVisibility(View.VISIBLE);
            text1.startAnimation(animFadeIn);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                image.setImageDrawable(getResources().getDrawable(R.drawable.result2, getApplicationContext().getTheme()));
            } else {
                image.setImageDrawable(getResources().getDrawable(R.drawable.result2));
            }
            image.setVisibility(View.VISIBLE);
            image.startAnimation(animFadeIn);
        }
        else{
            text1.setText(R.string.game2_result3text);
            text1.setVisibility(View.VISIBLE);
            text1.startAnimation(animFadeIn);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                image.setImageDrawable(getResources().getDrawable(R.drawable.result3, getApplicationContext().getTheme()));
            } else {
                image.setImageDrawable(getResources().getDrawable(R.drawable.result3));
            }
            image.setVisibility(View.VISIBLE);
            image.startAnimation(animFadeIn);
        }

        currentResult++;
        textPresent = 1;
    }

    private void result1(){
        if(textPresent == 1) {
            if(choice[0])
                text2.setText(R.string.game2_result1right);
            else
                text2.setText(R.string.game2_result1wrong);
            text2.setVisibility(View.VISIBLE);
            text2.startAnimation(animFadeIn);
        }

        else if(textPresent == 2) {
            if(choice[0])
                text3.setText(R.string.game2_result1right1);
            else
                text3.setText(R.string.game2_result1wrong1);
            text2.clearAnimation();
            text3.setVisibility(View.VISIBLE);
            text3.startAnimation(animFadeIn);
        }

        else {
            if(choice[0])
                text4.setText(R.string.game2_result1right2);
            else
                text4.setText(R.string.game2_result1wrong2);
            text3.clearAnimation();
            text4.setVisibility(View.VISIBLE);
            text4.startAnimation(animFadeIn);
        }
        textPresent++;
    }

    private void result2(){
        if(textPresent == 1) {
            image.clearAnimation();
            if(choice[1])
                text2.setText(R.string.game2_result2right);
            else
                text2.setText(R.string.game2_result2wrong);
            text1.clearAnimation();
            text2.setVisibility(View.VISIBLE);
            text2.startAnimation(animFadeIn);
        }

        else if(textPresent == 2) {
            if(choice[1])
                text3.setText(R.string.game2_result2right1);
            else
                text3.setText(R.string.game2_result2wrong1);
            text2.clearAnimation();
            text3.setVisibility(View.VISIBLE);
            text3.startAnimation(animFadeIn);
        }

        else {
            if(choice[1])
                text4.setText(R.string.game2_result2right2);
            else
                text4.setText(R.string.game2_result2wrong2);
            text3.clearAnimation();
            text4.setVisibility(View.VISIBLE);
            text4.startAnimation(animFadeIn);
        }
        textPresent++;
    }

    private void result3(){
        if(textPresent == 1) {
            image.clearAnimation();
            if(choice[2])
                text2.setText(R.string.game2_result3right);
            else
                text2.setText(R.string.game2_result3wrong);
            text1.clearAnimation();
            text2.setVisibility(View.VISIBLE);
            text2.startAnimation(animFadeIn);
        }

        else if(textPresent == 2) {
            if(choice[2])
                text3.setText(R.string.game2_result3right1);
            else
                text3.setText(R.string.game2_result3wrong1);
            text2.clearAnimation();
            text3.setVisibility(View.VISIBLE);
            text3.startAnimation(animFadeIn);
        }

        else {
            if(choice[2])
                text4.setText(R.string.game2_result3right2);
            else
                text4.setText(R.string.game2_result3wrong2);
            text3.clearAnimation();
            text4.setVisibility(View.VISIBLE);
            text4.startAnimation(animFadeIn);
        }
        textPresent++;
    }

    private void initialVisibility() {
        text2.setVisibility(View.GONE);
        text3.setVisibility(View.GONE);
        text4.setVisibility(View.GONE);
    }

    private void labelElements() {
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        image = (ImageView) findViewById(R.id.imageView);
    }
}
