package com.sabbirtech.foodvilla;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sabbirtech.foodvilla.Common.Common;
import com.sabbirtech.foodvilla.Database.Database;
import com.sabbirtech.foodvilla.Model.Request;
import com.sabbirtech.foodvilla.Model.order;
import com.sabbirtech.foodvilla.ViewHolder.CartAdapter;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Cart extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference reference;
    Database database1;

    TextView plcetxt,totalprice;
    Button btnplace;

    List<order> carts = new ArrayList<>();
    CartAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        //firebase set up

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Requests");


        recyclerView = findViewById(R.id.listcart);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        plcetxt = findViewById(R.id.totaltxt);
        totalprice = findViewById(R.id.total);
        btnplace = findViewById(R.id.btnplaceorder);


        btnplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showalerdlg();
            }
        });


        Loadlist();

    }

    private void showalerdlg() {
        AlertDialog.Builder alerdlg = new AlertDialog.Builder(Cart.this);
        alerdlg.setTitle("Next Step!");
        alerdlg.setMessage("Enter Your Address: ");

        final EditText editText = new EditText(Cart.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.MATCH_PARENT
        );

        editText.setLayoutParams(lp);
        alerdlg.setView(editText);

        alerdlg.setIcon(R.drawable.ic_shopping_cart);
        alerdlg.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Request request = new Request(Common.currentuser.getPhone(),
                        Common.currentuser.getName(),
                        editText.getText().toString(),
                        totalprice.getText().toString(),
                        carts
                );

                reference.child(String.valueOf(System.currentTimeMillis()))
                        .setValue(request);
                new Database(getBaseContext()).cleanCart();
                Toast.makeText(Cart.this, "Thank You, Order Place", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        alerdlg.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alerdlg.show();

    }

    private void Loadlist() {
        carts = new Database(this).getCarts();
       // carts = (List<order>) new Database(this).getCarts();
        adapter = new CartAdapter(carts,this);
        recyclerView.setAdapter(adapter);



        //calculation total price

        int total = 0;
        for(order order:carts)
            total+= (Integer.parseInt(order.getPrice()))*(Integer.parseInt(order.getQuantity()));
        Locale locale = new Locale("en","BD");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

        totalprice.setText(fmt.format(total));

    }
}
