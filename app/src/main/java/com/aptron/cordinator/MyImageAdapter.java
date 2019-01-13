package com.aptron.cordinator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyImageAdapter extends RecyclerView.Adapter<MyImageAdapter.MyViewHolder>
{

    Context context;
    private RecyclerViewClickListener mListener;
     String[] title;
     int[] img;

    public MyImageAdapter(Context context, String[] title, RecyclerViewClickListener mListener, int[] img) {
        this.context = context;
        this.title = title;
        this.mListener = mListener;
        this.img = img;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.myxml,parent,false);
        return new MyViewHolder(view ,mListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textView.setText(title[position]);
        holder.imageView.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {

        return img.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private RecyclerViewClickListener recyclerViewClickListener;
         ImageView imageView;
         TextView textView;
        public MyViewHolder(View itemView,RecyclerViewClickListener listener) {
            super(itemView);
           recyclerViewClickListener = listener;
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

                recyclerViewClickListener.onClick(v,getAdapterPosition());

        }
    }

}
