package com.example.abhishekaryan.phpapp1;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundTask extends AsyncTask<String,Void,String> {

    private Context context;
    private String json_string;
    private ProgressBar progressBar;
    private boolean requestTypeGet =false;
    private boolean requestTypePost =false;


    public BackgroundTask(Context context,ProgressBar progressBar) {
        this.context = context;
        this.progressBar=progressBar;

    }

    @Override
    protected String doInBackground(String... params) {

        String method=params[0];

        String registerUrl="https://abhishekaryan.000webhostapp.com/project/project/insert.php";
        String fetchUrl="https://abhishekaryan.000webhostapp.com/project/project/getData.php";
        String dataFetch;


        if(method.equals("Register")){

            String name=params[1];
            String password=params[2];
            String contact=params[3];
            String country=params[4];

            try {
                URL url=new URL(registerUrl);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

                String data= URLEncoder.encode("nameText","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("passwordText","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"+
                        URLEncoder.encode("contactText","UTF-8")+"="+URLEncoder.encode(contact,"UTF-8")+"&"+
                        URLEncoder.encode("countryText","UTF-8")+"="+URLEncoder.encode(country,"UTF-8");
                bufferedWriter.write(data);
                requestTypePost=true;
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream IS=httpURLConnection.getInputStream();
                IS.close();
                return "Registration Succesfull";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(method.equals("getData")){

//            Toast.makeText(context,"Inside getData block",Toast.LENGTH_SHORT).show();

            try {
                URL url=new URL(fetchUrl);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder=new StringBuilder();
                while ((json_string=bufferedReader.readLine())!=null) {

                    stringBuilder.append(json_string+"\n");
                }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    requestTypeGet =true;
                    dataFetch=stringBuilder.toString().trim();
                    //callJson(dataFetch);
                    return dataFetch;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }


    @Override
    protected void onPreExecute() {

        super.onPreExecute();
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onPostExecute(String result) {

        progressBar.setVisibility(View.GONE);

        if(requestTypePost) {
            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        }
        if(requestTypeGet){


            Register.getFectchedData(context,result);
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
