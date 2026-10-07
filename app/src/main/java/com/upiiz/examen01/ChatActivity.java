package com.upiiz.examen01;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.upiiz.examen01.adapters.MensajeAdapter;
import com.upiiz.examen01.models.Mensaje;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private ListView lvMensajes;
    private ArrayList<Mensaje> listaMensajes;
    private MensajeAdapter adapter;
    private TextView tvNombreContacto;
    private ImageView imgFotoContacto;
    private ImageView btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Enlazar
        tvNombreContacto = findViewById(R.id.tvNombreChatDetail);
        imgFotoContacto = findViewById(R.id.imgFotoChatDetail);
        btnRegresar = findViewById(R.id.btnRegresarChat);
        lvMensajes = findViewById(R.id.lvMensajes);

        // Recibir los Extras desde MainActivity
        if (getIntent() != null) {
            if (getIntent().hasExtra("usuario")) {
                String nombre = getIntent().getStringExtra("usuario");
                tvNombreContacto.setText(nombre);
            }
            if (getIntent().hasExtra("fotoUsuario")) {
                int fotoResId = getIntent().getIntExtra("fotoUsuario", R.drawable.user);
                imgFotoContacto.setImageResource(fotoResId);
            }
        }

        btnRegresar.setOnClickListener(v -> finish());

        cargarMensajes();
        adapter = new MensajeAdapter(this, listaMensajes);
        lvMensajes.setAdapter(adapter);
    }

    private void cargarMensajes() {
        listaMensajes = new ArrayList<>();
        // true = Derecha (Enviado), false = Izquierda (Recibido)
        listaMensajes.add(new Mensaje("¡Hola! ¿Cómo estás?", "09:00", true));
        listaMensajes.add(new Mensaje("¡Hola! Muy bien, ¿y tú?", "09:01", false));
        listaMensajes.add(new Mensaje("Todo bien por acá.", "09:02", true));
        listaMensajes.add(new Mensaje("¿Terminaste la práctica?", "09:03", true));
        listaMensajes.add(new Mensaje("Sí, ya casi termino todo.", "09:04", false));
        listaMensajes.add(new Mensaje("Excelente. ¿Vas a ir a la clase hoy?", "09:05", true));
        listaMensajes.add(new Mensaje("Claro, llego en 10 minutos.", "09:06", false));
        listaMensajes.add(new Mensaje("Perfecto, te guardo lugar.", "09:07", true));
        listaMensajes.add(new Mensaje("Muchas gracias amigo.", "09:08", false));
        listaMensajes.add(new Mensaje("¿Traes la laptop?", "09:09", true));
        listaMensajes.add(new Mensaje("Sí, aquí la llevo en la mochila.", "09:10", false));
        listaMensajes.add(new Mensaje("Genial, revisamos el código juntos.", "09:11", true));
        listaMensajes.add(new Mensaje("Me parece muy buena idea.", "09:12", false));
        listaMensajes.add(new Mensaje("¿Ya subiste los cambios a GitHub?", "09:13", true));
        listaMensajes.add(new Mensaje("Aún no, lo hago saliendo.", "09:14", false));
        listaMensajes.add(new Mensaje("Va, no se te vaya a olvidar.", "09:15", true));
        listaMensajes.add(new Mensaje("No te preocupes, yo me me encargo.", "09:16", false));
        listaMensajes.add(new Mensaje("Ok, nos vemos al rato.", "09:17", true));
        listaMensajes.add(new Mensaje("Sale, ahí te veo.", "09:18", false));
        listaMensajes.add(new Mensaje("Perfecto, bye!", "09:19", true));
    }
}