package com.example.android.taller3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        txtram= findViewById(R.id.txtram);
        txtmarca=findViewById(R.id.txtmarca);
        txtcolor = findViewById(R.id.txtcolor);
        txttipo = findViewById(R.id.txttipo);
        txtso=findViewById(R.id.txtso);
        fot= findViewById(R.id.foto);

        i = getIntent();

        bundle = i.getBundleExtra("datos");
        ram= bundle.getString("ram");
        id=bundle.getString("id");
        marca= bundle.getString("marca");
        color=bundle.getString("color");
        tipo=bundle.getString("tipo");
        so=bundle.getString("so");
        foto = bundle.getInt("foto");

        fot.setImageResource(foto);
        txtcolor.setText(color);
        txtram.setText(ram);
        txtmarca.setText(marca);
        txttipo.setText(tipo);
        txtso.setText(so);

    }
    public void eliminar(View v){

    }
}
