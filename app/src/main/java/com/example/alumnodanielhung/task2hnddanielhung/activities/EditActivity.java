package com.example.alumnodanielhung.task2hnddanielhung.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alumnodanielhung.task2hnddanielhung.MainActivity;
import com.example.alumnodanielhung.task2hnddanielhung.Preferencias;
import com.example.alumnodanielhung.task2hnddanielhung.R;
import com.example.alumnodanielhung.task2hnddanielhung.beans.UsuarioBean;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText newPass, newUser, newMail;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        newPass = (EditText) findViewById(R.id.newPass);
        newUser = (EditText) findViewById(R.id.newUser);
        newMail = (EditText) findViewById(R.id.newMail);

        btnVolver = (Button) findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String newpass = newPass.getText().toString();
        String newuser = newUser.getText().toString();
        String newmail = newMail.getText().toString();

        if (newpass != null || !newpass.isEmpty() || newuser != null && !newuser.isEmpty() || newmail != null && !newmail.isEmpty()) {
            Preferencias preferencias = new Preferencias(EditActivity.this);
            UsuarioBean usuarioBean = preferencias.getUsuario();

            usuarioBean.setPass(newpass);
            usuarioBean.setUser(newuser);
            usuarioBean.setEmail(newmail);

            preferencias.setUsuario(usuarioBean);
            Toast.makeText(this, "Datos guardados", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(EditActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
