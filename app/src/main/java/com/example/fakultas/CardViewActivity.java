package com.example.fakultas;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class CardViewActivity extends RecyclerView.Adapter<CardViewActivity.ViewHolder> {

    private static final String TAG = "CardView";
    private ArrayList<String> NamaFakultas = new ArrayList<>();
    private ArrayList<String> NamaOrganisasiMahasiswa = new ArrayList<>();
    private ArrayList<String> LokasiFakultas = new ArrayList<>();
    private ArrayList<String> LinkGambar = new ArrayList<>();
    private ArrayList<String> DetailFakultas = new ArrayList<>();
    private Context context;

    public CardViewActivity(Context context, ArrayList<String> NamaFakultas, ArrayList<String> LinkGambar, ArrayList<String> NamaOrganisasiMahasiswa, ArrayList<String> LokasiFakultas, ArrayList<String> DetailFakultas){
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card_view,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        Log.d(TAG,"onBindViewHolder: called.");

        Glide.with(context)
                .asBitmap()
                .load(LinkGambar.get(i))
                .into(holder.gambarCardView);
        holder.namaFakultasCardView.setText(NamaFakultas.get(i));
        holder.namaOrganisasiCardView.setText(NamaOrganisasiMahasiswa.get(i));

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
        holder.btnlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: clicked on: "+ NamaFakultas.get(i));
                Toast.makeText(context, "Like "+ NamaFakultas.get(i),Toast.LENGTH_SHORT).show();
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

        Button btnlike;
        ImageView gambarCardView;
        TextView namaFakultasCardView;
        TextView namaOrganisasiCardView;
        CardView parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gambarCardView = itemView.findViewById(R.id.gambarCardView);
            namaFakultasCardView = itemView.findViewById(R.id.namaFakultasCardView);
            namaOrganisasiCardView = itemView.findViewById(R.id.namaOrganisasiCardView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            btnlike = itemView.findViewById(R.id.btn_set_like);
        }
    }
}