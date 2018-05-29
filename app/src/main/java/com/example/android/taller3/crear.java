package com.example.android.taller3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class crear extends AppCompatActivity {
    private EditText ram;
    private Spinner marca,color,tipo,so;
    private ArrayAdapter<String> adapter;
    private String opc[];
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        ram = findViewById(R.id.lblRam);
        marca = findViewById(R.id.SpinnerMarca);
        color = findViewById(R.id.SpinnerColor);
        tipo = findViewById(R.id.SpinnerTipo);
        so = findViewById(R.id.SpinnerSO);
    }

    public void agregar(View v) {
        String n1 = marca.getSelectedItem().toString();
        String n2 = ram.getText().toString();
        String n3 = color.getSelectedItem().toString();
        String n4 = tipo.getSelectedItem().toString();
        String n5 = so.getSelectedItem().toString();
        pc p = new pc(Datos.getId(), R.drawable.u_10167312, n1, n2, n3, n4, n5);
        p.guardar();
        Toast.makeText(this, R.string.adicionado, Toast.LENGTH_LONG);
    }
    public void limpiar(View v){
        ram.setText("");
    }
}
