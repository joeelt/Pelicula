package com.example.pelicula;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment {

    private ListView mLvPeliculas;
    private List<Pelicula> mListaPeliculas = new ArrayList<>();
    private ArrayAdapter<Pelicula> mAdapterPeliculas;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        mLvPeliculas = view.findViewById(R.id.LV_Peliculas);

        firebaseDatabase = FirebaseDatabase.getInstance(
                "https://pelicula1-724eb-default-rtdb.europe-west1.firebasedatabase.app/");
        databaseReference = firebaseDatabase.getReference();

        ListarPeliculas();



        return view;
    }

    private void ListarPeliculas() {

        databaseReference.child("Pelicules").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                mListaPeliculas.clear();

                for (DataSnapshot peliculaActual: dataSnapshot.getChildren()) {

                    Pelicula pelicula = peliculaActual.getValue(Pelicula.class);
                    mListaPeliculas.add(pelicula);
                }

                mAdapterPeliculas = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, mListaPeliculas);
                mLvPeliculas.setAdapter(mAdapterPeliculas);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}