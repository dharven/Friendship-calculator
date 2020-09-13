package com.example.friendshipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String s;
    String d;
    EditText et1, et2;
    TextView tv;
    Button btn;
    boolean digit;
    String v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        tv = (TextView) findViewById(R.id.tv);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowResult();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void ShowResult() {
        s = et1.getText().toString().toLowerCase();
        d = et2.getText().toString().toLowerCase();
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder d1 = new StringBuilder(d);
        boolean digit1 = false;
        if (s1.length() == 0 || d1.length() == 0) {
            Toast.makeText(getApplicationContext(), "Enter Name(s)", Toast.LENGTH_LONG).show();
        } else {
            for (char c : s.toCharArray()) {
                if (digit = Character.isDigit(c)) {
                    Toast.makeText(getApplicationContext(), "INVALID INPUT", Toast.LENGTH_LONG).show();
                    tv.setText("");
                }
            }
            for (char c : d.toCharArray()) {
                if (digit1 = Character.isDigit(c)) {
                    Toast.makeText(getApplicationContext(), "INVALID INPUT", Toast.LENGTH_LONG).show();
                    tv.setText("");
                }

            }
        }
        if (!digit && !digit1) {
            if (s1.length() >= d1.length()) {
                for (int x = 0; x < s1.length(); x++) {
                    for (int z = 0; z < d1.length(); z++) {
                        if (s1.charAt(x) == d1.charAt(z)) {
                            s1.deleteCharAt(x);
                            d1.deleteCharAt(z);
                        }
                    }
                }
            } else {
                if (d1.length() >= s1.length()) {
                    for (int x = 0; x < d1.length(); x++) {
                        for (int z = 0; z < s1.length(); z++) {
                            if (s1.charAt(z) == d1.charAt(x)) {
                                s1.deleteCharAt(z);
                                d1.deleteCharAt(x);
                            }
                        }
                    }
                }
            }
            int level = (s1.length() * 10) + (d1.length() * 10);
                if(level > 100) {
                    Toast.makeText(getApplicationContext(), "Your friendship stays forever", Toast.LENGTH_LONG).show();
                    tv.setText("");
                }
                else
                {
                String level10 = String.valueOf(level);
                tv.setText(level10);
            }
        }
    }
}

