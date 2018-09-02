package com.sabbirtech.foodvilla;

import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sabbirtech.foodvilla.Database.Database;
import com.sabbirtech.foodvilla.Model.*;
import com.sabbirtech.foodvilla.Model.Food;
import com.squareup.picasso.Picasso;

public class FoodDetails extends AppCompatActivity {


    TextView food_name,food_price,food_description;
    ImageView food_image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ElegantNumberButton numberButton;
    FloatingActionButton floatingActionButton;

    com.sabbirtech.foodvilla.Model.Food currentfood;

    String foodId = "";
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);


        //Firebase Setup....... :p

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Foods");

        numberButton = findViewById(R.id.order_count);
        floatingActionButton = findViewById(R.id.btncart);


        food_description = findViewById(R.id.food_des);
        food_price = findViewById(R.id.food_price);
        food_name = findViewById(R.id.food_name);

        food_image = findViewById(R.id.img_food);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Database(getBaseContext()).addToCart(new order(
                        foodId,
                        currentfood.getName(),

                        numberButton.getNumber(),
                        currentfood.getPrice(),
                        currentfood.getDescription()
                ));

                Toast.makeText(FoodDetails.this, "Added to the Cart!!", Toast.LENGTH_SHORT).show();
            }
        });


        collapsingToolbarLayout = findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapseAppbar);



        //get food id from intent

        if(getIntent() != null)
        {
            foodId = getIntent().getStringExtra("FoodId");

        }
        if(!foodId.isEmpty())
        {
            getDetailsFood(foodId);
        }
    }

    private void getDetailsFood(String foodid) {
        reference.child(foodid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               currentfood = dataSnapshot.getValue(Food.class);
                Picasso.with(getBaseContext()).load(currentfood.getImage())
                        .into(food_image);
                collapsingToolbarLayout.setTitle(currentfood.getName());
                food_price.setText(currentfood.getPrice());
                food_name.setText(currentfood.getName());

                food_description.setText(currentfood.getDescription());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
