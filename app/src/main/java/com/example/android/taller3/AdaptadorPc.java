package com.example.android.taller3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by android on 28/05/2018.
 */

public class AdaptadorPc extends RecyclerView.Adapter<AdaptadorPc.PcViewHolder> {
    private ArrayList<pc> pcs;
    private OnPcClickListener clickListener;

    public AdaptadorPc(ArrayList<pc> pcs, OnPcClickListener clickListener){
        this.pcs=pcs;
        this.clickListener = clickListener;
    }

    @Override
    public PcViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_pc,parent,false);
        return new PcViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PcViewHolder holder, int position) {
        final pc p = pcs.get(position);
        holder.foto.setImageResource(p.getFoto());
        holder.marca.setText(p.getMarca());
        holder.ram.setText(p.getRam());
        holder.color.setText(p.getColor());
        holder.tipo.setText(p.getTipo());
        holder.so.setText(p.getSo());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onPcClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pcs.size();
    }

    public static class PcViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView marca;
        private TextView ram;
        private TextView color;
        private TextView tipo;
        private TextView so;
        private View v;

        public PcViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            marca = v.findViewById(R.id.lblMarca);
            ram = v.findViewById(R.id.lblRam);
            color = v.findViewById(R.id.lblColor);
            tipo = v.findViewById(R.id.lblTipo);
            so = v.findViewById(R.id.lblSistemaOperativo);
        }

    }

    public interface OnPcClickListener{
        void onPcClick(pc p);
    }
}
