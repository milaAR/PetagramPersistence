package com.mila.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Mascotas> elementos;
    ArrayList<Mascotas> listaTopMascotas=new ArrayList<>();
    ArrayList<Mascotas> listaTopMascotasOrden=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(myActionBar);

        init();
    }

    public void init()
    {
        elementos = new ArrayList<>();
        elementos.add(new Mascotas("Perro", R.drawable.perro));
        elementos.add(new Mascotas("Gato", R.drawable.gato));
        elementos.add(new Mascotas("Borrego", R.drawable.borrego));
        elementos.add(new Mascotas("Colibrí", R.drawable.colibri));
        elementos.add(new Mascotas("Conejo", R.drawable.conejo));
        elementos.add(new Mascotas("Cobaya", R.drawable.cuyo));
        elementos.add(new Mascotas("Hamster", R.drawable.hamster));
        elementos.add(new Mascotas("Iguana", R.drawable.iguana));
        elementos.add(new Mascotas("Pato", R.drawable.pato));
        elementos.add(new Mascotas("Perico", R.drawable.perico));
        elementos.add(new Mascotas("Tortuga", R.drawable.tortuga));

        MascotasAdapter mascotasAdapter = new MascotasAdapter(elementos, this);

        RecyclerView recyclerView =(RecyclerView) findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mascotasAdapter);

        ImageButton imageButton = findViewById(R.id.starMascotasFavoritas);
       imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mascotasAdapter.contador>0)
                {
                    Intent mascotasFavoritas = new Intent(MainActivity.this, MascotasFavoritas.class);
                    int cont=0;
                    for(int i=0; i<elementos.size(); i++)
                    {
                        Mascotas capturarMascota = elementos.get(i);
                        if(capturarMascota.getHuesoTop()!=0)
                        {
                            listaTopMascotas.add(capturarMascota);
                            cont++;
                        }
                    }
                    if(cont>0)
                    {
                        int contador=1;
                        while(contador<=listaTopMascotas.size())
                        {
                            for(int j=0; j<listaTopMascotas.size(); j++)
                            {
                                if(listaTopMascotas.get(j).getHuesoTop()==contador)
                                {
                                    listaTopMascotasOrden.add(listaTopMascotas.get(j));
                                    contador++;
                                    break;
                                }
                            }
                        }
                        mascotasFavoritas.putExtra("arrayMascotas", listaTopMascotasOrden);
                        startActivity(mascotasFavoritas);
                    }
                }
            }
        });

    }
}