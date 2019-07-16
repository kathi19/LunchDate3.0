package com.example.lunchdate30;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

public class MainActivity2 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(this);
        String[] data = getIntent().getStringArrayExtra("DATA");
       /* FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, new HomeFragment()).commit();*/


        loadFragment(new HomeFragment(), ((MyApplication) this.getApplication()).getUserData());
            Toast toast = new Toast(this);
            toast.makeText(this,"Welcome " + data[1] + "! Let's Date!", (short)1);

    }

    private boolean loadFragment(Fragment fragment, String [] data)
    {
       /* if(fragment!=null && data == null)
        {

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        } else {*/
            System.out.println("HELLOOOOOOOOOOOOOOOOOOOO");
            System.out.println(data[1]);
            Bundle datap = new Bundle();
            datap.putStringArray("DATA", data);
            fragment.setArguments(datap);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
           /* Fragment frag = getFragmentManager().findFragmentById(R.id.fragment);
            ((TextView) frag.getView().findViewById(R.id.textView)).setText(s);*/
            /*TextView t =  findViewById(R.id.name);
            t.setText(data[1]);
            TextView t2 = findViewById(R.id.alter);
            t.setText(data[2]);
            TextView t3 =  findViewById(R.id.studiengang);
            t.setText(data[3]);
           /* TextView t4 =  fragment.getView().findViewById(R.id.beginn);
            t.setText(data[4]);*/

        /*}*/
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        /*Fragment fragment=null;*/
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        switch(menuItem.getItemId()){
            case R.id.navigation_home:
                transaction.replace(R.id.fragment_container, new HomeFragment()).commit();
                return true;


            case R.id.navigation_dashboard:
               /* fragment= new DashboardFragment();*/
                transaction.replace(R.id.fragment_container, new DashboardFragment()).commit();
                return true;

            case R.id.navigation_notifications:
               /* fragment= new NotificationFragment();*/
                transaction.replace(R.id.fragment_container, new NotificationFragment()).commit();
                return true;
        }
       /* return loadFragment(fragment);*/
        return false;
    }
    public void jumpToInfos(View view) {

        Intent i = new Intent(MainActivity2.this, AllgemeineInfos.class);

        startActivity(i);

    }

    public void goToMenu(View view) {

        Intent j = new Intent(MainActivity2.this, MenuPlan.class);

        startActivity(j);
    }
    public void goToKantine(View view) throws Exception{

        URL url = new URL(Info.URL + "/get_kantine");
        new GetKantinenInfo(getApplicationContext()).execute(url);

        /*Intent m = new Intent(MainActivity2.this, SmartKantine.class);

        startActivity(m);*/
    }

    public void goToDate(View view) throws Exception {

        URL url = new URL(Info.URL_MATCHING + "/match" + "?user=" + (((MyApplication) this.getApplication()).getUserData())[0]);
        new GetMatch(getApplicationContext()).execute(url);

       /* Intent b = new Intent(MainActivity2.this, LetsDate.class);

        startActivity(b); */
    }
}
