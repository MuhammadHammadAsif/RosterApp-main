package com.example.rosterapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView title= findViewById(R.id.detailTitle);
        TextView description= findViewById(R.id.detailDescription);
        ImageView img1=findViewById(R.id.image1);
        ImageView img2=findViewById(R.id.image2);


        String selectedUnit = getIntent().getStringExtra("UNIT_NAME");
        int position=getIntent().getIntExtra("UNIT_POSITION",0);

        String[] descriptions=getResources().getStringArray(R.array.rooster_descriptions);

        title.setText(selectedUnit);
        description.setText(descriptions[position]);

        String imgUrl1="https://picsum.photos/seed/"+selectedUnit+"1/400/300";
        String imgUrl2="https://picsum.photos/seed/"+selectedUnit+"2/400/300";

        Picasso.get().load(imgUrl1).into(img1);
        Picasso.get().load(imgUrl2).into(img2);

    }
}
