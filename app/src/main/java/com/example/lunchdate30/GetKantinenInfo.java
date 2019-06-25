package com.example.lunchdate30;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetKantinenInfo extends AsyncTask<URL, Void, String[]> {

    Context ctx;

   public GetKantinenInfo(Context context) {
    ctx = context;
   }

    @Override
    protected String[] doInBackground(URL... urls) {
        String[] values = null;
        try {

            HttpURLConnection connection = (HttpURLConnection) urls[0].openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);


            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()) );

            for ( String line; (line = reader.readLine()) != null; )
            {
                System.out.println( line );
                if (line.equals("404")) {
                    return null;
                }
                String temp = line.replace("\"", "");
                values = temp.substring(1,temp.length()-1).split(",");
                for (String string :  values) {
                    System.out.println("KANTINENINFO: " + string);
                }

            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return values;
    }
    @Override
    protected void onPostExecute(String[] result) {
        super.onPostExecute(result);
        Intent intent = new Intent(ctx.getApplicationContext(), SmartKantine.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("DATA", result);
        ctx.startActivity(intent);
    }

}
