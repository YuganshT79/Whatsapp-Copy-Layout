package com.yuganshtyagi.whatsapp_copy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yuganshtyagi.whatsapp_copy.R;

/**
 * Created by Yugansh Tyagi on 3/25/2018.
 */

public class StatusAdapter extends RecyclerView.Adapter {

    Context context;

    public StatusAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.status_item_layout,
                parent,
                false);
        return new StatusHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Glide.with(context).load(R.drawable.unknown).into(((StatusHolder)holder).statusImage);
        ((StatusHolder) holder).userName.setText("John Doe");
        ((StatusHolder) holder).statusTime.setText("9 minute age");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class StatusHolder extends RecyclerView.ViewHolder{

        ImageView statusImage;
        TextView userName,statusTime;

        public StatusHolder(View itemView) {
            super(itemView);
            statusImage = itemView.findViewById(R.id.status_image);
            userName = itemView.findViewById(R.id.user_name);
            statusTime = itemView.findViewById(R.id.status_time);
        }
    }
}
