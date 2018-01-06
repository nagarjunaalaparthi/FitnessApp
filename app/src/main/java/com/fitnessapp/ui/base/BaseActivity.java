package com.fitnessapp.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.fitnessapp.R;
import com.fitnessapp.navigation.NavListAdapter;
import com.fitnessapp.ui.trainers.TrainersFragment;

import java.util.ArrayList;

/**
 * Created by venkatanarayana on 1/6/18.
 */

public class BaseActivity extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    RecyclerView navListRecycler;
    NavListAdapter navListAdapter;
    ArrayList<String> navItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        initNavItems();
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        LinearLayoutManager navListManager = new LinearLayoutManager(this);
        navListRecycler = (RecyclerView) findViewById(R.id.navigation_drawer_recycler_list);
        navListRecycler.setLayoutManager(navListManager);
        navListAdapter = new NavListAdapter(this, navItems);
        navListRecycler.setAdapter(navListAdapter);

        setContentView(new TrainersFragment());

    }


    protected void initNavItems() {
        navItems = new ArrayList<>();
        navItems.add("Goals");
        navItems.add("Events Nearby");
        navItems.add("Trainers Nearby");
    }

    public void setContentView(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
