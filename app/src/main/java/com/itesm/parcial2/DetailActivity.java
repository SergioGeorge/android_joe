package com.itesm.parcial2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView v = findViewById(R.id.tv_detail);

        Intent t = getIntent();
        String param = t.getStringExtra("var_1");
        Log.d("DetailActivity", "" + param);

        v.setText(param);
    }
}
