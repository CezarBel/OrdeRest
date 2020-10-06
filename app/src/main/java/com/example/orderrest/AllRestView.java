package com.example.orderrest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class AllRestView extends AppCompatActivity {

    AllRestAdapter adapter;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImagesUrls = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_rest_view);

        initImageBitMaps();


    }
    private void initImageBitMaps(){
        mImagesUrls.add("https://vegansontop.co.il/wp-content/uploads/11008400_1048299525198960_8866684906094826302_n.jpg");
        mNames.add("בנדיקט");
        mImagesUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTHnD8IjP8yi8L-DQWD0tRGHK4TdWjBn8w73Q&usqp=CAU");
        mNames.add("HAMBURG");
        mImagesUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTAo98_jttTVZTeboj3PKdifrz18zbsrdCbFw&usqp=CAU");
        mNames.add("Sunset BLVD");
        mImagesUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcR89aR2Rq8tGWx0sbkyhx_Sa6CCE-7muYyX4w&usqp=CAU");
        mNames.add("הנשיא 1");
        mImagesUrls.add("https://bigshow-music.com/wp-content/uploads/2017/04/d64c-45b6-4452-ac86-8a0f4ddfa690.jpg");
        mNames.add("ארצ'י");
        mImagesUrls.add("https://upload.wikimedia.org/wikipedia/he/thumb/c/c9/Aroma_Espresso_Bar_Logo.svg/1200px-Aroma_Espresso_Bar_Logo.svg.png");
        mNames.add("ארומה");
        mImagesUrls.add("https://www.ispro.co.il/sites/ishpro/UserContent/images/%D7%9C%D7%A0%D7%93%D7%95%D7%95%D7%A8%201.jpg");
        mNames.add("לנדוור");
        mImagesUrls.add("https://upload.wikimedia.org/wikipedia/he/thumb/5/5b/CafeCafe.svg/1200px-CafeCafe.svg.png");
        mNames.add("קפה קפה");
        mImagesUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQ5kwFlfKcRZIOaQSzCRHc_Xw8hUazp5aWK6g&usqp=CAU");
        mNames.add("ג'פאניקה");
        mImagesUrls.add("https://ramot-mall.co.il/wp-content/uploads/2020/01/LOGO-70.png");
        mNames.add("פיצה האט");


        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.all_Rest);
         adapter = new AllRestAdapter(mNames,mImagesUrls,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_manu,menu);
        MenuItem item = menu.findItem(R.id.search_rest);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}