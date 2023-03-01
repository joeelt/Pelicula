package com.example.pelicula;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Fragment1 extends Fragment {
    private EditText mET_informacion;
    private EditText mET_Genero;
    private Button mBTN_Visualizar;
    private Button mBTN_Afegir;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        mET_informacion = view.findViewById(R.id.ET_Nom);
        mBTN_Visualizar = view.findViewById(R.id.BTN_Visualizar);
        mBTN_Afegir = view.findViewById(R.id.BTN_Afegir);
        mET_Genero = view.findViewById(R.id.ET_Genero);

        firebaseDatabase = FirebaseDatabase.getInstance(
                "https://pelicula1-724eb-default-rtdb.europe-west1.firebasedatabase.app/");
        databaseReference = firebaseDatabase.getReference();

        mBTN_Visualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), MainActivity2.class);
                startActivity(intent);
            }
        });

        mBTN_Afegir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tituloPelicula = mET_informacion.getText().toString();
                String genero = mET_Genero.getText().toString();
                String uid = databaseReference.push().getKey();

                Pelicula pelicula = new Pelicula(tituloPelicula, genero);

                databaseReference.child("Pelicules").child(uid).setValue(pelicula);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                intent.putExtra("texto", tituloPelicula);
                startActivity(intent);


            }
        });


        return view;
    }
}