package com.example.abhishekaryan.phpapp1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import static com.example.abhishekaryan.phpapp1.ListViewDisplay.DATA_FROM_JSON;

public class Register extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private EditText password;
    private EditText contact;
    private EditText country;
    private Button submit;
    private Button getData;
    private ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        name=(EditText)findViewById(R.id.register_activity_name);
        password=(EditText)findViewById(R.id.register_activity_password);
        contact=(EditText)findViewById(R.id.register_activity_conatct);
        country=(EditText)findViewById(R.id.register_activity_country);
        submit=(Button) findViewById(R.id.register_activity_submit);
        getData=(Button) findViewById(R.id.register_activity_getData);
        progressBar=(ProgressBar)findViewById(R.id.register_activity_progressbar);
        progressBar.setVisibility(View.GONE);

        submit.setOnClickListener(this);
        getData.setOnClickListener(this);
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    @Override
    public void onClick(View view) {

       String nameText=name.getText().toString();
       String passwordText=password.getText().toString();
       String contactText=contact.getText().toString();
       String countryText=country.getText().toString();
        if(view.getId()==R.id.register_activity_submit) {
            String method = "Register";
            if (AppStatus.getInstance(this).isOnline()) {

                //Toast.makeText(this,"You are online!!!!",Toast.LENGTH_SHORT).show();
                BackgroundTask backgroundTask = new BackgroundTask(this,progressBar);
                backgroundTask.execute(method, nameText, passwordText, contactText, countryText);

            } else {

                Toast.makeText(this,"You are offline!!!!",Toast.LENGTH_SHORT).show();
                Log.v("Home", "############################You are not online!!!!");
            }


        }

        if(view.getId()==R.id.register_activity_getData) {
            String method = "getData";
            if (AppStatus.getInstance(this).isOnline()) {

                //Toast.makeText(this,"You are online!!!!",Toast.LENGTH_SHORT).show();
                BackgroundTask backgroundTask = new BackgroundTask(this,progressBar);
                backgroundTask.execute(method);

            } else {

                Toast.makeText(this,"You are offline!!!!",Toast.LENGTH_SHORT).show();
                Log.v("Home", "############################You are not online!!!!");
            }

            //Toast.makeText(getApplication(),"GetData clicked",Toast.LENGTH_SHORT).show();
        }


    }

                public static void getFectchedData(Context context,String data){


                    Intent intent=new Intent(context,ListViewDisplay.class);
                    intent.putExtra(DATA_FROM_JSON,data);
                    context.startActivity(intent);

                }

}

