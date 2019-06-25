package com.example.lunchdate30;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

import static android.icu.text.DateFormat.NONE;

public class HomeFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        String[] getArg = null;
        if (!getArguments().getStringArray("DATA").equals(NONE) ) {
            getArg = getArguments().getStringArray("DATA");
        } else {
            URL url = null;
            try {
                url = new URL(Info.URL + "/get_user" + "?email=" + "katharina@minninger.de");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            new GetUserTask(getActivity()).execute(url);
        }

        TextView text = (TextView) view.findViewById(R.id.name);
        text.setText(getArg[1]);
        TextView text2 = (TextView) view.findViewById(R.id.alter);
        text2.setText(getArg[2]);
        TextView text3 = (TextView) view.findViewById(R.id.studiengang);
        text3.setText(getArg[3]);
        TextView text4 = (TextView) view.findViewById(R.id.beginn);
        text4.setText(getArg[4]);

        System.out.println("sports: " + getArg[5]);

        if(getArg[5].equals(" 1")) {
            CheckBox checkBox1 = (CheckBox) view.findViewById(R.id.sport);
            checkBox1.setChecked(true);
        }
        if(getArg[6].equals(" 1")) {
            CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.lesen);
            checkBox2.setChecked(true);
        }
        if(getArg[7].equals(" 1")) {
            CheckBox checkBox3 = (CheckBox) view.findViewById(R.id.reisen);
            checkBox3.setChecked(true);
        }
        if(getArg[8].equals(" 1")) {
            CheckBox checkBox4 = (CheckBox) view.findViewById(R.id.Freunde);
            checkBox4.setChecked(true);
        }
        if(getArg[9].equals(" 1")) {
            CheckBox checkBox5 = (CheckBox) view.findViewById(R.id.spielen);
            checkBox5.setChecked(true);
        }
        if(getArg[10].equals(" 1")) {
            CheckBox checkBox6 = (CheckBox) view.findViewById(R.id.Feiern);
            checkBox6.setChecked(true);
        }


        Toast.makeText( getActivity(), "Welcome" + getArg[1] + "! Let's Date!", Toast.LENGTH_LONG ).show();

        return view;

    }

}
