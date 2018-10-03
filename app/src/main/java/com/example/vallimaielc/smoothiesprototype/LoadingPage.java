package com.example.vallimaielc.smoothiesprototype;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class LoadingPage extends AppCompatActivity
{
    ProgressBar progressBar;

    int from,to;
    NewUsers obj = new NewUsers(this);
    static int flag=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        progressBar=(ProgressBar) findViewById(R.id.progress_bar);
        progressBar.setMax(100);
        progressBar.setScaleY(3f);
        from=0;
        to=100;
        progress();

    }
    public void progress()
    {
        ProgressBarStatus obj = new ProgressBarStatus(this,progressBar,from,to);
        obj.setDuration(3000);
        progressBar.setAnimation(obj);

    }



}
