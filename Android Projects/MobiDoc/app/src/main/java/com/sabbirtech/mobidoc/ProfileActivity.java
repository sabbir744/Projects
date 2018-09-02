package com.sabbirtech.mobidoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.sabbirtech.mobidoc.helper.DatabaseHelper;

public class ProfileActivity extends AppCompatActivity {

     EditText mname,mdetails,mappointmrnt,mphone,memail;
     Button msave;
    DatabaseHelper helper;



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.adddoctor)
        {


        }
        if(id == R.id.viewdoctor)
        {
            Intent intent = new Intent(ProfileActivity.this,DoctorsInfo.class);
            startActivity(intent);
        }
        if(id == R.id.updatedoctor)
        {
            Intent intent = new Intent(ProfileActivity.this,DoctorsUpdate.class);
            startActivity(intent);
        }
        if(id == R.id.addmedical)
        {
            Intent intent = new Intent(ProfileActivity.this,DoctorPrescription.class);
            startActivity(intent);
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
        setContentView(R.layout.activity_profile);

        helper = new DatabaseHelper(this);

        mname = findViewById(R.id.nameid);
        mdetails = findViewById(R.id.detailsid);
        mappointmrnt = findViewById(R.id.appointmentid);
        mphone = findViewById(R.id.phoneid);
        memail = findViewById(R.id.emailid);
        msave = findViewById(R.id.saveid);

        msave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isinserted = helper.adduser(mname.getText().toString(), mdetails.getText().toString(), mappointmrnt.getText().toString(), mphone.getText().toString(), memail.getText().toString());
                if (isinserted == true) {
                    Toast.makeText(ProfileActivity.this, "saved", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(ProfileActivity.this, "not Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }




}
