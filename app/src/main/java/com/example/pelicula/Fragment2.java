package com.example.pelicula;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class Fragment2 extends Fragment {
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        listView = view.findViewById(R.id.LV_Peliculas);

        Bundle bundle = getArguments();
        Pelicula pelicula = (Pelicula) bundle.getSerializable("pelicula");

        ArrayList<String> peliculaList = new ArrayList<>();
        peliculaList.add(pelicula.getmNom());
        peliculaList.add(pelicula.getmGenero());

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, peliculaList);

        listView.setAdapter(adapter);

        return view;
    }
}