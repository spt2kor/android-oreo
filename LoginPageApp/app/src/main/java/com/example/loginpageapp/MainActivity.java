package com.example.loginpageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onLogin(View view){

        EditText userID = (EditText) findViewById(R.id.userID);
        EditText passwd = (EditText) findViewById(R.id.passwd) ;

        Log.i("loginInfo" , "user Id = "+ userID.getText().toString() + ", paswd = " + passwd.getText().toString());
        Log.i( "info", "Login Button is clicked");

        Toast.makeText(this, "welcome back " + userID.getText().toString(), Toast.LENGTH_LONG).show();
        Toast.makeText(this, "your password is " + passwd.getText().toString(), Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
