package com.upiiz.examen01.models;

public class Usuario {
    private String nombre;
    private String usuario;
    private int fotoResId;

    public Usuario(int fotoResId, String usuario, String nombre) {
        this.fotoResId = fotoResId;
        this.usuario = usuario;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getFotoResId() {
        return fotoResId;
    }

    public void setFotoResId(int fotoResId) {
        this.fotoResId = fotoResId;
    }
}
