package com.example.abhishekaryan.phpapp1;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListViewDisplay extends AppCompatActivity {

    public static final String DATA_FROM_JSON="DATA_FROM_JSON";
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    private String name,password,contact,country;
    private DataAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_items);
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.list_view_item_recylerView);
        DataAdapter adapter=new DataAdapter(this);


        String data=getIntent().getExtras().getString(DATA_FROM_JSON);
        //Toast.makeText(this,"You are good to go abhishek" + data,Toast.LENGTH_SHORT).show();
        try {
            jsonObject=new JSONObject(data);
            jsonArray=jsonObject.getJSONArray("ServerResponse");
            int count=0;
            while(count<jsonArray.length()){

                JSONObject object=jsonArray.getJSONObject(count);
                name=object.getString("Name");
                password=object.getString("Password");
                contact=object.getString("Conatct");
                country=object.getString("Country");

                adapter.AddDataToList(new DataBaseDto(name,password,contact,country));
                adapter.notifyDataSetChanged();

                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
