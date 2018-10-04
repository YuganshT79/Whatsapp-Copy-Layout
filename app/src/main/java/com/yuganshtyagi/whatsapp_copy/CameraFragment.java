package com.yuganshtyagi.whatsapp_copy;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.otaliastudios.cameraview.CameraView;
import com.yuganshtyagi.whatsapp_copy.R;

import java.io.IOException;

/**
 * Created by Yugansh Tyagi on 3/21/2018.
 */

public class CameraFragment extends Fragment {

    CameraView cameraView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.camera_fragment_layout,null,false);

        int height = getArguments().getInt("appBarHeight");

        cameraView = view.findViewById(R.id.camera_view_tool);
        cameraView.setPadding(0,-height,0,0);
        cameraView.setLifecycleOwner(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        cameraView.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        cameraView.stop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cameraView.destroy();
    }

}
