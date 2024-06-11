package com.example.examenparcialcm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private EditText et_usuario, et_contrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        et_usuario = findViewById(R.id.txt_usuario);
        et_contrasena = findViewById(R.id.txt_password);
    }

    public void Registrar(View view){
        Intent regresar =new Intent(this,Register.class);
        startActivity(regresar);
    }
    public void ingresar(View view){
        String usuario = et_usuario.getText().toString();
        String contrasena = et_contrasena.getText().toString();
        validar_datos(usuario,contrasena);



    }

    private void validar_datos(String usu, String cont){
        if (usu.isEmpty()){
            Toast.makeText(this, "rellene usuario", Toast.LENGTH_SHORT).show();
        } else if (cont.isEmpty()) {
            Toast.makeText(this, "rellene contraseña", Toast.LENGTH_SHORT).show();
        }
        else {
            if (getIntent().getStringExtra("name") == null || getIntent().getStringExtra("password") == null) {
                Toast.makeText(this, "Usuario no esta registrado", Toast.LENGTH_SHORT).show();
            } else {
                String usuario = getIntent().getStringExtra("name");

                //Intent mandar_michi = new Intent(this, ActivityMichi.class);
                //mandar_michi.putExtra("name", usuario);
                //startActivity(mandar_michi);
            }
        }
    }

    public void registrar(View view){

        Toast.makeText(this, "prueba", Toast.LENGTH_SHORT).show();

    }
}