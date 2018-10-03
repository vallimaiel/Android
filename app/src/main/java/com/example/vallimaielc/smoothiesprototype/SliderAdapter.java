package com.example.vallimaielc.smoothiesprototype;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ImageView slideImgView;
    TextView slideHeading,slideDescription;



    public SliderAdapter(Context context)
    {
        this.context=context;

    }
    public int[] slide_images= {
            R.drawable.discoversmoothies,
            R.drawable.chooserecepie,
            R.drawable.nextdaydelivery

            };
    public String[] slide_headings={
            "Discover smoothies",
            "Choose recipe",
            "Next day delivery"
    };
    public String[] slide_description={
            "Discover thousands of tasty smoothies for any drink enthusiast",
            "Choose your favorite smoothie and see full details on the recipe and preparation",
            "Order all your favorite smoothie ingredients in one click,Next day delivery guareented"
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(RelativeLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);
        slideImgView =(ImageView) view.findViewById(R.id.slide_imgview);
        slideHeading =(TextView) view.findViewById(R.id.slideheading);
        slideDescription =(TextView) view.findViewById(R.id.slidedescription);
        slideImgView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_description[position]);
        container.addView(view);
        return view;
    }
    public void destroyItem(ViewGroup container,int position,Object object)
    {
        container.removeView((RelativeLayout)object);
    }
}
