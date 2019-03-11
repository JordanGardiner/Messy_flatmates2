package com.example.jga99.messy_flatmates20.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jga99.messy_flatmates20.MainActivity;
import com.example.jga99.messy_flatmates20.R;

public class Settings_fragment extends Fragment {
    View myView;
//    Dialog myDialog;
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.settings, container, false);
   //     myDialog = new Dialog(getContext());

        TextView test_string = (TextView) myView.findViewById(R.id.test_string_textView);
        test_string.setText("hello world!!");

        Button dev_mode = myView.findViewById(R.id.dev_login_btn);
        dev_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("login");
                builder.setMessage("Insert password to gain dev access");
                builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.setCancelable(true);

                View popup;
                popup = inflater.inflate(R.layout.dev_login_popup, null);

                builder.setView(popup);
                builder.show();
                /**

               TextView txtClose;
               Button closeBtn;
               myDialog.setContentView(R.layout.dev_login_popup);
               closeBtn = (Button) myView.findViewById(R.id.dev_popup_close_btn);
               closeBtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       myDialog.dismiss();
                   }
               });
               myDialog.show();
                 **/
            }
        });

        return myView;
    }
}
