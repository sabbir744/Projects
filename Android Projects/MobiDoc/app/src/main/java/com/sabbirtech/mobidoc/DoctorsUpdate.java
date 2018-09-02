package com.sabbirtech.mobidoc;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sabbirtech.mobidoc.helper.DatabaseHelper;

public class DoctorsUpdate extends AppCompatActivity {
    EditText mid,mname,mdetails,mappointmrnt,mphone,memail;
    Button mupdate;
    DatabaseHelper helper;
    DatabaseHelper databaseHelper;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.adddoctor)
        {
            Intent intent = new Intent(DoctorsUpdate.this,ProfileActivity.class);
            startActivity(intent);

        }
        if(id == R.id.viewdoctor)
        {
            Intent intent = new Intent(DoctorsUpdate.this,DoctorsInfo.class);
            startActivity(intent);
        }
        if(id == R.id.updatedoctor)
        {

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
        setContentView(R.layout.activity_doctors_update);

        databaseHelper = new DatabaseHelper(this);

        mid = findViewById(R.id.id);
        mname = findViewById(R.id.nameid);
        mdetails = findViewById(R.id.detailsid);
        mappointmrnt = findViewById(R.id.appointmentid);
        mphone = findViewById(R.id.phoneid);
        memail = findViewById(R.id.emailid);
        mupdate = findViewById(R.id.updateid);

        mupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isupdate = databaseHelper.updateinfo(mid.getText().toString(),mname.getText().toString(),mdetails.getText().toString(),mappointmrnt.getText().toString(),mphone.getText().toString(),memail.getText().toString());
                if(isupdate == true)
                {
                    Toast.makeText(DoctorsUpdate.this, "Updated!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(DoctorsUpdate.this, "Data Not Updated!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
