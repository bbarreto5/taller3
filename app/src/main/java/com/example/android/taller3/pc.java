package com.example.android.taller3;

/**
 * Created by android on 28/05/2018.
 */

public class pc {
    private String id;
    private int foto;
    private String marca;
    private String ram;
    private String color;
    private String tipo;
    private String so;

    public pc() {
    }

    public pc(String id, int foto, String marca, String ram, String color, String tipo, String so) {
        this.id = id;
        this.foto = foto;
        this.marca = marca;
        this.ram = ram;
        this.color = color;
        this.tipo = tipo;
        this.so = so;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }
    public void guardar(){
        Datos.guardar(this);
    }

    public void eliminar(){
        Datos.eliminar(this);
    }
}
