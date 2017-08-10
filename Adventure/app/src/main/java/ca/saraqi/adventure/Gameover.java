package ca.saraqi.adventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Gameover extends AppCompatActivity {

    @Override
    public void onBackPressed() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
    }

    public void quit(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

    public void retry(View view) {
        Intent intent;
        int round = getIntent().getIntExtra("EXTRA_ROUND",0);
        if (round == 0) {
            return;
        }
        else if (round == 1) {
            intent = new Intent(this, Instructions1.class);
        }
        else { //round ==2
            intent = new Intent(this, Instructions2.class);
        }
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
    }

}
