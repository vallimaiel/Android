package com.example.vallimaielc.smoothiesprototype;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import me.kaelaela.verticalviewpager.VerticalViewPager;

public class MyOrders extends Fragment {
   Orders_slider slider;

    TextView[] mDot;
   ViewPager viewPagerOrders;
    static ArrayList<String> orders;
    static ArrayList<String> serve;
    static ArrayList<String> total;
    NewUsers obj;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.orders_viewpager, container, false);
        viewPagerOrders = view.findViewById(R.id.slide_viewpager_orders);
        obj = new NewUsers(getContext());
        orders = new ArrayList<>();
        total = new ArrayList<>();
        serve = new ArrayList<>();
        populateList();
        Log.d("countlllll",String.valueOf(orders.size()));
        if(orders.size()==0)
        {
            Toast.makeText(getContext(),"No orders yet",Toast.LENGTH_SHORT).show();
        }
        slider = new Orders_slider(view.getContext(), orders, serve, total);
        viewPagerOrders.addOnPageChangeListener(viewListener);
        viewPagerOrders.setAdapter(slider);
        return view;
    }


    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
    public void populateList()
    {
        Cursor data = obj.getData();
        while(data.moveToNext())
        {
            orders.add(data.getString(2));
            serve.add(data.getString(3));
            total.add(data.getString(4));

        }


    }

}

