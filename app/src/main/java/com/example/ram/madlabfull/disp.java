package com.example.ram.madlabfull;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class disp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp);
        Intent in = getIntent();
        Bundle b = in.getExtras();
        ((TextView) findViewById(R.id.tv)).setText(b.getString("text"));
    }
}
