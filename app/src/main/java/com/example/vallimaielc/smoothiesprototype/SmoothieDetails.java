package com.example.vallimaielc.smoothiesprototype;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SmoothieDetails extends AppCompatActivity implements Ingredients.OnFragmentInteractionListener,Preparation.OnFragmentInteractionListener {
    TabLayout tabLayout;
    Toolbar toolB;
    TextView smoothieHeading;
    ImageView smoothieImg;
    ViewPager pager;
    Button orderButton;
    String title;
    int currentpage;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smoothie_details);
        toolB=(Toolbar) findViewById(R.id.tool_b);
        setSupportActionBar(toolB);
        smoothieImg=(ImageView) findViewById(R.id.smoothie_img);
        smoothieHeading=(TextView) findViewById(R.id.smoothie_heading);
        currentpage=NavDrawer.pos;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(currentpage==1)
        {
          smoothieImg.setImageResource(R.drawable.smoothie_green);
          title="Green Fruit";
          smoothieHeading.setText(title);
          getSupportActionBar().setTitle(title);

        }
        else if(currentpage==2)
        {
            smoothieImg.setImageResource(R.drawable.smoothie_peach);
            title="Peach Fruit";
            smoothieHeading.setText(title);
            getSupportActionBar().setTitle(title);
        }
        else
        {
            smoothieImg.setImageResource(R.drawable.smoothie_redfruit);
            title="Red Fruit";
            smoothieHeading.setText(title);
            getSupportActionBar().setTitle(title);
        }
        orderButton=findViewById(R.id.order_button);
        tabLayout=findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Ingredients"));
        tabLayout.addTab(tabLayout.newTab().setText("Preparation"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        pager=findViewById(R.id.pager);
        PagerAdapterDetails adapter = new PagerAdapterDetails(getSupportFragmentManager(),tabLayout.getTabCount());
        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    public void openActivity()
    {
        Intent intent = new Intent(this,PlaceOrder.class);
        intent.putExtra("header",title);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
