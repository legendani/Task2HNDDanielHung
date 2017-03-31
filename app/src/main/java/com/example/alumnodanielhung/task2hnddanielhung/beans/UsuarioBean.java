package com.example.alumnodanielhung.task2hnddanielhung.beans;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by ALUMNOS on 09/03/2017.
 */

public class UsuarioBean implements Serializable{
    private String user, nombre, apellidos, email, pass, photo;

    public UsuarioBean(String apellidos, String email, String nombre, String pass, String user) {
        this.apellidos = apellidos;
        this.email = email;
        this.nombre = nombre;
        this.pass = pass;
        this.user = user;
    }

    public UsuarioBean() {
    }

    public String getUser() {
        return user;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }


    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static UsuarioBean fromJson(String json) {
        if (json != null && !json.isEmpty()) {
            Gson gson = new Gson();
            return gson.fromJson(json, UsuarioBean.class);
        }else {
            return new UsuarioBean();
        }
    }
}
