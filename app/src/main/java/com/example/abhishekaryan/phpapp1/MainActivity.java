package com.example.abhishekaryan.phpapp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.activity_main_reg_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id=v.getId();
                if(id==R.id.activity_main_reg_btn){

                    Intent intent=new Intent(MainActivity.this,Register.class);
                    startActivity(intent);
                }
            }
        });
    }
}
