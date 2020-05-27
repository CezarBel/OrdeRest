package com.example.orderrest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.+[a-zA-Z]+";

    EditText TextUserEmail;
    EditText TextPassword;
    EditText TextUserPhoneNum;
    EditText TextCnfPassword;
    Button SighUpButton;
    TextView LoginText;
    FirebaseAuth firebaseAuthSighUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firebaseAuthSighUp = FirebaseAuth.getInstance();
        TextUserEmail = findViewById(R.id.UserEmailText);
        TextUserPhoneNum = findViewById(R.id.UserPhoneNumText);
        TextPassword = findViewById(R.id.UserPasswordText);
        TextCnfPassword = findViewById(R.id.UserPasswordCnfText);
        SighUpButton = findViewById(R.id.SighUpButton);
        LoginText = findViewById(R.id.Login);

        LoginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(LoginIntent);
            }
        });

        SighUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = TextUserEmail.getText().toString();
                String pwd = TextPassword.getText().toString();
                String userPhone = TextUserPhoneNum.getText().toString();
                String cnfPwd = TextCnfPassword.getText().toString();

                 if(email.isEmpty() && pwd.isEmpty() && cnfPwd.isEmpty() && userPhone.isEmpty()){
                    Toast.makeText(RegisterActivity.this,"השדות ריקים",Toast.LENGTH_SHORT).show();
                }
                else if(email.isEmpty()){
                    TextUserEmail.setError("הכנס אימייל");
                    TextUserEmail.requestFocus();
                }
                else if(!(email.matches(emailPattern))){
                    TextUserEmail.setError("כתובת לא נכונה");
                    TextUserEmail.requestFocus();
                }
                else if(userPhone.isEmpty()){
                    TextUserPhoneNum.setError("הכנס מספר טלפון");
                    TextUserPhoneNum.requestFocus();
                }
                 else if(userPhone.length()<10){
                     TextUserPhoneNum.setError("מספר לא תקין");
                     TextUserPhoneNum.requestFocus();
                 }

                else if(pwd.isEmpty()){
                    TextPassword.setError("הכנס סיסמא");
                    TextPassword.requestFocus();
                }
                else if(pwd.length()<8){
                     TextPassword.setError("סיסמא חייבת להיות בעלת 8 תווים לפחות");
                     TextPassword.requestFocus();
                 }
                else if(cnfPwd.isEmpty()){
                    TextCnfPassword.setError("בבקשה אמת את סיסמתך");
                    TextCnfPassword.requestFocus();
                }

                else if(!pwd.equals(cnfPwd)){
                    TextCnfPassword.setError("הסיסמאות אינן זהות");
                    TextCnfPassword.requestFocus();
                }

                else {
                    firebaseAuthSighUp.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this,"ההרשמה נכשלה, נסה שוב",Toast.LENGTH_SHORT).show();

                            }
                            else {
                                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                            }
                        }
                    });
                }
//                else {
//                    Toast.makeText(RegisterActivity.this,"שגיאה",Toast.LENGTH_SHORT).show();
//
//                }
            }
        });


    }
}
