package com.example.alumnodanielhung.task2hnddanielhung.Contenido;

import com.example.alumnodanielhung.task2hnddanielhung.R;
import com.example.alumnodanielhung.task2hnddanielhung.beans.ObjetosBean;
import com.example.alumnodanielhung.task2hnddanielhung.beans.PersonajesBean;
import com.example.alumnodanielhung.task2hnddanielhung.beans.TipsBean;

import java.util.ArrayList;

/**
 * Created by ALUMNOS on 16/03/2017.
 */

public class Contenido {

    public static ArrayList<PersonajesBean> getPersonajes(){
        ArrayList<PersonajesBean> personajes = new ArrayList<>();
        personajes.add(new PersonajesBean("Nave", R.drawable.masseffect , "Nave principal"));

        return personajes;
    }

    public static ArrayList<ObjetosBean> getObjetos(){
        ArrayList<ObjetosBean> objetos = new ArrayList<>();
        objetos.add(new ObjetosBean("Vida", R.drawable.wrench, "Kit de reparacion para la nave"));

        return objetos;
    }

    public static ArrayList<TipsBean> getTips(){
        ArrayList<TipsBean> tips = new ArrayList<>();
        tips.add(new TipsBean("Daño", R.drawable.wrench, "Intenta que no te hagan daño"));

        return tips;
    }
}
