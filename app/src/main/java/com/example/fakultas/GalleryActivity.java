package com.example.fakultas;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        getIncomingIntent();


    }

    private void getIncomingIntent(){
        if (getIntent().hasExtra("link") && getIntent().hasExtra("nama") && getIntent().hasExtra("namaorganisasi") && getIntent().hasExtra("lokasi") && getIntent().hasExtra("detailfakultas")){

            String Link = getIntent().getStringExtra("link");
            String Nama = getIntent().getStringExtra("nama");
            String NamaOrganisasi = getIntent().getStringExtra("namaorganisasi");
            String Lokasi = getIntent().getStringExtra("lokasi");
            String DetailFakultas = getIntent().getStringExtra("detailfakultas");

            setImage(Link,Nama,NamaOrganisasi,Lokasi,DetailFakultas);
        }

    }

    private void setImage(String Link, String Nama, String NamaOrganisasi, String Lokasi, String DetailFakultas){
        TextView name = findViewById(R.id.img_desc);
        name.setText(Nama);
        TextView det = findViewById(R.id.img_det);
        det.setText(DetailFakultas);

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(Link)
                .into(image);
    }
}