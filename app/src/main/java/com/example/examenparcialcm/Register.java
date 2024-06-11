package com.example.examenparcialcm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register extends AppCompatActivity {

    private EditText R_usuario, R_contrasena;
    private RadioButton rb_rojo, rb_azul, rb_morado;
    private CheckBox cb_peru, cb_brasil, cb_colombia;
    private Spinner lis_lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        R_usuario = findViewById(R.id.R_usuario);
        R_contrasena = findViewById(R.id.R_contrasena);
        rb_rojo = findViewById(R.id.rb_rojo);
        rb_azul = findViewById(R.id.rb_azul);
        rb_morado = findViewById(R.id.rb_morado);
        cb_peru = findViewById(R.id.cb_peru);
        cb_brasil = findViewById(R.id.cb_brasil);
        cb_colombia = findViewById(R.id.cb_colombia);
       // String [] mylist={"manzana", "pera", "sandia", "mango"};
        //ArrayAdapter<String> adapta=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mylist);
       // lis_lista.setAdapter(adapta);
    }

    private String validar_campo(String usuario, String contrasena){
        if (usuario.isEmpty()){
            return "ingrese tu usuario";

        } else if (contrasena.isEmpty()) {
            return "ingrese contraseña";
        }
        else {
            return "";
        }
    }

    public void registro(View view){
        String usuario=R_usuario.getText().toString();
        String contrasena=R_contrasena.getText().toString();
        String campos_validados=validar_campo(usuario,contrasena);
        if (campos_validados.equals("")){

            Intent mandar_datos = new Intent(this, MainActivity.class);
            mandar_datos.putExtra("name", usuario);
            mandar_datos.putExtra("password", contrasena);
            startActivity(mandar_datos);
            finish();

        }
        else {
            Toast.makeText(this,campos_validados, Toast.LENGTH_SHORT).show();
        }

    }

    public void cancelar(View view) {
        Intent cancelar = new Intent(this, MainActivity.class);
        startActivity(cancelar);
    }

}
