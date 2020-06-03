package com.example.materialdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Hello!");
        toolbar.setSubtitle("Folks!");

//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//            toolbar.setElevation(10f);
//        }

        //.setLogo(R.drawable.);
        //toolbar.setNavigationIcon();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String msg = "";

        switch (item.getItemId()){
            case R.id.discard:
                msg = "Delete";
                break;
            case R.id.search:
                msg = "Search";
                break;
            case R.id.edit:
                msg = "Edit";
                break;
            case R.id.settings:
                msg = "Settings";
                break;
            case R.id.exit:
                msg = "Exit";
                break;
        }

        Toast.makeText(this, msg + " clicked!", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }


}