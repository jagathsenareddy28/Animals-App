package com.maid.animalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.myClickInterface {
    RecyclerView recyclerView;
    ArrayList<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the ArrayList
        animals = new ArrayList<>();

        // Add animals to the list
        animals.add(new Animal("Dolphin", R.drawable.d));
        animals.add(new Animal("Lion", R.drawable.l));
        animals.add(new Animal("Owl", R.drawable.o));
        animals.add(new Animal("Parrot", R.drawable.p));
        animals.add(new Animal("Rabbit", R.drawable.r));
        animals.add(new Animal("Turtle", R.drawable.t));
        animals.add(new Animal("Tiger", R.drawable.ti));
        animals.add(new Animal("Wolf", R.drawable.w));

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerView);

        // Initialize the adapter
        AnimalAdapter animalAdapter = new AnimalAdapter(animals, this,this);


        // Set the LayoutManager and Adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animalAdapter);
    }

    @Override
    public void OnItemClick(int postionOfTheAnimal) {
        Toast.makeText(this, "clicked"+animals.get(postionOfTheAnimal).getName(), Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,AnimalInfo.class);
        intent.putExtra("image",animals.get(postionOfTheAnimal).getImage());
        intent.putExtra("name",animals.get(postionOfTheAnimal).getName());
        startActivity(intent);
    }
}
