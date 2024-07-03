package com.maid.animalsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AnimalAdapter  extends RecyclerView.Adapter<AnimalAdapter.AnimalRowHolder>{
    ArrayList<Animal> animalData;

    Context context;
    myClickInterface myClickInterface;

    public AnimalAdapter(ArrayList<Animal> animalData, Context context ,myClickInterface myClickInterface) {
        this.animalData = animalData;
        this.context = context;
        this.myClickInterface=myClickInterface;
    }

    @NonNull
    @Override
    public AnimalRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.animal_row,parent,false);
        return new AnimalRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalRowHolder holder, int position) {
        holder.txt_animal_name.setText(animalData.get(position).getName());
        holder.img_animal.setImageResource(animalData.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return animalData.size();
    }

    class AnimalRowHolder extends  RecyclerView.ViewHolder{
        //textview=typeof view in viewHolder txt_animal=referring with text id;
        TextView txt_animal_name;
        ImageView img_animal;

        public AnimalRowHolder(@NonNull View itemView) {
            super(itemView);
            txt_animal_name=itemView.findViewById(R.id.txtAnimal_name);
            img_animal=itemView.findViewById(R.id.img_animal);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myClickInterface.OnItemClick(getAdapterPosition());

                }
            });

        }
    }
    interface myClickInterface{
        void OnItemClick(int postionOfTheAnimal);
    }
}











