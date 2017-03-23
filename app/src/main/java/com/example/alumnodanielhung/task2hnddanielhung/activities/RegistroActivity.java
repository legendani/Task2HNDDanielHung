package com.example.alumnodanielhung.task2hnddanielhung.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alumnodanielhung.task2hnddanielhung.Preferencias;
import com.example.alumnodanielhung.task2hnddanielhung.R;
import com.example.alumnodanielhung.task2hnddanielhung.beans.UsuarioBean;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editUser, editNombre, editApellidos, editEmail, editPassre, editPasscon;
    private Button btnGuardar, btnIniciar;
    private CheckBox checkTerminos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editUser = (EditText) findViewById(R.id.editUser);
        editNombre = (EditText) findViewById(R.id.editNombre);
        editApellidos = (EditText) findViewById(R.id.editApellidos);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPassre = (EditText) findViewById(R.id.editPassre);
        editPasscon = (EditText) findViewById(R.id.editPasscon);

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnIniciar = (Button) findViewById(R.id.btnIniciar);

        btnGuardar.setOnClickListener(this);
        btnIniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnGuardar:
                String user = editUser.getText().toString();
                String nombre = editNombre.getText().toString();
                String apellidos = editApellidos.getText().toString();
                String email = editEmail.getText().toString();
                String pass = editPassre.getText().toString();
                String passcon = editPasscon.getText().toString();

                if (user != null && nombre != null && apellidos != null && email != null && pass != null && passcon != null &&
                        !user.isEmpty() && !nombre.isEmpty() && !apellidos.isEmpty() && !email.isEmpty() && !pass.isEmpty() && !passcon.isEmpty()) {
                    UsuarioBean usuarioBean = new UsuarioBean(apellidos, email, nombre, pass, user);

                    Preferencias preferencias = new Preferencias(RegistroActivity.this);
                    preferencias.setUsuario(usuarioBean);

                    if (pass.equals(passcon)) {
                        Toast.makeText(RegistroActivity.this, "El usuario se ha guardado correctamente", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(RegistroActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegistroActivity.this, "Todos los datos son obligatorios", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btnIniciar:
                Intent intent = new Intent(RegistroActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
