package com.sabbirtech.foodvilla.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sabbirtech.foodvilla.Interface.ItemClickListener;
import com.sabbirtech.foodvilla.R;

/**
 * Created by SABBIR TECH on 14-Aug-18.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtmenuname;
    public ImageView imageView;

    private ItemClickListener itemClickListener;


    public MenuViewHolder(View itemView) {
        super(itemView);

        txtmenuname = itemView.findViewById(R.id.menu_item);
        imageView = itemView.findViewById(R.id.images);


        itemView.setOnClickListener(this);




    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }
}
