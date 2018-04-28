package com.example.sabbirtech.foodvillage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {

    private EditText Emailtext;
    private EditText Passtext;
    private TextView Regtext;
    private Button Loginbtn;
    private TextView Signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        Regtext = (TextView) findViewById(R.id.Reg_text);
        Emailtext = (EditText) findViewById(R.id.Email_text);
        Passtext = (EditText) findViewById(R.id.Pass_text);
        Loginbtn = (Button) findViewById(R.id.LogIn_btn);
        Signin = (TextView) findViewById(R.id.sign_in);





        Loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(RegActivity.this,HomeActivity.class);
                startActivity(intent);




            }
        });

            Regtext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(RegActivity.this,RegFormActivity.class);
                    startActivity(intent);
                }
            });





    }
}
