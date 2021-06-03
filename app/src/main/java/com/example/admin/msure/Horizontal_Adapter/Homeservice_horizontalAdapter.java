package com.example.admin.msure.Horizontal_Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.msure.Activity.BookServiceActivity;
import com.example.admin.msure.Model.DataModel;
import com.example.admin.msure.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Admin on 30-01-2018.
 */

public class Homeservice_horizontalAdapter extends RecyclerView.Adapter<Homeservice_horizontalAdapter.MyViewHolder>
{
    private ArrayList<DataModel> dataSet;

    public Homeservice_horizontalAdapter(ArrayList<DataModel> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homeservice_layout_horizontal, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextView textViewName = holder.textViewName;
        ImageView imageViewicon = holder.imageViewIcon;

        imageViewicon.setImageResource(dataSet.get(position).getImage());
        textViewName.setText(dataSet.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewName;
        CircleImageView imageViewIcon;
        public MyViewHolder(final View itemView) {
            super(itemView);


            this.imageViewIcon = itemView.findViewById(R.id.img_item);
            this.textViewName = (TextView) itemView.findViewById(R.id.txt_name);
            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent= new Intent(itemView.getContext(),BookServiceActivity.class);
                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }
}
