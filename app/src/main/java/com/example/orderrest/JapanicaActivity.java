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

public class JapanicaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japanica);
        getIncomingIntent();

        Button navButton = findViewById(R.id.nav_japanica);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JapanicaActivity.this,MapJapanicaActivity.class);
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
    public void japanicaWeb(View view){
        openUrl("https://www.japanika.net/");
    }
    public void openUrl(String url){
        Uri uri = Uri.parse(url);
        Intent japanicaWeb = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(japanicaWeb);
    }
    //------call restaurant------///
    public void callJapanica(View view){
        phoneNum("tel:03-723-6100");
    }
    public void phoneNum(String num){
        Uri uri = Uri.parse(num);
        Intent callIntent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(callIntent);
    }
    //--------open menu--------\\
    public void japanicaMenu(View view){
        openMenu("https://www.japanika.net/menu/");
    }
    public void openMenu(String url){
        Uri uri = Uri.parse(url);
        Intent japanicaMenu = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(japanicaMenu);
    }

}