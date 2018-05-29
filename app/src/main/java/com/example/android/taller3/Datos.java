package com.example.android.taller3;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by android on 28/05/2018.
 */

public class Datos {
    private static String db = "pc";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private static ArrayList<pc> pcs  = new ArrayList();
    public static void guardar(pc pc){
        databaseReference.child(db).child(pc.getId()).setValue(pc);
    }
    public static void eliminar(pc pc){
        databaseReference.child(db).child(pc.getId()).removeValue();
    }
    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return  fotos.get(fotoSeleccionada);
    }

    public static String getId(){
        return databaseReference.push().getKey();
    }

    public static void setPcs(ArrayList<pc> pcs){
        Datos.pcs = pcs;
    }

    public static void modificarpcs(pc pc){
        databaseReference.child(db).child(pc.getId()).setValue(pc);
    }
    public static ArrayList<pc> obtener(){
        return pcs;
    }
}
