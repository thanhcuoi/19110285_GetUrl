package com.example.a19110285_geturl;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {

    EditText textinput;
    Button btenter;
    TextView textsource;
    TextView textview;
    ScrollView scr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textinput = (EditText) findViewById(R.id.textinput);
        btenter = (Button) findViewById(R.id.btenter);
        textview = (TextView) findViewById(R.id.textView);
        textsource = (TextView) findViewById(R.id.textsource);
        btenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ion.with(getApplicationContext())
                        .load(textview.getText().toString().trim() + textinput.getText().toString().trim())
                        .asString()
                        .setCallback(new FutureCallback<String>() {
                            @Override
                            public void onCompleted(Exception e, String result) {
                                textsource.setText(result);
                            }
                        });
            }
        });
    }
}