package com.sabbirtech.foodvilla.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sabbirtech.foodvilla.Interface.ItemClickListener;
import com.sabbirtech.foodvilla.R;

/**
 * Created by SABBIR TECH on 15-Aug-18.
 */

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

   public TextView foodname;
   public  ImageView food_image;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public FoodViewHolder(View itemView) {
        super(itemView);

        foodname = itemView.findViewById(R.id.food_item);
        food_image = itemView.findViewById(R.id.foodimages);


        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
