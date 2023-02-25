package com.example.pelicula;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment2 extends Fragment {

    private Button mBTN_Regresar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_2, container, false);
//        View view = inflater.inflate(R.layout.fragment_1, container, false);

       mBTN_Regresar = view.findViewById(R.id.BTN_Volver);
       mBTN_Regresar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(getContext(), MainActivity.class);
               intent.putExtra("mensaje", "cartelera de peliculas");

               startActivity(intent);
           }
       });
        return view;
    }
}