package com.bas.bac_a_sable_swipe;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class SwipeGestureDetector extends GestureDetector {

    public SwipeGestureDetector(final MainActivity context) {
        super(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Float deltaX = e2.getX() - e1.getX();
                Float deltaY = e2.getY() - e1.getY();

                if (Math.abs(deltaX) > Math.abs(deltaY)){
                    // si la valeur absolue de delta X est supérieure au delta Y, alors on bouge de manière horizontale
                    if (deltaX < 0){
                        // on se déplace vers la gauche
                        context.onSwipe(SwipeDirection.RIGHT_TO_LEFT);
                        return true;
                    }else{
                        // on se déplace vers la droite
                        context.onSwipe(SwipeDirection.LEFT_TO_RIGHT);
                        return true;
                    }
                }else{
                    // si la valeur absolue de delta Y est supérieure au delta X, alors on bouge de manière verticale
                    if (deltaY < 0){
                        // on se déplace vers le haut
                        context.onSwipe(SwipeDirection.BOTTOM_TO_TOP);
                        return true;

                    }else{
                        // on se déplace vers le bas
                        context.onSwipe(SwipeDirection.TOP_TO_BOTTOM);
                        return true;
                    }
                }
            }
        });

    }

    // déclaration de constante
    public static enum SwipeDirection{
        LEFT_TO_RIGHT, RIGHT_TO_LEFT, TOP_TO_BOTTOM, BOTTOM_TO_TOP
    }
}

