package com.mila.petagram;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Mascotas implements Serializable {

    private String nombreMascota;
    private int rutaFoto;
    private int huesoTop;

    public Mascotas(String nombreMascota, int rutaFoto) {
        this.nombreMascota = nombreMascota;
        this.rutaFoto = rutaFoto;
        this.huesoTop=0;
    }

    protected Mascotas(Parcel in) {
        nombreMascota = in.readString();
        rutaFoto = in.readInt();
        huesoTop = in.readInt();
    }


    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public int getHuesoTop() {
        return huesoTop;
    }

    public void setHuesoTop(int huesoTop) {
        this.huesoTop = huesoTop;
    }

    public int getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(int rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

}
