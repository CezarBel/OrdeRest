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

public class SunsetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunset);
        getIncomingIntent();

        Button navButton = findViewById(R.id.nav_sunset);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SunsetActivity.this,MapSunsetActivity.class);
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
    public void sunsetWeb(View view){
        openUrl("http://sunsetblvd.co.il/");
    }
    public void openUrl(String url){
        Uri uri = Uri.parse(url);
        Intent sunsetWeb = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(sunsetWeb);
    }
    //------call restaurant------///
    public void callSunset(View view){
        phoneNum("tel:08-945-0500");
    }
    public void phoneNum(String num){
        Uri uri = Uri.parse(num);
        Intent callIntent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(callIntent);
    }
    //--------open menu--------\\
    public void sunsetMenu(View view){
        openMenu("http://sunsetblvd.co.il/home/%D7%9C%D7%90%D7%9B%D7%95%D7%9C/%D7%AA%D7%A4%D7%A8%D7%99%D7%98-%D7%A2%D7%91%D7%A8%D7%99%D7%AA/");
    }
    public void openMenu(String url){
        Uri uri = Uri.parse(url);
        Intent openMenu = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(openMenu);
    }

}