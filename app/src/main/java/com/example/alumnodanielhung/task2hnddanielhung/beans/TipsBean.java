package com.example.alumnodanielhung.task2hnddanielhung.beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by ALUMNOS on 16/03/2017.
 */

public class TipsBean implements Serializable{
    private String titulo, descripcion;

    public TipsBean(String descripcion, String titulo) {
        this.descripcion = descripcion;
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
