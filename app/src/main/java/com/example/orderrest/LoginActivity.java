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
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.+[a-zA-Z]+";

    EditText TextUserEmail;
    EditText TextPassword;
    Button LoginButton;
    TextView RegisterText;
    FirebaseAuth firebaseAuthSignIn;
    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuthSignIn = FirebaseAuth.getInstance();
        TextUserEmail = findViewById(R.id.UserEmailText);
        TextPassword = findViewById(R.id.UserPasswordText);
        LoginButton = findViewById(R.id.SighUpButton);
        RegisterText = findViewById(R.id.Login);
        final LoadingDialog loadingDialog = new LoadingDialog(LoginActivity.this);
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if(firebaseUser == null){
                    Toast.makeText(LoginActivity.this,"אינך מחובר",Toast.LENGTH_SHORT).show();
                }

            }
        };

        RegisterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(registerIntent);
            }
        });

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = TextUserEmail.getText().toString();
                String pwd = TextPassword.getText().toString();

                if(email.isEmpty() && pwd.isEmpty() ){
                    Toast.makeText(LoginActivity.this,"השדות ריקים",Toast.LENGTH_SHORT).show();
                }
                else if(email.isEmpty()){
                    TextUserEmail.setError("הכנס אימייל");
                    TextUserEmail.requestFocus();
                }
                else if(!(email.matches(emailPattern))) {
                    TextUserEmail.setError("כתובת לא נכונה");
                    TextUserEmail.requestFocus();
                }
                else if(pwd.isEmpty()){
                    TextPassword.setError("הכנס סיסמא");
                    TextPassword.requestFocus();
                }
                else if(!(email.isEmpty() && pwd.isEmpty())){
                    firebaseAuthSignIn.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(LoginActivity.this,"החיבור נכשל, נסה שוב",Toast.LENGTH_SHORT).show();

                            }
                            else {
                                loadingDialog.startLoadingAnimation();
                                Intent goHome = new Intent(LoginActivity.this,HomeActivity.class);
                                startActivity(goHome);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(LoginActivity.this,"שגיאה",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAuthSignIn.addAuthStateListener(authStateListener);
    }
}
