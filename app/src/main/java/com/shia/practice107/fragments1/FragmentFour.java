package com.shia.practice107.fragments1;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.shia.practice107.R;

public class FragmentFour extends Fragment {

    LinearLayout linearLayout;
    TextInputLayout nameLayout, passLayout;
    EditText nameEdittext, passEdittext;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_four, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        linearLayout = view.findViewById(R.id.linearLayout);
        linearLayout.setOnClickListener(null);

        nameLayout = view.findViewById(R.id.nameLayout);
        nameEdittext = view.findViewById(R.id.nameEdittext);

        passLayout = view.findViewById(R.id.passLayout);
        passEdittext = view.findViewById(R.id.passEdittext);

        //name
        nameEdittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (nameEdittext.getText().toString().isEmpty()) {
                    nameLayout.setError("Enter Username");
                } else {
                    nameLayout.setErrorEnabled(false);
                }
            }
        });

        nameEdittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (nameEdittext.getText().toString().isEmpty()) {
                    nameLayout.setError("Enter Username");
                } else {
                    nameLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //password
        passEdittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (passEdittext.getText().toString().isEmpty()) {
                    passLayout.setError("Enter Password");
                } else {
                    passLayout.setErrorEnabled(false);
                }
            }
        });

        passEdittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (passEdittext.getText().toString().isEmpty()) {
                    passLayout.setError("Enter Password");
                } else {
                    passLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        button = view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runAlert();
            }
        });
    }

    private void runAlert() {
        new AlertDialog.Builder(getContext())
                .setTitle("REGISTRATION")
                .setMessage("your information registered")
                .setCancelable(false)
                .setIcon(R.drawable.profile4)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Done", Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();
    }
}