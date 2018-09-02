package com.sabbirtech.foodvilla.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.sabbirtech.foodvilla.Interface.ItemClickListener;
import com.sabbirtech.foodvilla.Model.order;
import com.sabbirtech.foodvilla.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by SABBIR TECH on 16-Aug-18.
 */
class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView cart_item_name,cart_item_price;
    public ImageView img_cart_count;

    private ItemClickListener itemClickListener;

    public void setCart_item_name(TextView cart_item_name) {
        this.cart_item_name = cart_item_name;
    }

    public CartViewHolder(View itemView) {
        super(itemView);

        cart_item_name = itemView.findViewById(R.id.cart_item_food);
        cart_item_price = itemView.findViewById(R.id.cart_item_price);
        img_cart_count = itemView.findViewById(R.id.cart_item_count);




    }

    @Override
    public void onClick(View view) {

    }
}

public class CartAdapter extends  RecyclerView.Adapter<CartViewHolder> {

    private List<order> listdata = new ArrayList<>();
    private  Context context;

    public CartAdapter(List<order> listdata, Context context) {
        this.listdata = listdata;
        this.context = context;
    }


    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemview = inflater.inflate(R.layout.cart_layout,parent,false);
        return  new CartViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {

        TextDrawable drawable = TextDrawable.builder()
                .buildRound(""+listdata.get(position).getQuantity(), Color.RED);

        holder.img_cart_count.setImageDrawable(drawable);

        Locale locale = new Locale("en","BD");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        int price = (Integer.parseInt(listdata.get(position).getPrice()))*(Integer.parseInt(listdata.get(position).getQuantity()));
        holder.cart_item_price.setText(fmt.format(price));

        holder.cart_item_name.setText(listdata.get(position).getProductNamne());
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }
}
