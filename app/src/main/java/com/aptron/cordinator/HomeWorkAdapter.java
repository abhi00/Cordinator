package com.aptron.cordinator;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class HomeWorkAdapter {


    public static class TextTypeViewHolder extends RecyclerView.ViewHolder {

        TextView txtType;


        public TextTypeViewHolder(View itemView) {
            super(itemView);

            this.txtType = itemView.findViewById(R.id.text);


        }
    }
}
