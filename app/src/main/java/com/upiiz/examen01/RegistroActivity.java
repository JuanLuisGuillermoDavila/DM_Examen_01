package com.upiiz.examen01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNombre, etCorreo, etUsuario, etPassword, etConfirmPassword;
    private Button btnRegistrarse;
    private TextView tvYaTengoCuenta;
    private ImageView btnRegresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Enlazar
        etNombre = findViewById(R.id.etNombreRegistro);
        etCorreo = findViewById(R.id.etCorreoRegistro);
        etUsuario = findViewById(R.id.etUsuarioRegistro);
        etPassword = findViewById(R.id.etPasswordRegistro);
        etConfirmPassword = findViewById(R.id.etConfirmPasswordRegistro);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);
        tvYaTengoCuenta = findViewById(R.id.tvYaTengoCuenta);
        btnRegresar = findViewById(R.id.btnRegresarRegistro);

        btnRegistrarse.setOnClickListener(this);
        btnRegresar.setOnClickListener(this);
        tvYaTengoCuenta.setOnClickListener(this);
    }

    private void validarYRegistro() {
        String nombre = etNombre.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String usuario = etUsuario.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        String confirmPassword = etConfirmPassword.getText().toString().trim();

        // Validación nombre con mínimo tres caracteres
        if (nombre.length() < 3) {
            etNombre.setError("El nombre debe tener al menos 3 caracteres");
            Toast.makeText(this, "El nombre debe tener al menos 3 caracteres", Toast.LENGTH_SHORT).show();
            return;
        }

        if (correo.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            etCorreo.setError("Ingresa un correo electrónico válido");
            Toast.makeText(this, "Correo electrónico inválido", Toast.LENGTH_SHORT).show();
            return;
        }
        // Validar campos requeridos no vacíos
        if (usuario.isEmpty() || password.isEmpty()) {

            Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validación que las contraseñas coincidan
        if (!password.equals(confirmPassword)) {
            etConfirmPassword.setError("Las contraseñas no coinciden");
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validación si para mandar al login
        Toast.makeText(this, "Registro exitoso. Inicia sesión", Toast.LENGTH_SHORT).show();
        finish(); // Cierra el registro y regresa a LoginActivity
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btnRegistrarse){
            validarYRegistro();
        } else if (v.getId()==R.id.tvYaTengoCuenta) {
            finish();
        }
        else {
            finish();
        }
    }
}