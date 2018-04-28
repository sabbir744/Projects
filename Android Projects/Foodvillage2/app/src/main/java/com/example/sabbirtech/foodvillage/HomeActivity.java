package com.example.sabbirtech.foodvillage;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {
        private ImageButton imageButton1;
        private ImageButton imageButton2;
        private ImageButton imageButton3;
        private ImageButton imageButton4;
         private ImageButton imageButton5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageButton1 = (ImageButton) findViewById(R.id.image1_btn);
        imageButton2 = (ImageButton) findViewById(R.id.image2_btn);
        imageButton3 = (ImageButton) findViewById(R.id.image3_btn);
        imageButton4 = (ImageButton) findViewById(R.id.image4_btn);
        imageButton5 = (ImageButton) findViewById(R.id.image5_btn);


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,OrderActivity.class);

                startActivity(intent);

            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,OrderActivity.class);

                startActivity(intent);
            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,OrderActivity.class);
                startActivity(intent);
            }
        });



    }
}
