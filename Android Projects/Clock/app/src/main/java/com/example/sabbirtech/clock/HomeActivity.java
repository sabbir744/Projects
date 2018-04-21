package com.example.sabbirtech.clock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomeActivity extends AppCompatActivity {
    private Button Show_clk_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Show_clk_btn = (Button) findViewById(R.id.show_clk_btn);


        Show_clk_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent click = new Intent(HomeActivity.this,ClockActivity.class);
                startActivity(click);
            }

        });





    }
}
