package com.example.orderrest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class HamburgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hamburg);
        getIncomingIntent();

        Button navButton = findViewById(R.id.nav_hamburg);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HamburgActivity.this,MapHamburgActivity.class);
                startActivity(intent);
            }
        });
    }
    private void getIncomingIntent(){
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("restaurants_names")){
            String imageUrl = getIntent().getStringExtra("image_url");
            String restName = getIntent().getStringExtra("restaurants_names");

            setData(imageUrl,restName);
        }
    }

    private void setData(String imageUrl,String restName){
        TextView name = findViewById(R.id.rest_name);
        name.setText(restName);

        ImageView image = findViewById(R.id.rest_logo);
        Glide.with(this).asBitmap().load(imageUrl).into(image);
    }

    //--------open website--------\\
    public void hamburgWeb(View view){
        openUrl("https://hamburg.co.il/");
    }
    public void openUrl(String url){
        Uri uri = Uri.parse(url);
        Intent hamburgWeb = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(hamburgWeb);
    }
    //------call restaurant------///
    public void callHamburg(View view){
        phoneNum("tel:1-700-507-073");
    }
    public void phoneNum(String num){
        Uri uri = Uri.parse(num);
        Intent callIntent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(callIntent);
    }
    //--------open menu--------\\
    public void hamburgMenu(View view){
        openMenu("https://hamburg.co.il/rehovot_menu/");
    }
    public void openMenu(String url){
        Uri uri = Uri.parse(url);
        Intent openMenu = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(openMenu);
    }
}