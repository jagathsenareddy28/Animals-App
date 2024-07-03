package com.maid.animalsapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AnimalInfo extends AppCompatActivity {
    ImageView img;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animal_info);
        img=findViewById(R.id.imgCircled);
        txt=findViewById(R.id.animal);
        Intent intent=getIntent();
        img.setImageResource(intent.getIntExtra("image",R.drawable.ic_launcher_foreground));
        txt.setText(intent.getStringExtra("name"));
    }
}