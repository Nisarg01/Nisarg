package com.foliobear.nisarg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartingPoint extends AppCompatActivity {

    int counter;
    Button add,sub;
    TextView display, ender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_point);

        counter=0;
        add = (Button) findViewById(R.id.But1view);
        sub = (Button) findViewById(R.id.But1view2);
        display = (TextView) findViewById(R.id.textView);
        ender = (TextView) findViewById(R.id.textView2);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter++;
                ender.setText("Your total is " + counter);
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                counter--;
                ender.setText("Your total is " + counter);
            }
        });
    }
}
