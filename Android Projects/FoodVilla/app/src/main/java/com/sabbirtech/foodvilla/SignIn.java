package com.sabbirtech.foodvilla;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.sabbirtech.foodvilla.Common.Common;
import com.sabbirtech.foodvilla.Model.User;

public class SignIn extends AppCompatActivity {

    private EditText mphoneno,mpass;
    private Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        mphoneno = (MaterialEditText) findViewById(R.id.edtphone);
        mpass = (MaterialEditText)findViewById(R.id.edtpass);
        signin = (Button) findViewById(R.id.btnsigninn);

        //firebase config


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference("user");

        signin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                final ProgressDialog dialog = new ProgressDialog(SignIn.this);
                dialog.setMessage("Please Wait!!");
                dialog.show();
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.child(mphoneno.getText().toString()).exists()) {
                            dialog.dismiss();
                            User user = dataSnapshot.child(mphoneno.getText().toString()).getValue(User.class);
                            user.setPhone(mphoneno.getText().toString());
                            if (user.getPassword().equals(mpass.getText().toString())) {
                                Toast.makeText(SignIn.this, "Sign In successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignIn.this,Home.class);
                                Common.currentuser = user;
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(SignIn.this, "Sign In Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(SignIn.this, "User Doesn't Exist", Toast.LENGTH_SHORT).show();
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
