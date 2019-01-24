package com.example.atiqurrahman.virtualbloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button search,register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        search=(Button)findViewById(R.id.search);
        register=(Button)findViewById(R.id.registre);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Search.class);
                startActivity(i);
            }
        });

    }
    public void onRegister(View view){
        Intent j = new Intent(MainActivity.this, Register.class);
        startActivity(j);
    }
}
