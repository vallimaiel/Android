package com.example.vallimaielc.smoothiesprototype;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapterVertical extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ImageView slideImgView;
    TextView slideHeading,slideDescription,seeDetails;



    public SliderAdapterVertical(Context context)
    {
        this.context=context;

    }
    public int[] slide_images= {
            R.drawable.smoothie_redfruit,
            R.drawable.smoothie_green,
            R.drawable.smoothie_peach

    };
    public String[] slide_headings={
            "Red Fruit",
            "Green",
            "Peach"
    };
    public String[] slide_description={
            "smoothie",
            "smoothie",
            "smoothie"
    };




    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(RelativeLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.vertical_slide_layout,container,false);
        slideImgView =(ImageView) view.findViewById(R.id.slide_img_vertical);
        slideHeading =(TextView) view.findViewById(R.id.smoothie_heading);
        slideDescription =(TextView) view.findViewById(R.id.smoothie);
        seeDetails=view.findViewById(R.id.see_details);
        seeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(),SmoothieDetails.class);
                    context.startActivity(intent);

            }
        });

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

