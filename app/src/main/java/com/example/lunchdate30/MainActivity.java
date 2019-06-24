package com.example.lunchdate30;

import android.content.Intent;
import android.os.Looper;
import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler handler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message inputMessage) {
                // Gets the image task from the incoming Message object.

            }

        };
        }

    public boolean onClick(View view) throws Exception {

        String mail = ((EditText) findViewById(R.id.editText)).getText().toString();
        System.out.println( "email" + mail);
        if (mail.equals("")) {
            Toast toast = new Toast(this);
            toast.makeText(this,"Fehlender Eintrag", (short)1);
        }

        URL url = new URL(Info.URL + "/get_user" + "?email=" + mail);
        new GetUserTask(getApplicationContext()).execute(url);

       /* final String MAIL = mail;
        final AtomicBoolean userFound = new AtomicBoolean(false);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start");
                try {
                    URL url = new URL(Info.URL + "/get_user" + "?email=" + MAIL);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setDoInput(true);


                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()) );

                    userFound.getAndSet(true);
                    for ( String line; (line = reader.readLine()) != null; )
                    {
                        System.out.println( line );
                        if (line.equals("404")) {
                            userFound.getAndSet(false);
                        }
                        String temp = line.replace("\"", "");
                        String[] values = temp.substring(1,temp.length()-1).split(",");
                        for (String string :  values) {
                            System.out.println("ID: " + string);
                        }

                    }

                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();*/


        return false;
    }


    public void onClickNext(View view) {
        Intent i = new Intent(MainActivity.this, MainActivity2.class);

        startActivity(i);

    }
    public void onClickRegister(View view) {
        Intent i = new Intent(MainActivity.this, Register.class);

        startActivity(i);
    }

}
