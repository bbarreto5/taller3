package com.example.android.taller3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ver extends AppCompatActivity {
    private TextView txtram;
    private TextView txtmarca;
    private TextView txtcolor;
    private TextView txttipo;
    private TextView txtso;
    private ImageView fot;
    private String id,ram,marca,color,tipo,so;
    private int foto,sexo;
    private Intent i;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);
    }
}
