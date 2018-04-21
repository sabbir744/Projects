package com.example.sabbirtech.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button One_btn;
    private Button Two_btn;
    private Button Three_btn;
    private Button Four_btn;
    private Button Five_btn;
    private Button Six_btn;
    private Button Seven_btn;
    private Button Eight_btn;
    private Button Nine_btn;
    private Button Zero_btn;
    private Button Add_btn;
    private Button Sub_btn;
    private Button Multiply_btn;
    private Button Division_btn;
    private Button Equal_btn;
    private Button Clr_btn;
    private EditText editText;

    boolean addition,subtraction,division,multiplication;
   private float m;
   private float n;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = (EditText) findViewById(R.id.editText);
        One_btn = (Button) findViewById(R.id.one_btn);
        Two_btn = (Button) findViewById(R.id.two_btn);
        Three_btn= (Button) findViewById(R.id.three_btn);
        Four_btn = (Button) findViewById(R.id.four_btn);
        Five_btn= (Button) findViewById(R.id.five_btn);
        Six_btn= (Button) findViewById(R.id.six_btn);
        Seven_btn = (Button) findViewById(R.id.seven_btn);
        Eight_btn= (Button) findViewById(R.id.eight_btn);
        Nine_btn= (Button) findViewById(R.id.nine_btn);
        Zero_btn = (Button) findViewById(R.id.zero_btn);
        Add_btn = (Button) findViewById(R.id.add_btn);
        Sub_btn = (Button) findViewById(R.id.sub_btn);
        Multiply_btn = (Button) findViewById(R.id.multiply_btn);
        Division_btn = (Button) findViewById(R.id.division_btn);
        Equal_btn = (Button) findViewById(R.id.equal_btn);
        Clr_btn = (Button) findViewById(R.id.clr_btn);


        One_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editText.setText(editText.getText()+"1");



            }
        });



        Two_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"2");
            }
        });


        Three_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"3");
            }
        });


        Four_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"4");
            }
        });


        Five_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"5");
            }
        });


        Six_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"6");
            }
        });


        Seven_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"7");
            }
        });


        Eight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"8");
            }
        });


        Nine_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"9");
            }
        });


        Zero_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText(editText.getText()+"0");
            }
        });


        Add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText == null)
                {
                    editText.setText("");
                }
                else
                {
                    m = Float.parseFloat(editText.getText()+"");
                    addition = true;
                    editText.setText(null);

                }
            }
        });


        Sub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText == null)
                {
                    editText.setText("");
                }
                else 
                {
                     m = Float.parseFloat(editText.getText()+"");
                     subtraction = true;
                    editText.setText(null);
                    
                }
           }
        });


        Multiply_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (editText == null)
                    {
                        editText.setText(" ");
                    }
                    else 
                    {
                         m = Float.parseFloat(editText.getText()+ "");
                         multiplication = true;
                        editText.setText(null);
                    }
            }
        });


        Division_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText == null)
                {
                    editText.setText("");
                }
                else 
                {
                     m = Float.parseFloat(editText.getText()+"");
                     division = true;
                    editText.setText(null);
                }
            }
        });


        Equal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 n = Float.parseFloat(editText.getText()+"");


                if ( addition == true)
                {

                    editText.setText(m+n +"");
                    addition = false;
                }
                 if (subtraction == true)
                {
                    editText.setText((m-n+""));
                    subtraction = false;

                }
                 if (multiplication == true)
                {
                    editText.setText(m*n+"");
                    multiplication = false;
                }
                 if (division == true)
                {
                    editText.setText(m/n + "");
                    division = false;
                }

            }
        });

        Clr_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.setText("");

            }
        });






    }
}
