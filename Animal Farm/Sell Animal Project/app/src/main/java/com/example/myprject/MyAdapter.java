package com.example.myprject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    ArrayList<Animal> animals;
     Context context;
    public MyAdapter(ArrayList<Animal> animals, Context context) {

        this.animals = animals;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewdesign,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(animals.get(position).getName());
        holder.phone.setText(animals.get(position).getPhone());
        holder.animaltype.setText(animals.get(position).getAnimaltype());
        holder.location.setText(animals.get(position).getLocation());
        holder.askingprice.setText(animals.get(position).getAskingprice());
        Glide.with(context)
                .load(animals.get(position).image)
                .centerCrop()
                .placeholder(R.drawable.dfimage)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,phone,animaltype,location, askingprice;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            phone=itemView.findViewById(R.id.phone);
            animaltype=itemView.findViewById(R.id.animaltype);
            location=itemView.findViewById(R.id.location);
            askingprice=itemView.findViewById(R.id.askingprice);
            image=itemView.findViewById(R.id.image);
        }
    }
}
