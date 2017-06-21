package com.foliobear.nisarg;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Nisarg on 9/26/2016.
 */

public class Menu extends ListActivity {

    //String classes[] = {"StartingPoint", "Splash", "Menu", "textPlay", "email", "camera", "GFX"};

    String classes[] = {"Lite", "Menu"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_expandable_list_item_1, classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String ClickedItem = classes[position];
        Class ourClass = null;
        try {
            ourClass = Class.forName("com.foliobear.nisarg." + ClickedItem);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Intent ourIntent = new Intent(Menu.this, ourClass);
        startActivity(ourIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.cool_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.aboutUs:

                Intent i = new Intent("com.foliobear.nisarg.ABOUT");
                startActivity(i);
                break;
            case R.id.preferences:

                break;
        }

        return false;
    }

}
