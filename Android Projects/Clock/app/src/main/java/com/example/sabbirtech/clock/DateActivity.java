package com.example.sabbirtech.clock;

import android.app.Activity;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DateActivity extends AppCompatActivity {
    private Button App_exit_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        App_exit_btn = (Button) findViewById(R.id.App_exit_btn);

        App_exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // System.runFinalizersOnExit(true);
                //System.exit(0);
                finishAffinity();
            }
        });

    }
}
