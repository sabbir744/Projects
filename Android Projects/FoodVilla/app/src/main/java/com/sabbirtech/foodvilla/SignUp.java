package com.sabbirtech.foodvilla;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.sabbirtech.foodvilla.Model.User;

public class SignUp extends AppCompatActivity {

    MaterialEditText edtname,edtphone,edtpass;
    Button msignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtname = findViewById(R.id.edtname);
        edtphone = findViewById(R.id.edtphone);
        edtpass = findViewById(R.id.edtpass);
        msignup = findViewById(R.id.btnsignupp);


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference("user");

        msignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog dialog = new ProgressDialog(SignUp.this);
                dialog.setMessage("Please Wait!!");
                dialog.show();

                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                      if(dataSnapshot.child(edtphone.getText().toString()).exists())
                      {
                          dialog.dismiss();
                          Toast.makeText(SignUp.this, "Phone Number Already Registered!", Toast.LENGTH_SHORT).show();
                      }
                      else
                      {
                          dialog.dismiss();
                          Toast.makeText(SignUp.this, "Please Register!", Toast.LENGTH_SHORT).show();
                          User user = new User(edtname.getText().toString(),edtpass.getText().toString());
                          reference.child(edtphone.getText().toString()).setValue(user);
                          Toast.makeText(SignUp.this, "Sign Up Successfully!", Toast.LENGTH_SHORT).show();
                          finish();
                      }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



    }
}
