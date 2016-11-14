package com.example.sunset.sojeoncalander;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class calender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        ImageButton plusbtn = (ImageButton)findViewById(R.id.plusbtn);

        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(calender.this, AddActivity.class);
                startActivity(intent);
            }
        });

    }
}
