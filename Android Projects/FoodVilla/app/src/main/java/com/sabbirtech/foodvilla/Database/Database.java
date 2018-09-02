package com.sabbirtech.foodvilla.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
import com.sabbirtech.foodvilla.Model.order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SABBIR TECH on 15-Aug-18.
 */

public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME = "foodvilla.db";
    private static final int DB_VER = 1;

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    public List<order> getCarts() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlselect = {"ProductId", "ProductName", "Quantity", "Price", "Discount"};
        String sqltable = "OrderDetail";
        qb.setTables(sqltable);
        Cursor cursor = qb.query(db, sqlselect, null, null, null, null, null);
        final List<order> result = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                result.add(new order(cursor.getString(cursor.getColumnIndex("ProductId")),
                        cursor.getString(cursor.getColumnIndex("ProductName")),
                        cursor.getString(cursor.getColumnIndex("Quantity")),
                        cursor.getString(cursor.getColumnIndex("Price")),
                        cursor.getString(cursor.getColumnIndex("Discount"))));
            } while (cursor.moveToNext());
        }
        return result;

    }

    public void addToCart(order order) {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT INTO OrderDetail(ProductId,ProductName,Quantity,Price,Discount) VALUES('%s','%s','%s','%s','%s');",
                order.getProductId(),
                order.getProductNamne(),

                order.getQuantity(),
                order.getPrice(),
                order.getDiscount());
        db.execSQL(query);
        db.close();
    }

    public void cleanCart() {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM OrderDetail");
        db.execSQL(query);
    }
}




