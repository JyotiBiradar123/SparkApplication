package com.example.sparkapplication.sparkandroidapplication.Accounts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sparkapplication.R;
import com.example.sparkapplication.sparkandroidapplication.LandingPage.LandingActivity;

public class LoginActivity extends AppCompatActivity {
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnlogin=findViewById(R.id.btnlogin);
        clickOnLoginBtn();
    }
    // login functionality
    void clickOnLoginBtn(){
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, LandingActivity.class);
                startActivity(i);
            }
        });
    }
}