package com.foliobear.nisarg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by Nisarg on 11/17/2016.
 */



public class MyBringBack extends View {

    Bitmap pokeball, pikachu;


    public MyBringBack(Context context) {
        super(context);

        pokeball = BitmapFactory.decodeResource(getResources(), R.drawable.pokeball3);
        pikachu = BitmapFactory.decodeResource(getResources(), R.drawable.pikachu);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.setBitmap(pikachu);
    }
}
