package com.yuganshtyagi.whatsapp_copy;

import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    Toolbar toolbar;
    AppBarLayout appBarLayout;
    FloatingActionButton actionButton;


    //Fragment Objects
    CameraFragment cameraFragment;
    ChatsFragment chatsFragment;
    StatusFragment statusFragment;
    CallsFragment callsFragment;

    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));

        getWindow().setNavigationBarColor(getResources().getColor(android.R.color.black));

        viewPager = findViewById(R.id.mainViewPager);
        tabLayout = findViewById(R.id.tab_layout);
        appBarLayout = findViewById(R.id.app_bar);
        actionButton = findViewById(R.id.fab);

        viewPager.setAdapter(new MainAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(1,true);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //Code to implement AppBar transition acc. to Viewpager
                if(position == 0)
                    appBarLayout.setTranslationY(appBarLayout.getHeight()*(positionOffset) - appBarLayout.getHeight());
            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0){
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                            WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    actionButton.setVisibility(View.GONE);
                }else if(flag) {
//                    translateDown();
                    actionButton.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout.setupWithViewPager(viewPager);
        setupTabLayout();

    }



    private void setupTabLayout(){
        LinearLayout layout = ((LinearLayout) ((LinearLayout) tabLayout.getChildAt(0)).getChildAt(0));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) layout.getLayoutParams();
        layoutParams.weight = 0.4f;
        layout.setLayoutParams(layoutParams);
        tabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.ic_camera));
    }

//    private void translateDown(){
//        Animation up = new TranslateAnimation(0,0,-280,0);
//        appBarLayout.setAnimation(up);
//        up.setDuration(150);
//        up.setFillAfter(true);
//        up.start();
//        flag = false;
//        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private class MainAdapter extends FragmentStatePagerAdapter {

        public MainAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                if(cameraFragment == null){
                    cameraFragment = new CameraFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("appBarHeight",appBarLayout.getHeight());
                    cameraFragment.setArguments(bundle);
                    return  cameraFragment;
                }
                return cameraFragment;
            }
            if(position == 1){
                if(chatsFragment == null){
                    chatsFragment = new ChatsFragment();
                    return  chatsFragment;
                }
                return chatsFragment;
            }
            if(position == 2){
                if(statusFragment == null){
                    statusFragment = new StatusFragment();
                    return  statusFragment;
                }
                return statusFragment;
            }
            if(position == 3){
                if(callsFragment == null){
                    callsFragment = new CallsFragment();
                    return  callsFragment;
                }
                return callsFragment;
            }
            return null;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0)
                return "";
            if(position == 1)
                return getResources().getString(R.string.chats_text);
            if(position == 2)
                return getResources().getString(R.string.status_text);
            if(position == 3)
                return getResources().getString(R.string.calls_text);
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }

}
