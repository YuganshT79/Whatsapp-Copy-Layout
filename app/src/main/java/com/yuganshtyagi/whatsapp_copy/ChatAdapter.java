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

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Yugansh Tyagi on 3/22/2018.
 */

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Integer> pics;
    private ArrayList<String> names;
    private ArrayList<String> texts;

    ChatAdapter(Context context) {
        this.context = context;
        pics = Utils.getAvengerImages();
        names = Utils.getAvengerNames();
        texts = Utils.getAvengerTexts();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item_layout,
                parent,false);

        return new ChatHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((ChatHolder) holder).userName.setText(names.get(position));
        ((ChatHolder) holder).unreadCnt.setText("7");
        ((ChatHolder) holder).latestTime.setText("Yesterday");
        ((ChatHolder) holder).latestMessage.setText(texts.get(position));
        Glide.with(context).load(pics.get(position)).into(((ChatHolder) holder).userImage);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    private class ChatHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView userImage;
        TextView userName,latestMessage,latestTime,unreadCnt;

        public ChatHolder(View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.user_image);
            latestMessage = itemView.findViewById(R.id.latest_message);
            userName = itemView.findViewById(R.id.my_status);
            latestTime = itemView.findViewById(R.id.latest_time);
            unreadCnt = itemView.findViewById(R.id.unread_messages);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
