package com.upiiz.examen01.models;

public class Mensaje {
    private String texto;
    private String hora;
    private boolean esMio;

    public Mensaje(String texto, String hora, boolean esMio) {
        this.texto = texto;
        this.hora = hora;
        this.esMio = esMio;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public boolean isEsMio() {
        return esMio;
    }

    public void setEsMio(boolean esMio) {
        this.esMio = esMio;
    }
}
