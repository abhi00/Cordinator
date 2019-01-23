package com.aptron.cordinator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ViewHomeWork extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Model> list;
    TextView title_bar;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_home_work);
        recyclerView = findViewById(R.id.homeWork_Post);
        mToolbar = findViewById(R.id.toolbar);
        title_bar = findViewById(R.id.toolbar_title);
        title_bar.setText("My HomWork");
        setSupportActionBar(mToolbar);

        list = new ArrayList();
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
        list.add(new Model(Model.TEXT_TYPE,"Hello Student Assignment:1 is Due",0,R.drawable.person,"Java",date));

        list.add(new Model(Model.IMAGE_TYPE,"How to create BroadCast",R.drawable.broadcast,R.drawable.person,"Php",date));

        list.add(new Model(Model.TEXT_TYPE,"Hello All Tommorrow is Off.",0,R.drawable.person,"Java",date));

        list.add(new Model(Model.IMAGE_TYPE,"How to create Meeting?",R.drawable.meeting,R.drawable.person,"Java",date));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new HomeWorkAdapter(list,ViewHomeWork.this));


    }

}
