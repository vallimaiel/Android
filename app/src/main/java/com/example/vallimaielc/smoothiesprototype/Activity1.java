package com.example.vallimaielc.smoothiesprototype;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Activity1 extends Activity {

   SliderAdapter sliderAdapter;
   ViewPager slideViewPager;
   LinearLayout dotLayout;
   TextView[] mDot;
   Button continueButton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        slideViewPager=findViewById(R.id.slide_viewpager);
        dotLayout=findViewById(R.id.dot_layout);
        continueButton=findViewById(R.id.continue_button);
        sliderAdapter=new SliderAdapter(this);
        slideViewPager.setAdapter(sliderAdapter);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });
        addDotsIndicator(0);
        slideViewPager.addOnPageChangeListener(viewListener);
    }
    public void addDotsIndicator(int position)
    {
        mDot = new TextView[3];
        dotLayout.removeAllViews();
        for(int i=0;i<mDot.length;i++)
        {
            mDot[i]=new TextView(this);
            mDot[i].setText(Html.fromHtml(("&#8226;")));
            mDot[i].setTextSize(50);
            mDot[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            dotLayout.addView(mDot[i]);

        }
       if(mDot.length>0)
       {
           mDot[position].setTextColor(getResources().getColor(R.color.colorTeal));
       }
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
          addDotsIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
    public void openActivity1()
    {
        Intent intent = new Intent(this,SignIn.class);
        startActivity(intent);
    }

}
