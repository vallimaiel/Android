package com.example.vallimaielc.smoothiesprototype;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecylerViewHolder> {
    List<String> smoothie ;
    List <Integer> smoothieimg;
    static InterfaceRecycler pg;
    interface InterfaceRecycler
    {
        void data(int value);
    }
    public  RecyclerAdapter()
    {
        smoothie = new ArrayList<String>();
        smoothieimg=new ArrayList<Integer>();
        smoothie.add("Red Fruit");
        smoothie.add("Green Fruit");
        smoothie.add("Peach Fruit");
        smoothieimg.add(R.drawable.smoothie_redfruit);
        smoothieimg.add(R.drawable.smoothie_green);
        smoothieimg.add(R.drawable.smoothie_peach);

    }
    @NonNull
    @Override
    public RecylerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_itemslist,viewGroup,false);
        RecylerViewHolder r = new RecylerViewHolder(view);
        return r;
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerViewHolder recylerViewHolder, int i) {
        RecylerViewHolder recylerViewHolder1=(RecylerViewHolder)recylerViewHolder;
        recylerViewHolder1.smoothieName.setText(smoothie.get(i));
        recylerViewHolder1.smoothieImg.setImageResource(smoothieimg.get(i));

    }


    @Override
    public int getItemCount() {
        return smoothie.size();
    }
    public static class RecylerViewHolder extends RecyclerView.ViewHolder
    {
        TextView smoothieName;
        ImageView smoothieImg;
        public RecylerViewHolder(@NonNull View itemView) {
            super(itemView);
            smoothieName=itemView.findViewById(R.id.smoothie_name);
            smoothieImg=itemView.findViewById(R.id.smoothie_img);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RecyclerAdapter.pg.data(getAdapterPosition());
                    Intent i = new Intent(v.getContext(),SmoothieDetails.class);
                    v.getContext().startActivity(i);


                }
            });

        }
    }
}
