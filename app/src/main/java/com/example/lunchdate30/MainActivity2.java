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

public class MainActivity2 extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView navView = findViewById(R.id.nav_view);

        navView.setOnNavigationItemSelectedListener(this);
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction transaction= fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, new HomeFragment()).commit();
        loadFragment(new HomeFragment());
    }

    private boolean loadFragment(Fragment fragment)
    {
        if(fragment!=null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container,fragment)
                    .commit();
            return true;
        } return false;
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
    public void goToKantine(View view) {

        Intent m = new Intent(MainActivity2.this, SmartKantine.class);

        startActivity(m);
    }

    public void goToDate(View view) {

        Intent b = new Intent(MainActivity2.this, LetsDate.class);

        startActivity(b);
    }
}
