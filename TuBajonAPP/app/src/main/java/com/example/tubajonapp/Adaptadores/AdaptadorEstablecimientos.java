package com.example.tubajonapp.Adaptadores;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tubajonapp.Clases.Establecimientos;
import com.example.tubajonapp.R;

import java.util.ArrayList;

public class AdaptadorEstablecimientos extends ArrayAdapter<Establecimientos> {

    Context context;
    ArrayList<Establecimientos> ListaEstablecimientos;
    Integer[] ImgEstablecimientos ;
    public AdaptadorEstablecimientos(Context context, ArrayList<Establecimientos> listEstablecimientos, Integer[] imgEstablecimientos) {
        super(context, R.layout.card_establecimiento, listEstablecimientos);
        this.context = context;
        ListaEstablecimientos = listEstablecimientos;
        ImgEstablecimientos = imgEstablecimientos;

    }
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.card_establecimiento, null);
        TextView titulo = item.findViewById(R.id.tituloTextView);
        TextView descripcion = item.findViewById(R.id.descripcionTextView);
        TextView direccion = item.findViewById(R.id.direccionTextView);
        titulo.setText(ListaEstablecimientos.get(position).getNombre());
        descripcion.setText(ListaEstablecimientos.get(position).getDescripcion());
        direccion.setText(ListaEstablecimientos.get(position).getDireccion());
        ImageView Establecimiento = item.findViewById(R.id.imageView);
        ImageButton Favorito = item.findViewById(R.id.favoritoButton);
        Establecimiento.setImageResource(ImgEstablecimientos[position]);
        Favorito.setImageResource(R.drawable.baseline_favorite_24);
        return(item);
    }

}
