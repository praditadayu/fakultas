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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class ListActivity extends RecyclerView.Adapter<ListActivity.ViewHolder> {

    private static final String TAG = "ListView";
    private ArrayList<String> NamaFakultas = new ArrayList<>();
    private ArrayList<String> NamaOrganisasiMahasiswa = new ArrayList<>();
    private ArrayList<String> LokasiFakultas = new ArrayList<>();
    private ArrayList<String> LinkGambar = new ArrayList<>();
    private ArrayList<String> DetailFakultas = new ArrayList<>();

    private Context context;

    public ListActivity(Context context, ArrayList<String> NamaFakultas, ArrayList<String> LinkGambar, ArrayList<String> NamaOrganisasiMahasiswa, ArrayList<String> LokasiFakultas, ArrayList<String> DetailFakultas){
        this.NamaFakultas = NamaFakultas;
        this.LinkGambar= LinkGambar;
        this.NamaOrganisasiMahasiswa = NamaOrganisasiMahasiswa;
        this.LokasiFakultas = LokasiFakultas;
        this.DetailFakultas = DetailFakultas;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        Log.d(TAG,"onBindViewHolder: called.");

        Glide.with(context)
                .asBitmap()
                .load(LinkGambar.get(i))
                .into(holder.gambarList);
        holder.namaFakultasList.setText(NamaFakultas.get(i));
        holder.namaOrganisasiMahasiswaList.setText(NamaOrganisasiMahasiswa.get(i));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: clicked on: "+ NamaFakultas.get(i));
                Toast.makeText(context, "Detail "+NamaFakultas.get(i),Toast.LENGTH_SHORT).show();

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
        return NamaFakultas.size();
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView gambarList;
        TextView namaFakultasList;
        TextView namaOrganisasiMahasiswaList;
        RelativeLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gambarList = itemView.findViewById(R.id.gambarList);
            namaFakultasList = itemView.findViewById(R.id.namaFakultasList);
            namaOrganisasiMahasiswaList = itemView.findViewById(R.id.namaOrganisasiMahasiswaList);
            parentLayout = itemView.findViewById(R.id.list);
        }
    }
}