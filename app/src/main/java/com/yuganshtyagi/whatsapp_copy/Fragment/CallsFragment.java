package com.yuganshtyagi.whatsapp_copy.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuganshtyagi.whatsapp_copy.Adapter.CallsAdapter;
import com.yuganshtyagi.whatsapp_copy.R;
import com.yuganshtyagi.whatsapp_copy.Utils.SeparatorDecoration;

/**
 * Created by Yugansh Tyagi on 3/21/2018.
 */

public class CallsFragment extends Fragment {

    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.calls_fragment_layout, null, false);

        SeparatorDecoration decoration = new SeparatorDecoration(
                getContext(),
                Color.parseColor("#EAEAEA"),
                0.5f);

        recyclerView = view.findViewById(R.id.calls_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CallsAdapter(getContext()));
        recyclerView.addItemDecoration(decoration);

        return view;
    }
}
