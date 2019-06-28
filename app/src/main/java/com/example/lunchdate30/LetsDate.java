package com.example.lunchdate30;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class LetsDate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_date);
        String[] getArg = getIntent().getStringArrayExtra("DATA");


        EditText text = (EditText) findViewById(R.id.name2);
        text.setText(getArg[1]);
        EditText  text2 = (EditText ) findViewById(R.id.alter2);
        text2.setText(getArg[2]);
        EditText text3 = (EditText) findViewById(R.id.studiengang2);
        text3.setText(getArg[3]);
        EditText text4 = (EditText) findViewById(R.id.beginn2);
        text4.setText(getArg[4]);

        System.out.println("sports: " + getArg[5]);

        if(getArg[5].equals(" 1")|| getArg[5].equals(" true")) {
            CheckBox checkBox1 = (CheckBox) findViewById(R.id.sport);
            checkBox1.setChecked(true);
        }
        if(getArg[6].equals(" 1")|| getArg[6].equals(" true")) {
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.lesen);
            checkBox2.setChecked(true);
        }
        if(getArg[7].equals(" 1")|| getArg[7].equals(" true")) {
            CheckBox checkBox3 = (CheckBox) findViewById(R.id.reisen);
            checkBox3.setChecked(true);
        }
        if(getArg[8].equals(" 1")|| getArg[8].equals(" true")) {
            CheckBox checkBox4 = (CheckBox) findViewById(R.id.Freunde);
            checkBox4.setChecked(true);
        }
        if(getArg[9].equals(" 1")|| getArg[9].equals(" true")) {
            CheckBox checkBox5 = (CheckBox) findViewById(R.id.spielen);
            checkBox5.setChecked(true);
        }
        if(getArg[10].equals(" 1")|| getArg[10].equals(" true")) {
            CheckBox checkBox6 = (CheckBox) findViewById(R.id.Feiern);
            checkBox6.setChecked(true);
        }
    }
}
