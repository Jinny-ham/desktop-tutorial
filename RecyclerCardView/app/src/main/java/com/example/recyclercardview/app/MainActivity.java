package com.example.recyclercardview.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.recyclercardview.R;
import com.example.recyclercardview.adapter.RecyclerAdapter;
import com.example.recyclercardview.model.Landscape;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home Page");
        toolbar.inflateMenu(R.menu.menu_main);
        
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        RecyclerAdapter adapter = new RecyclerAdapter(this, Landscape.getData());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

        recyclerView.setItemAnimator(new DefaultItemAnimator()); //없어도 기본애니메이터 사용함
    }

}