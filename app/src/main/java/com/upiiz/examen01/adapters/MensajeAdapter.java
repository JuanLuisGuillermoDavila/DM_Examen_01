package com.upiiz.examen01.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.upiiz.examen01.R;
import com.upiiz.examen01.models.Mensaje;

import java.util.ArrayList;

public class MensajeAdapter extends BaseAdapter {
    private Context ctx;
    private ArrayList<Mensaje> listaMensajes;

    public MensajeAdapter(Context ctx, ArrayList<Mensaje> listaMensajes) {
        this.ctx = ctx;
        this.listaMensajes = listaMensajes;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    public ArrayList<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(ArrayList<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    @Override
    public int getCount() {
        return listaMensajes.size();
    }

    @Override
    public Object getItem(int position) {
        return listaMensajes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_mensaje, parent, false);
        }

        LinearLayout container = convertView.findViewById(R.id.containerMensaje);
        LinearLayout burbuja = convertView.findViewById(R.id.burbujaMensaje);
        TextView tvTexto = convertView.findViewById(R.id.tvTextoMensaje);
        TextView tvHora = convertView.findViewById(R.id.tvHoraMensaje);

        Mensaje mensaje = listaMensajes.get(position);

        tvTexto.setText(mensaje.getTexto());
        tvHora.setText(mensaje.getHora());

        // Alineación y colores según emisor (Derecha) o receptor (Izquierda)
        if (mensaje.isEsMio()) {
            container.setGravity(Gravity.END);
            burbuja.setBackgroundColor(Color.parseColor("#1976D2"));
            tvTexto.setTextColor(Color.WHITE);
            tvHora.setTextColor(Color.parseColor("#E3F2FD"));
        } else {
            container.setGravity(Gravity.START);
            burbuja.setBackgroundColor(Color.parseColor("#E0E0E0"));
            tvTexto.setTextColor(Color.BLACK);
            tvHora.setTextColor(Color.parseColor("#616161"));
        }

        return convertView;
    }
}