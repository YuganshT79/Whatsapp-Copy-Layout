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

import java.util.ArrayList;

public class GroupsAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<String> grpNames;
    private ArrayList<Integer> grpIcons;

    GroupsAdapter(Context context) {
        this.context = context;
        grpNames = Utils.getGroupNames();
        grpIcons = Utils.getGroupIcons();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.group_item_layout,
                parent,false);

        return new GroupsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ((GroupsHolder)holder).grpName.setText(grpNames.get(position));
        Glide.with(context)
                .load(grpIcons.get(position))
                .into(((GroupsHolder)holder).grpImage);
    }

    @Override
    public int getItemCount() {
        return 8;
    }

    private class GroupsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView grpImage;
        TextView grpName;

        GroupsHolder(View itemView) {
            super(itemView);
            grpImage = itemView.findViewById(R.id.group_image);
            grpName = itemView.findViewById(R.id.group_name);
        }

        @Override
        public void onClick(View v) {
            //TODO : implement onClick of Group
        }
    }
}
