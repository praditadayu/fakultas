package com.example.fakultas;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GridActivity extends RecyclerView.Adapter<GridActivity.GridViewHolder> {

    private static final String TAG = "ListView";
    private ArrayList<String> NamaFakultas = new ArrayList<>();
    private ArrayList<String> NamaOrganisasiMahasiswa = new ArrayList<>();
    private ArrayList<String> LokasiFakultas = new ArrayList<>();
    private ArrayList<String> LinkGambar = new ArrayList<>();
    private ArrayList<String> DetailFakultas = new ArrayList<>();

    private Context context;

    public GridActivity(Context context, ArrayList<String> NamaFakultas, ArrayList<String> LinkGambar, ArrayList<String> NamaOrganisasiMahasiswa, ArrayList<String> LokasiFakultas, ArrayList<String> DetailFakultas) {
        this.NamaFakultas = NamaFakultas;
        this.LinkGambar= LinkGambar;
        this.NamaOrganisasiMahasiswa = NamaOrganisasiMahasiswa;
        this.LokasiFakultas = LokasiFakultas;
        this.DetailFakultas = DetailFakultas;
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int i) {
        Glide.with(context)
                .asBitmap()
                .load(LinkGambar.get(i))
                .into(holder.imgPhoto);
        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: clicked on: "+ NamaFakultas.get(i));
                Toast.makeText(context, NamaFakultas.get(i),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, GalleryActivity.class);
                intent.putExtra("link",LinkGambar.get(i));
                intent.putExtra("nama",NamaFakultas.get(i));
                intent.putExtra("namaorganisasi",NamaOrganisasiMahasiswa.get(i));
                intent.putExtra("lokasi",LokasiFakultas.get(i));
                intent.putExtra("detailfakultas",DetailFakultas.get(i));

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return LinkGambar.size();
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
