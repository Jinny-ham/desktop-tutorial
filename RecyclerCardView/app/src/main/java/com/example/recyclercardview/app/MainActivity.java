package com.example.recyclercardview.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.recyclercardview.R;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home Page!");

        toolbar.inflateMenu(R.menu.menu_main);
        
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {

    }

}