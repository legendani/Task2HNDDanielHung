package com.example.alumnodanielhung.task2hnddanielhung.test;

import com.example.alumnodanielhung.task2hnddanielhung.R;
import com.example.alumnodanielhung.task2hnddanielhung.beans.PersonajesBean;

import java.util.ArrayList;

/**
 * Created by ALUMNOS on 16/03/2017.
 */

public class Modelo {

    public static ArrayList<PersonajesBean> getPersonajes(){
        ArrayList<PersonajesBean> personajes = new ArrayList<>();
        personajes.add(new PersonajesBean("Nave", R.drawable.masseffect , "Nave principal"));

        return personajes;
    }
}
