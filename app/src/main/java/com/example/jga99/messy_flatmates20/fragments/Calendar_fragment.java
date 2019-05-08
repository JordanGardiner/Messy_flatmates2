package com.example.jga99.messy_flatmates20.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jga99.messy_flatmates20.db.db;
import com.example.jga99.messy_flatmates20.MainActivity;
import com.example.jga99.messy_flatmates20.R;

import java.sql.Connection;

public class Calendar_fragment extends Fragment {
    View myView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.calendar, container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Connection connect = bundle.getParcelable("connect");
            db database_class = bundle.getParcelable("db");

        TextView all_usernames = (TextView) myView.findViewById(R.id.all_usernames_textview);

        String username = database_class.get_All_usernames(connect);

        all_usernames.setText(username);

        }
        return myView;
    }
}
