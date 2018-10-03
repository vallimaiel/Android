package com.example.vallimaielc.smoothiesprototype;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

import static com.example.vallimaielc.smoothiesprototype.R.*;

public class NavDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,Smoothies.myInterface{
    DrawerLayout drawerLayout;
    NavigationView navView;
    android.support.v7.widget.Toolbar toolBar;
    ActionBarDrawerToggle mToggle;
    static int pos;
    TextView phone;
    TextView vName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.nav_drawer);
        toolBar=findViewById(R.id.tool_bar);
        navView=findViewById(R.id.nav_view);
        setSupportActionBar(toolBar);
        drawerLayout=(DrawerLayout)findViewById(id.drawer_layout);
        navView.setNavigationItemSelectedListener(this);
        View header=navView.getHeaderView(0);
        phone= (TextView)header.findViewById(id.user_phone);
        phone.setText(SignIn.mobileno);
        vName=findViewById(R.id.v_name);
        vName.setText("Version number"+"  "+BuildConfig.VERSION_NAME);
        Intent intent =getIntent();
        String navigation =intent.getStringExtra("DirectedPage");
        if(navigation == null)
        {
            mToggle=new ActionBarDrawerToggle(this,drawerLayout,toolBar, string.open, string.close);
            mToggle.getDrawerArrowDrawable().setColor(getResources().getColor(color.colorTransparentWhite));
            drawerLayout.addDrawerListener(mToggle);
            mToggle.syncState();
            if(savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction().replace(id.fragement_container, new Smoothies()).commit();
                navView.setCheckedItem(id.smoothie_details);
            }

        }
        else
        {
            getSupportFragmentManager().beginTransaction().replace(id.fragement_container, new MyOrders()).commit();
            navView.setCheckedItem(R.id.my_orders);
            mToggle=new ActionBarDrawerToggle(this,drawerLayout,toolBar, string.open, string.close);
            mToggle.getDrawerArrowDrawable().setColor(getResources().getColor(color.colorTransparentWhite));
            drawerLayout.addDrawerListener(mToggle);
            mToggle.syncState();
        }


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch(menuItem.getItemId())
        {
            case id.smoothie_details:
                getSupportFragmentManager().beginTransaction().replace(id.fragement_container,new Smoothies()).commit();
                getSupportActionBar().setTitle("Smoothie");
                break;
            case id.my_orders:
                getSupportFragmentManager().beginTransaction().replace(id.fragement_container,new MyOrders()).commit();
                getSupportActionBar().setTitle("My Orders");
                break;
            case id.sign_out:


                Intent intent = new Intent(this,SignIn.class);
                startActivity(intent);
                Log.d("sign in phone",SignIn.phone);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void data(int value) {
        pos=value;
    }
}
