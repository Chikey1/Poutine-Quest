package ca.saraqi.adventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

public class Game3 extends AppCompatActivity {

    private int currentRiddle = 1;
    private String[] answers = new String[5];
    private EditText editText;
    private String input;
    private TextView riddle;
    private TextView title;
    private TextView wrong;
    private View xmark;
    private View window;
    private View hintButton;
    private View answerButton;
    private TextView text;

    private Animation flash;

    @Override
    public void onBackPressed() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);

        answers[1] = "egg";
        answers[2] = "squash";
        answers[3] = "doughnut";
        answers[4] = "donut";

        editText = (EditText) findViewById(R.id.input);
        riddle = (TextView) findViewById(R.id.riddle);
        title = (TextView) findViewById(R.id.title);
        wrong = (TextView) findViewById(R.id.wrong);
        xmark = findViewById(R.id.close_hint);
        window = findViewById(R.id.hint_window);
        hintButton = findViewById(R.id.hint_button);
        answerButton = findViewById(R.id.answer_button);
        text = (TextView) findViewById(R.id.hint);

        wrong.setVisibility(View.INVISIBLE);
        xmark.setVisibility(View.GONE);
        window.setVisibility(View.GONE);
        hintButton.setVisibility(View.GONE);
        answerButton.setVisibility(View.GONE);
        text.setVisibility(View.GONE);

        flash = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.flash);
    }

    public void submit(View view) {
        input = editText.getText().toString();
        editText.setText(null);

        if(answers[currentRiddle].equalsIgnoreCase(input) ||
                (currentRiddle == 3 && answers[4].equalsIgnoreCase(input))) {
            if(currentRiddle == 1) {
                riddle.setText(R.string.riddle2);
                title.setText(R.string.riddle2_title);
            }
            else if (currentRiddle == 2){
                riddle.setText(R.string.riddle3);
                title.setText(R.string.riddle3_title);
            }
            else {
                Intent intent = new Intent(this, Completed3.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
            currentRiddle++;
        }
        else {
            wrong.startAnimation(flash);
        }
    }

    public void hint(View view) {
        if(!text.getText().toString().equals(getString(R.string.hint_neutral))) {
            text.setText(R.string.hint_neutral);
        }

        xmark.setVisibility(View.VISIBLE);
        window.setVisibility(View.VISIBLE);
        hintButton.setVisibility(View.VISIBLE);
        answerButton.setVisibility(View.VISIBLE);
        text.setVisibility(View.VISIBLE);
    }

    public void showHint(View view) {
        if (currentRiddle == 1) {
            text.setText(R.string.hint1);
        }
        else if (currentRiddle == 2) {
            text.setText(R.string.hint2);
        }
        else {
            text.setText(R.string.hint3);
        }
    }

    public void showAnswer(View view) {
        if (currentRiddle == 1) {
            text.setText(R.string.answer1);
        }
        else if (currentRiddle == 2) {
            text.setText(R.string.answer2);
        }
        else {
            text.setText(R.string.answer3);
        }
    }

    public void closeWindow(View view) {
        xmark.setVisibility(View.GONE);
        window.setVisibility(View.GONE);
        hintButton.setVisibility(View.GONE);
        answerButton.setVisibility(View.GONE);
        text.setVisibility(View.GONE);
    }
}
