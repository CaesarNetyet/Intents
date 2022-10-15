package com.example.intents.adaptadores;


import android.content.Intent;
import android.net.Uri;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.intents.R;
import com.example.intents.modelos.Persona;

import java.util.List;

public class PersonaAdaptador extends Adapter<PersonaAdaptador.viewholder>{
    List<Persona> LP;

    public PersonaAdaptador(List<Persona> LP) {
        this.LP = LP;
    }

    @NonNull
    @Override
    public PersonaAdaptador.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.personas,parent,false);


        return new viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaAdaptador.viewholder holder, int position) {
        holder.setData(LP.get(position));
    }

    @Override
    public int getItemCount() {
        return LP.size();
    }

    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtNombre;
        TextView txtTelefono;
        Persona personaHolder;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            txtNombre= itemView.findViewById(R.id.txt_nombre);
            txtTelefono= itemView.findViewById(R.id.txt_numero);
            itemView.setOnClickListener(this);
        }

        public void setData(Persona p) {
            personaHolder=p;
            txtNombre.setText(p.getNombre());
            txtTelefono.setText(p.getTelefono());
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "diste un click a " + personaHolder.getNombre(),Toast.LENGTH_SHORT).show();
            Intent llamada = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+personaHolder.getTelefono()));
            v.getContext().startActivity(llamada);

        }
    }
}
