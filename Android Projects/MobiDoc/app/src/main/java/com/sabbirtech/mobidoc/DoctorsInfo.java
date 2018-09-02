package com.sabbirtech.mobidoc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.sabbirtech.mobidoc.helper.DatabaseHelper;

public class DoctorsInfo extends AppCompatActivity {
    private TextView index,nname,ndetails,nappointment,nphone,nemail;
    DatabaseHelper helper;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.adddoctor)
        {
            Intent intent = new Intent(DoctorsInfo.this,ProfileActivity.class);
            startActivity(intent);

        }
        if(id == R.id.viewdoctor)
        {

        }
        if(id == R.id.updatedoctor)
        {
            Intent intent = new Intent(DoctorsInfo.this,DoctorsUpdate.class);
            startActivity(intent);
        }
        if(id == R.id.addmedical)
        {

        }
        if(id == R.id.viewmedical)
        {

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_info);

        helper = new DatabaseHelper(this);

        helper = new DatabaseHelper(this);
        index = findViewById(R.id.indexid);


        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = (Cursor) helper.getinfo();

        StringBuffer buffer = new StringBuffer();
        if(cursor.getCount() == 0)
        {

        }
        else {


            while (cursor.moveToNext()) {
                index.setText(buffer.append("Id: " + cursor.getString(0) + "\n"));
                index.setText(buffer.append("Name: " + cursor.getString(1)+ "\n"));
                index.setText(buffer.append("Details: " + cursor.getString(2)+ "\n"));
                index.setText(buffer.append("Appointment: " + cursor.getString(3)+ "\n"));
                index.setText(buffer.append("Phone: " + cursor.getString(4)+ "\n"));
                index.setText(buffer.append("Email: " + cursor.getString(5)+ "\n\n\n"));


            }
        }
    }
}
