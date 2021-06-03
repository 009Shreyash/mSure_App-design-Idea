package com.example.admin.msure.Adapter;

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

/**
 * Created by Admin on 30-01-2018.
 */

public class OtherserviceAdapter extends RecyclerView.Adapter<OtherserviceAdapter.MyViewHolder>
{
    private ArrayList<DataModel> dataSet;

    public OtherserviceAdapter(ArrayList<DataModel> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.otherservice_layout, parent, false);

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
        ImageView imageViewIcon;
        public MyViewHolder(final View itemView) {
            super(itemView);

            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.img_item);
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
