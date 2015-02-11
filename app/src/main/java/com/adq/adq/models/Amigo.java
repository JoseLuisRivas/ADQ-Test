package com.adq.adq.models;

// Minuto 58: 05 - Video 2 - Reclycler View,  Card View y  Adapter
// minuto 1:01:30 - Agrego las dependencias los widged a el gradel
// Esto es un Objeto POJO - objeto basico de java
public class Amigo {

    // Variables de acuerdo a la vista row_hoteles.xmlml
    private String nombreAmigo;
    private String twitter;
    private String ultimoHotel;

    public String getNombreAmigo() {
        return nombreAmigo;
    }

    public void setNombreAmigo(String nombreAmigo) {
        this.nombreAmigo = nombreAmigo;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getUltimoHotel() {
        return ultimoHotel;
    }

    public void setUltimoHotel(String ultimoHotel) {
        this.ultimoHotel = ultimoHotel;
    }
}
