package com.example.imageswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewDebug;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int i = 0;
    ArrayList<Integer> arrli;
    TextView textView;

    public void onPrev(View view){
        Log.i("OnPrevClick","Prev Button is clicked " + Integer.toString(i));
        if(i == 0)
            i = 4;
        else
            i = i-1;
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(arrli.get(i));
        textView.setText( " " + Integer.toString(i+1) + " / 5 " );
    }

    public void onNext(View view){

        Log.i("onNextClick","Next Button is clicked " + Integer.toString(i));
        ImageView image = (ImageView) findViewById(R.id.imageView);

        i = (i+1) % 5;

        image.setImageResource(arrli.get(i));
        textView.setText( " " + Integer.toString(i+1) + " / 5 " );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = 0;
        int n = 5;

        //declaring ArrayList with initial size n
        arrli = new ArrayList<Integer>(n);
        arrli.add(R.drawable.family);
        arrli.add(R.drawable.aishu);
        arrli.add(R.drawable.mishti);
        arrli.add(R.drawable.pari);
        arrli.add(R.drawable.pihu);

        textView = (TextView) findViewById(R.id.progressBar);
        textView.setText( " 1 / 5 ");
    }
}
