package com.example.vallimaielc.smoothiesprototype;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.kaelaela.verticalviewpager.VerticalViewPager;
import me.kaelaela.verticalviewpager.transforms.DefaultTransformer;

public class Smoothies extends Fragment{
    SliderAdapterVertical sliderAdaptervertical;
    VerticalViewPager verticalViewpager;
    int position;
    myInterface m;
    interface myInterface
    {
        void data(int value);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.smoothies,container,false);
        verticalViewpager=(VerticalViewPager) view.findViewById(R.id.vertical_viewpager);
        sliderAdaptervertical=new SliderAdapterVertical(view.getContext());
        verticalViewpager.setAdapter(sliderAdaptervertical);
        verticalViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                position=i;
                m.data(position);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        return view;

    }

@Override
public void onAttach(Context context) {

    super.onAttach(context);
    if(context instanceof myInterface)
        m=(myInterface) context;
}
  @Override
   public void onDetach() {

        super.onDetach();
        m=null;
    }




}
