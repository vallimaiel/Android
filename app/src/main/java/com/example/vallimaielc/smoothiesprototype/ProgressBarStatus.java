package com.example.vallimaielc.smoothiesprototype;

import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ProgressBarStatus extends Animation {
    android.widget.ProgressBar progressBar;
    float from,to;
    Context context;

    public ProgressBarStatus(Context context, android.widget.ProgressBar progressBar, float from, float to)
    {
        this.context=context;
        this.progressBar = progressBar;
        this.from=from;
        this.to=to;

    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value= from +(to - from) * interpolatedTime;
        progressBar.setProgress((int)value);
        if(value == to)
        {

            Intent intent = new Intent(context, NavDrawer.class);
            intent.putExtra("DirectedPage","MyOrders");
            context.startActivity(intent);

        }
    }



}
