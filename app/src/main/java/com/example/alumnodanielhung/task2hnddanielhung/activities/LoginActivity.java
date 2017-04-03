package com.example.alumnodanielhung.task2hnddanielhung.activities;

import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editUsuario, editPass;
    private Button btnLog, btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Preferencias preferencias = new Preferencias(LoginActivity.this);

        if (preferencias.isLogin() == false) {
            editUsuario = (EditText) findViewById(R.id.editUsuario);
            editPass = (EditText) findViewById(R.id.editPass);

            btnLog = (Button) findViewById(R.id.btnLog);
            btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

            btnLog.setOnClickListener(this);
            btnRegistrar.setOnClickListener(this);
        } else {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnLog:
                String usuario = editUsuario.getText().toString();
                String pass = editPass.getText().toString();
                if (usuario != null && !usuario.isEmpty() && pass != null && !pass.isEmpty()) {
                    Preferencias preferencias = new Preferencias(LoginActivity.this);
                    UsuarioBean usuarioBean = preferencias.getUsuario();
                    if (usuarioBean.getNombre() != null) {
                        if (usuario.equals(usuarioBean.getUser()) && pass.equals(usuarioBean.getPass())) {
                            preferencias.setLogin(true);
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(LoginActivity.this, R.string.userrequired, Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(LoginActivity.this, R.string.required, Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.btnRegistrar:
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);
                break;
        }
    }
}
