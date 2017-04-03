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
        personajes.add(new PersonajesBean("Es la nave que comandas, tiene dos torretas a sus lados para poder disparar, además tiene espacio para añadir nuevas armas y es lo suficientemente rápida como para escapar.", R.drawable.masseffect , "Requiem"));
        personajes.add(new PersonajesBean("Son las naves de la flota enemiga, no son muy resistentes pero sus armas son muy poderosas, tienen un cañón en cada lado y son pequeñas para poder evadir con mayor facilidad.", R.drawable.reaper , "Reaper"));
        personajes.add(new PersonajesBean("Es la nave base, es una nave lenta pero muy resistente, además tiene un cañón en el eje central, no tenemos ninguna información sobre lo que hace el cañón, acercarse con precaución.", R.drawable.cylon , "Adam"));

        return personajes;
    }

    public static ArrayList<ObjetosBean> getObjetos(){
        ArrayList<ObjetosBean> objetos = new ArrayList<>();
        objetos.add(new ObjetosBean("Un kit de reparación, te restauran una vida y los puedes encontrar en la zona con cierta facilidad.", R.drawable.wrench, "Reparación"));
        objetos.add(new ObjetosBean("Son Kits de munición que mejoran tus armas para que hagan más daño.", R.drawable.powerup, "Mejora"));
        objetos.add(new ObjetosBean("Una bomba que causa que todas las naves enemigas dentro de un área se destruyan", R.drawable.bomb, "Bomba"));

        return objetos;
    }

    public static ArrayList<TipsBean> getTips(){
        ArrayList<TipsBean> tips = new ArrayList<>();
        tips.add(new TipsBean("Apunta al cañón del jefe enemigo, le hará más daño.", "Jefe"));

        return tips;
    }
}
