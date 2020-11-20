package com.example.restdashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView2;
    private RestaurantAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Restaurant> list = new ArrayList<>();
    private Button btn;
    private NestedScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        scrollView = findViewById(R.id.scrollView);

        //Setting
        recyclerView2 = findViewById(R.id.recyclerView);
        recyclerView2.setHasFixedSize(false);//increase performance
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setNestedScrollingEnabled(false);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));


        //for (Object article:response.body().getArticleWrappers()) {
            //list.add(new Restaurant("name1","tag1"));
            //list.add(new Restaurant("name2","tag2"));
            //list.add(new Restaurant("name3","tag3"));
        //}

        if(list.isEmpty()){
            btn.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }

        adapter = new RestaurantAdapter(list,this);

        adapter.setOnItemClickListener(new RestaurantAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                //imageView = view.findViewById(R.id.img);
            }
        });

        recyclerView2.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.res_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_res) {
            //Intent intent = new Intent(this, MonthlyReportActivity.class);
           // startActivity(intent);
        }else if (item.getItemId() == R.id.about) {

        }else if (item.getItemId() == R.id.restaurants) {

        }
        return super.onOptionsItemSelected(item);
    }
}