package com.example.currencyconvertercomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerlist1;
    EditText curr1;
    Spinner spinnerList2;
    EditText curr2;
    ArrayList<Double> inrToOtherCurr;

    public void onConvert(View view){
        Log.i("onConvert" ,"Convert Button clicked");

        String value1Str = curr1.getText().toString();
        double value1 = Double.parseDouble(value1Str);
        Log.i("currency1" ,"currency 1 value = " + value1Str);

        int index1 = spinnerlist1.getSelectedItemPosition();
        String currency1Str = spinnerlist1.getSelectedItem().toString();
        Log.i("currency1","Currency 1 selected = " + currency1Str);
        Log.i("currency1","Currency 1 index = " + index1);

        int index2 = spinnerList2.getSelectedItemPosition();
        String currency2Str = spinnerList2.getSelectedItem().toString();
        Log.i("currency2","Currency 2 selected = " + currency2Str);
        Log.i("currency2","Currency 2 index = " + index2);

        double value2 = 0.0;
        if(index1 == 0)
            value1 = value1 * 1;
        else
            value1 = value1 * (1/inrToOtherCurr.get(index1));
        value2 = value1 * inrToOtherCurr.get(index2);

        curr2.setText(Double.toString(value2));
        Log.i("currency2" , "Currency 2 value = " + Double.toString(value2));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerlist1 = (Spinner) findViewById(R.id.currencyList1);
        curr1 = (EditText)findViewById(R.id.currency1);
        spinnerList2 = (Spinner)findViewById(R.id.currencyList2);
        curr2 =  (EditText) findViewById(R.id.currency2);

        ArrayList<String> arrList1 = new ArrayList<String>();
        arrList1.add("INR");
        arrList1.add("Dollar");
        arrList1.add("Yen");
        arrList1.add("Pound");

        ArrayAdapter<String> dataAdaptor = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, arrList1);
        dataAdaptor.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerlist1.setAdapter(dataAdaptor);

        inrToOtherCurr = new ArrayList<Double>();
        inrToOtherCurr.add(1.0);
        inrToOtherCurr.add(0.013);
        inrToOtherCurr.add(1.41);
        inrToOtherCurr.add(0.011);

        spinnerList2.setAdapter(dataAdaptor);
    }
}
