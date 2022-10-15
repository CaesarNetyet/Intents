package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.intents.adaptadores.PersonaAdaptador;
import com.example.intents.modelos.Persona;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Persona> personas= new ArrayList <>();
        personas.add(new Persona("Julio Cesar Tovar", "8721170691"));
        personas.add(new Persona("Julai", "8721170691"));
        personas.add(new Persona("gaspa", "8721170691"));
        personas.add(new Persona("gabriela", "8721170691"));
        personas.add(new Persona("pack", "8721170691"));
        PersonaAdaptador personaAdaptador = new PersonaAdaptador(personas);
        LinearLayoutManager ln = new LinearLayoutManager(this);
        RecyclerView listas=(RecyclerView) findViewById(R.id.recyclerView);
        listas.setAdapter(personaAdaptador);
        listas.setLayoutManager(ln);
        listas.setHasFixedSize(true);

    }
}