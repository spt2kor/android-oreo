package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text;

    public void onConvert(View view){
        String dollerStr = text.getText().toString();
        Log.i("currencyValue" , "current currency value " + dollerStr);
        double doller = 0.0;
        doller =  Double.parseDouble (dollerStr);

        double inr = doller * 75;
        //text.setText(Double.toString(inr));
        Toast.makeText(this, " value in INR = " + Double.toString(inr), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.value);
    }
}
