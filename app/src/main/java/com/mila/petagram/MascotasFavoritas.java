package com.mila.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MascotasFavoritas extends AppCompatActivity {

    List<Mascotas> elementos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        Toolbar myActionBar = findViewById(R.id.miActionBar2);
        setSupportActionBar(myActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    public void init()
    {

        Bundle extras = getIntent().getExtras();

            elementos = new ArrayList<>();
            elementos = ((ArrayList<Mascotas>) getIntent().getSerializableExtra("arrayMascotas"));

            MascotasAdapter mascotasAdapter = new MascotasAdapter(elementos, this);

            RecyclerView recyclerView =(RecyclerView) findViewById(R.id.listRecyclerViewMascotas);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(mascotasAdapter);



    }
}