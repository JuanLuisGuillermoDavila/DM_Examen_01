package com.upiiz.examen01.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.upiiz.examen01.R;
import com.upiiz.examen01.models.Usuario;

import java.util.ArrayList;

public class UsuarioAdapter extends BaseAdapter {
    private Context ctx;
    private ArrayList<Usuario> listaUsuarios;

    public UsuarioAdapter(Context ctx, ArrayList<Usuario> listaUsuarios) {
        this.ctx = ctx;
        this.listaUsuarios = listaUsuarios;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public int getCount() {
        return listaUsuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return listaUsuarios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_usuario,parent,false);
        }
        ImageView imgFoto = convertView.findViewById(R.id.imgFotoUsuario);
        TextView tvNombre = convertView.findViewById(R.id.tvNombreUsuarioItem);
        TextView tvHandle = convertView.findViewById(R.id.tvHandleUsuarioItem);

        Usuario usuario = listaUsuarios.get(position);

        tvNombre.setText(usuario.getNombre());
        tvHandle.setText(usuario.getUsuario());
        imgFoto.setImageResource(usuario.getFotoResId());
        return convertView;
    }
}
