package com.example.sunset.sojeoncalander;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import static android.R.attr.firstDayOfWeek;
import static android.R.attr.onClick;
import static android.R.attr.start;
import static com.example.sunset.sojeoncalander.R.layout.activity_calender;
import static com.example.sunset.sojeoncalander.R.layout.activity_main;
import static com.example.sunset.sojeoncalander.R.styleable.ButtonBarLayout;
import static com.example.sunset.sojeoncalander.R.styleable.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton gobtn = (ImageButton)findViewById(R.id.go);

        gobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, calender.class);
                startActivity(intent);
            }
        });


    }


}
