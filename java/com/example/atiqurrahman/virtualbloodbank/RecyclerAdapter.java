package com.example.atiqurrahman.virtualbloodbank;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AtiqurRahman on 4/14/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

   ArrayList<contact> arrayList=new ArrayList<>();
    public RecyclerAdapter(ArrayList<contact> arrayList){
    this.arrayList=arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(arrayList.get(position).getName());
        holder.blood.setText(arrayList.get(position).getBlod());
        holder.cell.setText(arrayList.get(position).getCell());
        holder.location.setText(arrayList.get(position).getLocation());



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name,blood,cell,location;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.name);
            blood=(TextView)itemView.findViewById(R.id.blood);
            cell=(TextView)itemView.findViewById(R.id.cell);
            location=(TextView)itemView.findViewById(R.id.location);

        }
    }
}
