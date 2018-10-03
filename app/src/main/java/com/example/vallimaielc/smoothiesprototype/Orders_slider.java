package com.example.vallimaielc.smoothiesprototype;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Orders_slider extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
   ImageView slideImgView;
   String img;
   Button locationButton;
     TextView orderedSmoothie,servingsNo,orderedTotal;
     ArrayList<String> orders;
     ArrayList<String> serve;
     ArrayList<String> total;
    public Orders_slider(Context context,ArrayList<String> a,ArrayList<String> b,ArrayList<String> c)
    {
        this.context=context;
        orders = new ArrayList<>();
        total = new ArrayList<>();
        serve = new ArrayList<>();
        for(String x:a)
            orders.add(x);
        for(String y:b)
            serve.add(y);
        for(String z:c)
            total.add(z);


    }
   public int[] slide_images= {
            R.drawable.smoothie_redfruit,
            R.drawable.smoothie_green,
            R.drawable.smoothie_peach

    };



    @Override
    public int getCount() {
        //Log.d("countlllll",String.valueOf(orders.size()));
       return orders.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(LinearLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.orders_layout,container,false);
        orderedSmoothie=view.findViewById(R.id.ordered_smoothie);
        orderedTotal=view.findViewById(R.id.ordered_total);
        servingsNo=view.findViewById(R.id.servings_no);
        slideImgView =(ImageView) view.findViewById(R.id.slide_imgview_orders);
            orderedSmoothie.setText(orders.get(position));
            orderedTotal.setText(total.get(position));
            servingsNo.setText(serve.get(position));
            img = orderedSmoothie.getText().toString();
            if (img.equals("Red Fruit")) {
                slideImgView.setImageResource(slide_images[0]);
            } else if (img.equals("Green Fruit")) {
                slideImgView.setImageResource(slide_images[1]);
            } else {
                slideImgView.setImageResource(slide_images[2]);
            }

        container.addView(view);
        return view;
    }
    public void destroyItem(ViewGroup container,int position,Object object)
    {
        container.removeView((LinearLayout)object);
    }


}