package com.sabbirtech.foodvilla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sabbirtech.foodvilla.Interface.ItemClickListener;
import com.sabbirtech.foodvilla.ViewHolder.FoodViewHolder;
import com.squareup.picasso.Picasso;

public class Food extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    String categoryId = "";

    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseRecyclerAdapter<com.sabbirtech.foodvilla.Model.Food,FoodViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);


        //firebase

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Foods");


        recyclerView = findViewById(R.id.food_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //getintent

        if(getIntent() != null)
        {
            categoryId = getIntent().getStringExtra("CategoryId");

        }
        if(!categoryId.isEmpty() && categoryId != null)
        {
            loadFood(categoryId);
        }

    }

    private void loadFood(String categoryId) {

        adapter = new FirebaseRecyclerAdapter<com.sabbirtech.foodvilla.Model.Food, FoodViewHolder>(com.sabbirtech.foodvilla.Model.Food.class,R.layout.food_item,FoodViewHolder.class,reference.orderByChild("MenuId").equalTo(categoryId)) {
            @Override
            protected void populateViewHolder(FoodViewHolder viewHolder, com.sabbirtech.foodvilla.Model.Food model, int position) {
              viewHolder.foodname.setText(model.getName());
                Picasso.with(getBaseContext()).load(model.getImage())
                        .into(viewHolder.food_image);
                final com.sabbirtech.foodvilla.Model.Food local = model;
                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {

                        Intent fooddetails = new Intent(Food.this,FoodDetails.class);
                        fooddetails.putExtra("FoodId",adapter.getRef(position).getKey());
                        startActivity(fooddetails);
                    }
                });
            }
        };
        Log.d("TAG",""+adapter.getItemCount());
        recyclerView.setAdapter(adapter);
    }
}
