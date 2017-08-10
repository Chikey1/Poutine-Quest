package ca.saraqi.adventure;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Game2 extends AppCompatActivity {
    private boolean choice[] = new boolean[3];
    private boolean chosen[] = new boolean[3];
    private View item[] = new View[6];

    private Drawable highlight;

    @Override
    public void onBackPressed() { }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2choice);
        labelElements();
        //hideElements();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            highlight = getResources().getDrawable(R.drawable.border, null);
        } else{
            highlight = getResources().getDrawable( R.drawable.border);
        }
    }

    public void next(View view) {
        for(int i = 0; i < 3; i++){
            if(!chosen[i])
                return;
        }
        Intent intent = new Intent(this, Game2Result.class);
        intent.putExtra("EXTRA_CHOICES", choice);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void selectWoodenSpoon(View view) {
        if(!chosen[0])
            chosen[0] = true;
        else
            item[0].setBackground(null);
        item[1].setBackground(highlight);
        choice[0] = true;
    }

    public void selectPlasticSpoon(View view) {
        if(!chosen[0])
            chosen[0] = true;
        else
            item[1].setBackground(null);
        item[0].setBackground(highlight);
        choice[0] = false;
    }

    public void selectKnife(View view) {
        if(!chosen[1])
            chosen[1] = true;
        else
            item[3].setBackground(null);
        item[2].setBackground(highlight);
        choice[1] = true;
    }

    public void selectFork(View view) {
        if(!chosen[1])
            chosen[1] = true;
        else
            item[2].setBackground(null);
        item[3].setBackground(highlight);
        choice[1] = false;
    }

    public void selectTorch(View view) {
        if(!chosen[2])
            chosen[2] = true;
        else
            item[5].setBackground(null);
        item[4].setBackground(highlight);
        choice[2] = true;
    }

    public void selectLemon(View view) {
        if(!chosen[2])
            chosen[2] = true;
        else
            item[4].setBackground(null);
        item[5].setBackground(highlight);
        choice[2] = false;
    }

    private void labelElements() {
        item[0] = (View) findViewById(R.id.plastic_spoon);
        item[1] = (View) findViewById(R.id.wooden_spoon);

        item[2] = (View) findViewById(R.id.knife);
        item[3] = (View) findViewById(R.id.fork);

        item[4] = (View) findViewById(R.id.blow_torch);
        item[5] = (View) findViewById(R.id.lemon_juice);
    }
}
