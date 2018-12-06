package com.example.abhishekaryan.phpapp1;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolderClass extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView password;
    private TextView contact;
    private TextView country;

    public ViewHolderClass(View itemView) {
        super(itemView);

        name=(TextView)itemView.findViewById(R.id.recyler_view_layout_name);
        password=(TextView)itemView.findViewById(R.id.recyler_view_layout_password);
        contact=(TextView)itemView.findViewById(R.id.recyler_view_layout_contact);
        country=(TextView)itemView.findViewById(R.id.recyler_view_layout_country);

    }
    public void populate(DataBaseDto dataBaseDto){

        name.setText(dataBaseDto.getName());
        password.setText(dataBaseDto.getPassword());
        contact.setText(dataBaseDto.getContact());
        country.setText(dataBaseDto.getCountry());
    }
}
