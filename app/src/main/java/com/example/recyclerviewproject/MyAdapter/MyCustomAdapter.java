package com.example.recyclerviewproject.MyAdapter;


import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewproject.MyInterface.MyClickInterface;
import com.example.recyclerviewproject.R;

import java.util.ArrayList;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyViewHolder> {

    ArrayList<String> shayariList;
    Context context;
    MyClickInterface myClickInterface1;

    public MyCustomAdapter(ArrayList<String> shayariList, MyClickInterface myClickInterface1) {
        this.shayariList = shayariList;
        this.myClickInterface1 = myClickInterface1;
    }

    @NonNull
    @Override
    public MyCustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.myitem, parent, false);
        MyCustomAdapter.MyViewHolder viewHolder = new MyCustomAdapter.MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyCustomAdapter.MyViewHolder holder, int position) {
        holder.txtshayari.setText(shayariList.get(position));

        holder.txtshare.setOnClickListener(v ->
        {
                myClickInterface1.ClickShare(shayariList.get(position),position);
        });

        holder.txtcopy.setOnClickListener(v ->
        {
            myClickInterface1.ClickCopy(shayariList.get(position),position);

        });
        holder.txtedit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                myClickInterface1.ClickEdit(shayariList.get(position),position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shayariList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtshayari;
        ImageButton txtshare, txtcopy, txtedit;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtshayari = itemView.findViewById(R.id.txtshayari);
            txtshare = itemView.findViewById(R.id.txtshare);
            txtcopy = itemView.findViewById(R.id.txtcopy);
            txtedit = itemView.findViewById(R.id.txtedit);
        }
    }
}
