package com.yuganshtyagi.whatsapp_copy.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yuganshtyagi.whatsapp_copy.R;

/**
 * Created by Yugansh Tyagi on 3/22/2018.
 */

public class CallsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    public CallsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.call_item_layout,
                parent,false);

        return new ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ChatHolder) holder).callerName.setText("Someone");
        ((ChatHolder) holder).callTime.setText("Yesterday, 7:14 PM");
        Glide.with(context).load(R.drawable.unknown).into(((ChatHolder) holder).callerImage);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    private class ChatHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView callerImage,callType;
        TextView callerName, callTime;

        public ChatHolder(View itemView) {
            super(itemView);
            callerImage = itemView.findViewById(R.id.caller_image);
            callType = itemView.findViewById(R.id.call_type);
            callerName = itemView.findViewById(R.id.caller_name);
            callTime = itemView.findViewById(R.id.call_time);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
