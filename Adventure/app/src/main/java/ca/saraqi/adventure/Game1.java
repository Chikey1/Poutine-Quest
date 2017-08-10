package ca.saraqi.adventure;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import static ca.saraqi.adventure.R.anim.credit;

public class Game1 extends AppCompatActivity {

    private TextView wrong_screen;
    private TextView correct_screen;
    private int tries = 3;
    private Random rand = new Random();
    private int correct;
    private ImageView[] fries = new ImageView[9];
    private int currentRound = 1;
    private TextView correctText;
    private TextView title;
    private View xmark;
    private TextView hint;
    private View hintWindow;

    @Override
    public void onBackPressed() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        labelElements();
        createRound();
    }


    public void button(View view) {
        if((ImageView) findViewById(view.getId()) == fries[correct]) {
            correct_screen.setVisibility(View.VISIBLE);
            correctText.setVisibility(View.VISIBLE);
            currentRound++;
        }
        else {
            wrongButton();
        }
    }

    public void hint(View view) {

        switch(currentRound) {
            case 1:
                hint.setText(R.string.game1_hint1);
                break;
            case 2:
                hint.setText(R.string.game1_hint2);
                break;
            case 3:
                hint.setText(R.string.game1_hint3);
                break;
            default:
                break;
        }

        xmark.setVisibility(View.VISIBLE);
        hintWindow.setVisibility(View.VISIBLE);
        hint.setVisibility(View.VISIBLE);
    }

    public void closeWindow(View view) {
        xmark.setVisibility(View.GONE);
        hintWindow.setVisibility(View.GONE);
        hint.setVisibility(View.GONE);
    }

    public void startNextRound(View view) {
        if(currentRound < 4) {
            createRound();
            correct_screen.setVisibility(View.GONE);
            correctText.setVisibility(View.GONE);
        }
        else {
            Intent intent = new Intent(this, Completed1.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }

    private void createRound() {
        tries = 3;
        if(currentRound != 1){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                fries[correct].setImageDrawable(getResources().getDrawable(R.drawable.normalfries, getApplicationContext().getTheme()));
            } else {
                fries[correct].setImageDrawable(getResources().getDrawable(R.drawable.normalfries));
            }
        }
        correct = rand.nextInt(9);

        switch(currentRound) {
            case 1:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    fries[correct].setImageDrawable(getResources().getDrawable(R.drawable.badfries1, getApplicationContext().getTheme()));
                } else {
                    fries[correct].setImageDrawable(getResources().getDrawable(R.drawable.badfries1));
                }
                break;
            case 2:
                title.setText(R.string.game1_round2);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    fries[correct].setImageDrawable(getResources().getDrawable(R.drawable.badfries2, getApplicationContext().getTheme()));
                } else {
                    fries[correct].setImageDrawable(getResources().getDrawable(R.drawable.badfries2));
                }

                break;
            case 3:
                title.setText(R.string.game1_round3);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    fries[correct].setImageDrawable(getResources().getDrawable(R.drawable.badfries3, getApplicationContext().getTheme()));
                } else {
                    fries[correct].setImageDrawable(getResources().getDrawable(R.drawable.badfries3));
                }
                break;
            default:
                break;
        }
    }

    private void wrongButton() {
        tries--;
        if (tries <= 0) {
            Intent intent = new Intent(this, Gameover.class);
            intent.putExtra("EXTRA_ROUND", 1);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
        else {
            Animation flash = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fastflash);

            flash.setAnimationListener(new Animation.AnimationListener()
            {
                public void onAnimationEnd(Animation animation)
                {
                    wrong_screen.setVisibility(View.GONE);
                }
                public void onAnimationRepeat(Animation animation) {}
                public void onAnimationStart(Animation animation) {}
            });
            wrong_screen.setVisibility(View.VISIBLE);
            wrong_screen.startAnimation(flash);
        }
    }



    private void labelElements() {

        wrong_screen = (TextView) findViewById(R.id.wrong_screen);
        wrong_screen.setVisibility(View.GONE);
        correct_screen = (TextView) findViewById(R.id.correct_screen);
        correct_screen.setVisibility(View.GONE);
        correctText = (TextView) findViewById(R.id.correct_text);
        correctText.setVisibility(View.GONE);
        title = (TextView) findViewById(R.id.round_title);

        xmark = (View) findViewById(R.id.close_hint);
        xmark.setVisibility(View.GONE);
        hintWindow = (View) findViewById(R.id.hint_window);
        hintWindow.setVisibility(View.GONE);
        hint = (TextView) findViewById(R.id.hint);
        hint.setVisibility(View.GONE);


        fries[0] = (ImageView) findViewById(R.id.fries1);
        fries[1] = (ImageView) findViewById(R.id.fries2);
        fries[2] = (ImageView) findViewById(R.id.fries3);
        fries[3] = (ImageView) findViewById(R.id.fries4);
        fries[4] = (ImageView) findViewById(R.id.fries5);
        fries[5] = (ImageView) findViewById(R.id.fries6);
        fries[6] = (ImageView) findViewById(R.id.fries7);
        fries[7] = (ImageView) findViewById(R.id.fries8);
        fries[8] = (ImageView) findViewById(R.id.fries9);
    }
}
