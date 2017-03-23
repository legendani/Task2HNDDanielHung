package com.example.alumnodanielhung.task2hnddanielhung.beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ALUMNOS on 16/03/2017.
 */

public class TipsBean implements Serializable{
    private int foto;
    private String titulo, descripcion;

    public TipsBean(String descripcion, int foto, String titulo) {
        this.descripcion = descripcion;
        this.foto = foto;
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
