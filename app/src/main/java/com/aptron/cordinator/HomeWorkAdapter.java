package com.aptron.cordinator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeWorkAdapter extends RecyclerView.Adapter {

    ArrayList<Model> list_data;
    Context mContext;

    public HomeWorkAdapter(ArrayList<Model> list_data, Context mContext) {
        this.list_data = list_data;
        this.mContext = mContext;
    }

    public  class TextTypeViewHolder extends RecyclerView.ViewHolder {

        TextView txtType, subject_text, date_text;
        ImageView profile_image;


        public TextTypeViewHolder(View itemView) {
            super(itemView);

            this.txtType = itemView.findViewById(R.id.text_data);
            subject_text = itemView.findViewById(R.id.sub_text);
            profile_image = itemView.findViewById(R.id.image_profile);
            date_text = itemView.findViewById(R.id.date_of_post);


        }
    }

    public  class ImageTypeViewHolder extends RecyclerView.ViewHolder {

        TextView txtType, subject_text, date_text;
        ImageView profile_image, data_image;

        public ImageTypeViewHolder(View itemView) {

            super(itemView);

            txtType = itemView.findViewById(R.id.main_text_image);
            data_image = itemView.findViewById(R.id.main_image_image);
            subject_text = itemView.findViewById(R.id.subject_text_image);
            date_text = itemView.findViewById(R.id.date_of_post_image);
            profile_image = itemView.findViewById(R.id.image_profile_image);


        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Model.TEXT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_type_homework, parent, false);
                return new TextTypeViewHolder(view);
            case Model.IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_type_homework, parent, false);
                return new ImageTypeViewHolder(view);

        }
        return null;
    }
    @Override
    public int getItemViewType(int position) {

        switch (list_data.get(position).type) {
            case 0:
                return Model.TEXT_TYPE;
            case 1:
                return Model.IMAGE_TYPE;

            default:
                return -1;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Model object = list_data.get(position);
        if (object != null) {
            switch (object.type) {
                case Model.TEXT_TYPE:
                    ((TextTypeViewHolder) holder).txtType.setText(object.text);
                    ((TextTypeViewHolder) holder).date_text.setText(object.date_text);
                    ((TextTypeViewHolder) holder).subject_text.setText(object.subject);
                    ((TextTypeViewHolder) holder).profile_image.setImageResource(object.sub_image);

                    break;
                case Model.IMAGE_TYPE:
                    ((ImageTypeViewHolder) holder).txtType.setText(object.text);
                    ((ImageTypeViewHolder) holder).data_image.setImageResource(object.image);
                    ((ImageTypeViewHolder) holder).profile_image.setImageResource(object.sub_image);
                    ((ImageTypeViewHolder) holder).date_text.setText(object.date_text);
                    ((ImageTypeViewHolder) holder).subject_text.setText(object.subject);

                    break;
            }
        }
    }

            @Override
            public int getItemCount () {
                return list_data.size();
            }


        }


