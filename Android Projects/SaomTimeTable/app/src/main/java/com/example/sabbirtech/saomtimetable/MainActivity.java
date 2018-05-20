package com.example.sabbirtech.saomtimetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
        ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread= new Thread() {

            @Override
            public void run() {
                try
                {
                    Thread.sleep(3000);

                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(MainActivity.this,TimeTable.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();














    }
}
