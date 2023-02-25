package com.example.pelicula;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {
    private Button mBTN_Visualizar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        mBTN_Visualizar = view.findViewById(R.id.BTN_Visualizar);

        mBTN_Visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity2.class);
                intent.putExtra("mensaje", "cartelera de peliculas");

                startActivity(intent);
            }
        });
        return view;
    }
}