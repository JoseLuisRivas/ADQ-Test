package com.adq.adq.models;

// Minuto - 5:00 - Video Volley Frameworks

// Pasos para trabajar con RecyclerView
// 1. Creo Modelo Hotel con sus getters y setters
// 2. Creo la vista fragment_hoteles, de tipo FrameLayout, que contiene una android.support.v7.widget.RecyclerView
// 3. Creo la vista row_hoteles,
// 4. Creo la clase HotelesAdapter

public class Hotel {

    private String nombreHotel;
    private String municipio;
    private int     start;

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
