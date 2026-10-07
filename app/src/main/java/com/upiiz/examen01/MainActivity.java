package com.upiiz.examen01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.upiiz.examen01.adapters.UsuarioAdapter;
import com.upiiz.examen01.models.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lvUsuarios;
    private ArrayList<Usuario> listaUsuarios;
    private UsuarioAdapter adapter;
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

        //Enlazamos
        lvUsuarios = findViewById(R.id.lvUsuarios);
        cargarUsuarios();
        adapter = new UsuarioAdapter(this,listaUsuarios);

        lvUsuarios.setAdapter(adapter);
        lvUsuarios.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Usuario usuarioSeleccionado = (Usuario) parent.getItemAtPosition(position);
        if(usuarioSeleccionado !=  null){
            Intent intent = new Intent(this, ChatActivity.class);
            intent.putExtra("fotoUsuario",usuarioSeleccionado.getFotoResId());
            intent.putExtra("usuario",usuarioSeleccionado.getNombre());
            startActivity(intent);
        }
    }

    private void cargarUsuarios() {
        listaUsuarios = new ArrayList<>();
        // Constructor: (int fotoResId, String usuario, String nombre)
        listaUsuarios.add(new Usuario(R.drawable.userfoto, "ana123", "Ana García"));
        listaUsuarios.add(new Usuario(R.drawable.user, "luism", "Luis Martínez"));
        listaUsuarios.add(new Usuario(R.drawable.userfoto, "marta_22", "Marta López"));
        listaUsuarios.add(new Usuario(R.drawable.user, "pedro99", "Pedro Sánchez"));
        listaUsuarios.add(new Usuario(R.drawable.userfoto, "sofia_t", "Sofía Torres"));
        listaUsuarios.add(new Usuario(R.drawable.user, "juanr", "Juan Rodríguez"));
        listaUsuarios.add(new Usuario(R.drawable.userfoto, "carlos_g", "Carlos Gómez"));
        listaUsuarios.add(new Usuario(R.drawable.user, "laura_f", "Laura Fernández"));
        listaUsuarios.add(new Usuario(R.drawable.userfoto, "diegor", "Diego Ramírez"));
        listaUsuarios.add(new Usuario(R.drawable.user, "elena_m", "Elena Morales"));
        listaUsuarios.add(new Usuario(R.drawable.userfoto, "gaby_o", "Gabriel Ortiz"));
        listaUsuarios.add(new Usuario(R.drawable.user, "vale_n", "Valeria Navarro"));
        listaUsuarios.add(new Usuario(R.drawable.userfoto, "fer_cas", "Fernando Castillo"));
        listaUsuarios.add(new Usuario(R.drawable.user, "paty_r", "Patricia Ruiz"));
        listaUsuarios.add(new Usuario(R.drawable.userfoto, "andres_r", "Andrés Romero"));
        listaUsuarios.add(new Usuario(R.drawable.user, "cami_v", "Camila Vargas"));
        listaUsuarios.add(new Usuario(R.drawable.userfoto, "javi_m", "Javier Mendoza"));
        listaUsuarios.add(new Usuario(R.drawable.user, "lucia_a", "Lucía Aguilar"));
        listaUsuarios.add(new Usuario(R.drawable.userfoto, "roberto_c", "Roberto Cruz"));
        listaUsuarios.add(new Usuario(R.drawable.user, "dani_reyes", "Daniela Reyes"));
    }
}