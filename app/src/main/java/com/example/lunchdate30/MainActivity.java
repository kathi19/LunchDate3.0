package com.example.lunchdate30;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onClick(View view) throws Exception {
        System.out.println("juhu");

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    try {
                        URL url = new URL ("http://192.168.189.156:5000");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.connect();
                        InputStream stream = connection.getInputStream();
                        //BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                        // StringBuffer buffer = new StringBuffer();
                        System.out.println("connection established!");
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        return false;
    }
}
