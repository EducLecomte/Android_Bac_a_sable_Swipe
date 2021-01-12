package com.bas.bac_a_sable_swipe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // attribut
    private SwipeGestureDetector gestureDetector;
    private int nbswipe;
    private TextView tv_nbswipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        gestureDetector=new SwipeGestureDetector(this);
        this.nbswipe=0;
        tv_nbswipe=findViewById(R.id.tv_nbswipe);
        majAffichage();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        gestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    public void onSwipe(SwipeGestureDetector.SwipeDirection swipeDirection){
        switch (swipeDirection){
            case LEFT_TO_RIGHT:
                nbswipe++;
                majAffichage();
                break;
            case RIGHT_TO_LEFT:
                nbswipe--;
                majAffichage();
                break;
            case TOP_TO_BOTTOM:
                nbswipe=nbswipe-10;
                majAffichage();
                break;
            case BOTTOM_TO_TOP:
                nbswipe=nbswipe+10;
                majAffichage();
                break;
        }
    }


    public void majAffichage(){
        tv_nbswipe.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.fade_in));
        tv_nbswipe.setText(String.format(getString(R.string.nbswipe), nbswipe));
    }
}
