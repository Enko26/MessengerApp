package com.example.messengerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class DAdapter extends RecyclerView.Adapter<DVholder> {
List<String> items;

    public DAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public DVholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        return new DVholder(view).LinkAdapter(this);
    }

    @Override
    public void onBindViewHolder(@NonNull DVholder holder, int position) {
         holder.textView.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

class DVholder extends RecyclerView.ViewHolder{
TextView textView;
private DAdapter adapter;

    public DVholder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.text);
        itemView.findViewById(R.id.deletebtn).setOnClickListener(view ->{
         adapter.items.remove(getAdapterPosition());
         adapter.notifyItemRemoved(getAdapterPosition());
        } );

    }
    public DVholder LinkAdapter(DAdapter adapter){
        this.adapter=adapter;
        return this;
    }
}
