package com.foliobear.nisarg;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Nisarg on 10/14/2016.
 */

public class camera extends Activity {

    ImageButton ib;
    ImageView iv;
    Button b;
    Intent i;
    final static int cameraData = 0;
    Bitmap bmp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.photo);
        iv = (ImageView) findViewById(R.id.ivReturnedPicture);
        ib = (ImageButton) findViewById(R.id.ibTakePicture);
        b = (Button) findViewById(R.id.bSetWall);
        @SuppressWarnings("ResourceType") InputStream is = getResources().openRawResource(R.drawable.common_google_signin_btn_icon_dark);
        bmp = BitmapFactory.decodeStream(is);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                WallpaperManager myWallpaperManager
                        = WallpaperManager.getInstance(getApplicationContext());
                try {
                    myWallpaperManager.setBitmap(bmp);
                     }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, cameraData);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            bmp = (Bitmap) extras.get("data");
            iv.setImageBitmap(bmp);
        }
    }
}
