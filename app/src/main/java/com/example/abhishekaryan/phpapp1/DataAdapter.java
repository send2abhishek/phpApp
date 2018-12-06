package com.example.abhishekaryan.phpapp1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter {

    private ArrayList<DataBaseDto> datalist;
    private LayoutInflater inflater;
    private Context context;

    public DataAdapter(Context context) {
        this.context = context;
        datalist=new ArrayList<>();
        inflater=LayoutInflater.from(context);

    }

    public void AddDataToList(DataBaseDto dataBaseDto){

        datalist.add(dataBaseDto);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=inflater.inflate(R.layout.recyler_view_layout,parent,false);
        return new ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolderClass viewHolderClass=(ViewHolderClass)holder;
        viewHolderClass.populate(datalist.get(position));

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }
}
