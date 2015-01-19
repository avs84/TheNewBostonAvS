package com.example.thenewbostonavs;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by AvanSchuijlenborgh on 24-11-2014.
 */
public class Menu extends ListActivity {

    String classes[] = {"MainActivity", "TextPlay", "Email", "Camera", "Data", "example5", "example6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String cheese = classes[position];

        try {
            Class ourClass = Class.forName("com.example.thenewbostonavs." + cheese);
            Intent OurIntent = new Intent(Menu.this, ourClass);
            startActivity(OurIntent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
        switch (item.getItemId()) {
            case R.id.aboutUs:
                Intent i = new Intent("com.example.thenewbostonavs.ABOUT");
                startActivity(i);

                break;
            case R.id.preferences:
                Intent p = new Intent("com.example.thenewbostonavs.PREFS");
                startActivity(p);
                break;
            case R.id.exit:
                finish();
                break;
        }
        return false;
    }

}
