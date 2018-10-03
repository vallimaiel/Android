package com.example.vallimaielc.smoothiesprototype;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
   CardView proceedButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        proceedButton = (CardView)findViewById(R.id.proceed_button);
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }
    public void openActivity()
    {
        Intent intent = new Intent(this, Activity1.class);
        startActivity(intent);
    }
}
