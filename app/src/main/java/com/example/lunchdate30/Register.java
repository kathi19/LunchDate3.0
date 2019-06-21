package com.example.lunchdate30;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void onClickRegister(View view) throws Exception {
        String[] strings = new String[12];
        strings[0] = ((EditText) findViewById(R.id.editText)).getText().toString();
        strings[1] = ((EditText) findViewById(R.id.editText2)).getText().toString();
        strings[2] = ((EditText) findViewById(R.id.name2)).getText().toString();
        strings[3] = ((EditText) findViewById(R.id.alter2)).getText().toString();
        strings[4] = ((EditText) findViewById(R.id.studiengang2)).getText().toString();
        strings[5] = ((EditText) findViewById(R.id.beginn2)).getText().toString();
        strings[6] = ((CheckBox) findViewById(R.id.sport2)).isChecked() ? "true" : "false";
        strings[7] = ((CheckBox) findViewById(R.id.lesen2)).isChecked() ? "true" : "false";
        strings[8] = ((CheckBox) findViewById(R.id.reisen2)).isChecked() ? "true" : "false";
        strings[9] = ((CheckBox) findViewById(R.id.freunde)).isChecked() ? "true" : "false";
        strings[10] = ((CheckBox) findViewById(R.id.spielen2)).isChecked() ? "true" : "false";
        strings[11] = ((CheckBox) findViewById(R.id.feiern)).isChecked() ? "true" : "false";

        for (String string : strings) {
            if (string.equals("")) {
                Toast toast = new Toast(this);
                toast.makeText(this,"Fehlender Eintrag", (short)1);
                return;
            }
        }

        final String[] STRINGS = strings;

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("start");
                try {
                    URL url = new URL(Info.URL + "/create_user");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setDoInput(true);
                    connection.setDoOutput(true);
                    connection.setRequestProperty("Content-Type", "application/json");
                    OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());

                    String output = "{\n";
                    int i = 0;
                    for(String string: STRINGS) {
                        output += "\"" + i++ + "\": \"" + string + "\",\n";
                    }
                    output = output.substring(0, output.length() - 2);
                    output += "}";

                    System.out.println(output);

                    out.write(output);

                    out.flush();
                    out.close();
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()) );

                    for ( String line; (line = reader.readLine()) != null; )
                    {
                        System.out.println( line );
                    }

                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
