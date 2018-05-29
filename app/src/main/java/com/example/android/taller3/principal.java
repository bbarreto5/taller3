package com.example.android.taller3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Principal;
import java.util.ArrayList;

public class principal extends AppCompatActivity implements AdaptadorPc.OnPcClickListener {
    private RecyclerView lstOpciones;
    private Intent i;
    private ArrayList<pc> pcs;
    private AdaptadorPc adapter;
    private LinearLayoutManager llm;
    private DatabaseReference databaseReference;
    private String bd = "pc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstOpciones = findViewById(R.id.lstOpciones);
        pcs = new ArrayList<>();

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new AdaptadorPc(pcs,this);

        lstOpciones.setLayoutManager(llm);
        lstOpciones.setAdapter(adapter);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(bd).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pcs.clear();
                if(dataSnapshot.exists()){
                    for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                        pc p = snapshot.getValue(pc.class);
                        pcs.add(p);
                    }
                }
                adapter.notifyDataSetChanged();
                Datos.setPcs(pcs);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void ircrear(View v){
        Intent i = new Intent(principal.this,crear.class);
        startActivity(i);
    }

    @Override
    public void onPcClick(pc p) {
        Intent i = new Intent(principal.this,ver.class);
        Bundle b = new Bundle();
        b.putString("id",p.getId());
        b.putString("marca",p.getMarca());
        b.putString("ram",p.getRam());
        b.putString("color",p.getColor());
        b.putString("tipo",p.getTipo());
        b.putString("so",p.getSo());
        b.putInt("foto",p.getFoto());

        i.putExtra("datos",b);
        startActivity(i);
    }
}
