package com.example.lunchdate30;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SmartKantine extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_kantine);
        String[] data = getIntent().getStringArrayExtra("DATA");


        TextView text = (TextView) findViewById(R.id.belegung);
        text.setText(data[1]);
        TextView  text2 = (TextView ) findViewById(R.id.teller);
        text2.setText(data[2]);
        TextView text3 = (TextView) findViewById(R.id.mitarbeiter);
        text3.setText(data[3]);
        if(data[4].equals(" 1")) {
            TextView text4 = (TextView) findViewById(R.id.terasse);
            text4.setText("Ja!");
        } else {
            TextView text4 = (TextView) findViewById(R.id.terasse);
            text4.setText("Nein!");
        }

        TextView text4 = (TextView) findViewById(R.id.temp);
        text4.setText(data[0]);
    }
}
