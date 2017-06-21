package com.foliobear.nisarg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Nisarg on 10/10/2016.
 */

public class email extends Activity {

    TextView name, emailName, lastName, animeName, bevName, actName, sport;
    EditText nameIp, emailNameIp, lastNameIp, animeNameIp, bevNameIp, actNameIp, sportIp;
    String nameAdd, emailNameAdd, lastNameAdd, animeAdd, bevAdd, actAdd, sportAdd;
    Button sendEmail;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.email);

        sendEmail = (Button) findViewById(R.id.butSave);


        name = (TextView) findViewById(R.id.tvName);
        emailName = (TextView) findViewById(R.id.tvEmailName);
        lastName = (TextView) findViewById(R.id.tvLastName);
        animeName = (TextView) findViewById(R.id.tvFavAnime);
        bevName = (TextView) findViewById(R.id.tvBeverage);
        actName = (TextView) findViewById(R.id.tvFavActor);
        sport = (TextView) findViewById(R.id.tvSport);

        nameIp = (EditText) findViewById(R.id.etName);
        lastNameIp = (EditText) findViewById(R.id.etLastName);
        emailNameIp = (EditText) findViewById(R.id.etEmailName);
        animeNameIp = (EditText) findViewById(R.id.etFavAnime);
        bevNameIp = (EditText) findViewById(R.id.etBeverage);
        actNameIp = (EditText) findViewById(R.id.etActor);
        sportIp = (EditText) findViewById(R.id.etSport);

        //Now to define button and image... Tudu!

    sendEmail.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            convertEditTextVarsIntoStrings();
            String emailAddress[] = {emailNameAdd};
            String message = "Hello,"
                    + "I know you are " + nameAdd + " " + lastNameAdd + '\n'
                    + "You like " + animeAdd + ", " + '\n' + bevAdd + ", " + 'n' + actAdd + " and " + '\n' + sportAdd + "."
                    + '\n' + '\n' + "Have a nice Day!" + '\n' + "Nisarg";

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.putExtra(Intent.EXTRA_EMAIL, emailAddress);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Greetings " + nameAdd);
            emailIntent.setType("plain/text");
            emailIntent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(emailIntent);
        }
    });
    }


    private void convertEditTextVarsIntoStrings() {

        nameAdd = nameIp.getText().toString();
        emailNameAdd = emailNameIp.getText().toString();
        lastNameAdd = lastNameIp.getText().toString();
        animeAdd = animeNameIp.getText().toString();
        bevAdd = bevNameIp.getText().toString();
        actAdd = actNameIp.getText().toString();
        sportAdd = sportIp.getText().toString();
    }


    @Override

    protected void onPause() {

        super.onPause();
        finish();

    }
}


