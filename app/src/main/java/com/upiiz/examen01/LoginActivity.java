package com.upiiz.examen01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsuario, etPassword;
    private Button btnIniciarSesion, btnCrearCuenta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Enlazar
        etUsuario = findViewById(R.id.etUsuarioLogin);
        etPassword = findViewById(R.id.etPasswordLogin);
        btnCrearCuenta = findViewById(R.id.btnCrearCuenta);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        //Para los botones
        btnIniciarSesion.setOnClickListener(this);
        btnCrearCuenta.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnIniciarSesion){
            iniciarSesion();
        } else if (v.getId()==R.id.btnCrearCuenta) {
            crearCuenta();
        }
    }

    public void iniciarSesion(){
        String usuario = etUsuario.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (usuario.equals("admin") && password.equals("123456")) {
            Toast.makeText(LoginActivity.this, "¡Bienvenido " + usuario + "!", Toast.LENGTH_SHORT).show();
            // Redirigir al listado de usuarios (MainActivity)
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish(); // Para que no pueda volver al Login presionando atrás
        } else {
            Toast.makeText(LoginActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
    public void crearCuenta(){
        Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
        startActivity(intent);
    }
}