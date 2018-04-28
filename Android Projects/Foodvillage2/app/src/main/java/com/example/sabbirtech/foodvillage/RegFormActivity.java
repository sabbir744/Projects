package com.example.sabbirtech.foodvillage;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class RegFormActivity extends AppCompatActivity {

    private Button Submit;
    private EditText nametext;
    private EditText emailtext;
    private  EditText password;
    private EditText phonenumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_form);




        submittext();
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if(validate())
               {
                String email = emailtext.getText().toString().trim();
                String pass = password.getText().toString().trim();

                   Toast.makeText(RegFormActivity.this,"Submit Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(RegFormActivity.this,LoginActivity.class);
                    startActivity(intent);



               }
               else {
                   //Toast.makeText(RegFormActivity.this,"Submit  not Successfully",Toast.LENGTH_SHORT).show();
               }






            }
        });










    }

    private Boolean validate() {
        Boolean result = false;
        String name = nametext.getText().toString();
        String email = emailtext.getText().toString();
        String pass = password.getText().toString();
        String phone = phonenumber.getText().toString();

        if(name.isEmpty() && email.isEmpty() && pass.isEmpty() && phone.isEmpty())
        {
            Toast.makeText(RegFormActivity.this,"Please fill all fields",Toast.LENGTH_SHORT).show();
        }
        else
        {
            return result;
        }
        return result;

    }

    private void submittext() {

        Submit = (Button) findViewById(R.id.Submit_btn);
        nametext = (EditText) findViewById(R.id.NameText);
        emailtext = (EditText) findViewById(R.id.EmailText);
        password = (EditText) findViewById(R.id.PassWord);
        phonenumber = (EditText) findViewById(R.id.PhoneText);
    }
}
