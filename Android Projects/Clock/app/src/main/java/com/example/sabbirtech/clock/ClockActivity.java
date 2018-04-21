package com.example.sabbirtech.clock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClockActivity extends AppCompatActivity {
        private Button Calender_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_clock);
        Calender_btn = (Button) findViewById(R.id.Calender_btn);

        Calender_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent click = new Intent(ClockActivity.this, DateActivity.class);
                startActivity(click);
            }
        });





    }
}
