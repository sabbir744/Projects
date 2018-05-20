package com.example.sabbirtech.saomtimetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeTable extends AppCompatActivity {
        TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        textView = (TextView)findViewById(R.id.datetext);

        Calendar c  = Calendar.getInstance();
        c.getTime();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        String s1 = s.format(c.getTime());
        textView.setText(s1);





    }
}
