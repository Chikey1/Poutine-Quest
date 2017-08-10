package ca.saraqi.adventure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView credit;
    private View start;

    @Override
    public void onBackPressed() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        credit = (TextView) findViewById(R.id.credit);
        start = (View) findViewById(R.id.start_button);
        start.setVisibility(View.GONE);
        credit.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        if(hasFocus){
            Animation creditAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.credit);
            final Animation fadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

            creditAnim.setAnimationListener(new Animation.AnimationListener()
            {
                public void onAnimationEnd(Animation animation)
                {
                    credit.setVisibility(View.GONE);
                    start.setVisibility(View.VISIBLE);
                    start.startAnimation(fadeIn);
                }
                public void onAnimationRepeat(Animation animation) {}
                public void onAnimationStart(Animation animation) {}
            });

            credit.startAnimation(creditAnim);
        }
    }


    public void startIntro(View view) {
        Intent intent = new Intent(this, Intro.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

}
