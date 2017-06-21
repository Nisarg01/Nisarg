package com.foliobear.nisarg;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Nisarg on 11/14/2016.
 */

public class GFX extends Activity {

    MyBringBack ourView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ourView = new MyBringBack(this);
        setContentView(ourView);
    }
}
