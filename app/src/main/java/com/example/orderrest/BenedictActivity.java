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

public class BenedictActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benedict);
        getIncomingIntent();


        Button navButton = findViewById(R.id.nav_benedict);
        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BenedictActivity.this,MapBenedictActivity.class);
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
    public void benedictWeb(View view){
        openUrl("https://www.benedict.co.il/");
    }
    public void openUrl(String url){
        Uri uri = Uri.parse(url);
        Intent benedictWeb = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(benedictWeb);
    }
    //------call restaurant------///
    public void callBenedict(View view){
        phoneNum("tel:03-550-7772");
    }
    public void phoneNum(String num){
        Uri uri = Uri.parse(num);
        Intent callIntent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(callIntent);
    }

    //--------open menu--------\\
    public void benedictMenu(View view){
        openMenu("https://www.benedict.co.il/%D7%94%D7%AA%D7%A4%D7%A8%D7%99%D7%98/");
    }
    public void openMenu(String url){
        Uri uri = Uri.parse(url);
        Intent openMenu = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(openMenu);
    }
}