package com.example.alumnodanielhung.task2hnddanielhung;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.alumnodanielhung.task2hnddanielhung.activities.LoginActivity;
import com.example.alumnodanielhung.task2hnddanielhung.fragments.AjustesFragment;
import com.example.alumnodanielhung.task2hnddanielhung.fragments.DescripcionFragment;
import com.example.alumnodanielhung.task2hnddanielhung.fragments.ListObjetosFragment;
import com.example.alumnodanielhung.task2hnddanielhung.fragments.ListPersonajesFragment;
import com.example.alumnodanielhung.task2hnddanielhung.fragments.ListTipsFragment;
import com.example.alumnodanielhung.task2hnddanielhung.fragments.PerfilFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navView;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer);
        navView = (NavigationView) findViewById(R.id.navView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navView.setNavigationItemSelectedListener(this);

        fm = getSupportFragmentManager();
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawer.openDrawer(GravityCompat.START);
                break;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_perfil:
                PerfilFragment perfilFragment = PerfilFragment.newInstance();
                fm.beginTransaction().replace(R.id.container, perfilFragment).commit();
                break;
            case R.id.item_descripcion:
                DescripcionFragment descripcionFragment = DescripcionFragment.newInstance();
                fm.beginTransaction().replace(R.id.container, descripcionFragment).commit();
                break;
            case R.id.item_personajes:
                ListPersonajesFragment listPersonajesFragment = ListPersonajesFragment.newInstance();
                fm.beginTransaction().replace(R.id.container, listPersonajesFragment).commit();
                break;
            case R.id.item_objetos:
                ListObjetosFragment listObjetosFragment = ListObjetosFragment.newInstance();
                fm.beginTransaction().replace(R.id.container, listObjetosFragment).commit();
                break;
            case R.id.item_tips:
                ListTipsFragment listTipsFragment = ListTipsFragment.newInstance();
                fm.beginTransaction().replace(R.id.container, listTipsFragment).commit();
                break;
            case R.id.item_ajustes:
                AjustesFragment ajustesFragment = AjustesFragment.newInstance();
                fm.beginTransaction().replace(R.id.container, ajustesFragment).commit();
                break;
            case R.id.item_salir:
                Preferencias preferencias = new Preferencias(MainActivity.this);
                preferencias.setLogin(false);
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return true;
    }
}
