package com.example.orderrest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewRestActivity extends AppCompatActivity {

    private TextView mTextViewTo ;
    private EditText mEditTextRestName;
    private EditText mEditTextAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_rest);


        mTextViewTo = findViewById(R.id.orderest_support);
        mEditTextRestName = findViewById(R.id.rest_name);
        mEditTextAddress = findViewById(R.id.info);



        Button sendButton = findViewById(R.id.send_btn);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
    }

    private void sendMail() {
        mTextViewTo.setText("tzezar32@gmail.com");
        String ordeRestSupport = mTextViewTo.getText().toString();
        String[] orderestMail = ordeRestSupport.split(",");

        String nameOfRest = mEditTextRestName.getText().toString();
        String infoOfRest = mEditTextAddress.getText().toString();


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,orderestMail);
        intent.putExtra(Intent.EXTRA_SUBJECT,nameOfRest);
        intent.putExtra(Intent.EXTRA_TEXT,infoOfRest);


        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"בחר אפליקציית מייל"));
    }
}