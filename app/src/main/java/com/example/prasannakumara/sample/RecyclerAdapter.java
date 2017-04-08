package com.example.prasannakumara.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PrasannakumarA on 4/7/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    Context context;
    ArrayList<langModelClass> storeLangArray;

    public RecyclerAdapter(Context context, ArrayList<langModelClass> storeLangArray) {
        this.context = context;
        this.storeLangArray = storeLangArray;
    }


    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View itemView;
//            itemView= LayoutInflater.from(parent.getContext(),R.layout.list_view_item);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter.MyViewHolder holder, int position) {

        holder.textinItem.setText(storeLangArray.get(position).getLang());
        holder.heartRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.heartWhite.setVisibility(View.VISIBLE);
                holder.heartRed.setVisibility(View.INVISIBLE);

            }
        });

        holder.heartWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.heartWhite.setVisibility(View.INVISIBLE);
                holder.heartRed.setVisibility(View.VISIBLE);

            }
        });

    }

    @Override
    public int getItemCount() {
        return storeLangArray.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textinItem;
        ImageView heartWhite, heartRed;


        public MyViewHolder(View itemView) {
            super(itemView);
            textinItem = (TextView) itemView.findViewById(R.id.sample_text);
            heartRed = (ImageView) itemView.findViewById(R.id.heart_Red);
            heartWhite = (ImageView) itemView.findViewById(R.id.heart_White);


        }
    }
}