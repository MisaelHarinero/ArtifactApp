package com.example.missi.pruebainterfaz;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        private ArrayList<Carta>cartas;
        private MainActivity mainActivity;
    public static class  MyViewHolder extends  RecyclerView.ViewHolder{
        private ImageButton button;

        public MyViewHolder(View view) {
            super(view);
            this.button = view.findViewById(R.id.cardAvatar);
        }


    }

    public MyAdapter(ArrayList<Carta> cartas, MainActivity mainActivity) {
        this.cartas = cartas;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_layaout,viewGroup,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

            myViewHolder.button.setImageResource(this.cartas.get(i).getId_img());
            myViewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mainActivity.cargarFrament(cartas.get(i));
                }
            });

    }



    @Override
    public int getItemCount() {
        return cartas.size();
    }
}
