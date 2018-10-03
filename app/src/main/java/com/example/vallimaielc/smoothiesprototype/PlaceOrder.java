package com.example.vallimaielc.smoothiesprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class PlaceOrder  extends AppCompatActivity{
    ListView checkableList,garnishList,drinkwareList;
    Button Add,Sub;
    String heading;
    android.support.v7.widget.Toolbar toolB1;
    TextView Result,orderTotal;
    int servings,ans,total,total_result=50,result,serveCount;
    String orderItems="";
    ArrayList<String> checkedItems = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_order);
        toolB1=findViewById(R.id.tool_b1);
        Intent intent = getIntent();
        heading =intent.getStringExtra("header");
        setSupportActionBar(toolB1);
        getSupportActionBar().setTitle(heading);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        orderTotal=(TextView)findViewById(R.id.order_total);
        checkableList = (ListView) findViewById(R.id.checkable_list);
        garnishList = (ListView) findViewById(R.id.garnish_list);
        drinkwareList = (ListView) findViewById(R.id.drinkware_list);

        checkableList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        drinkwareList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        garnishList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        String [] items ={"1/2 banana","2 large strawberries","1/4 cup of blueberries","1/2 cup coconut milk",};
        String [] garnish={"Mint leaves"};
        String [] drinkware={"Long glass and straw"};

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.row_layout,R.id.txt,items);
        checkableList.setAdapter(adapter);
        ArrayAdapter<String> adapter1= new ArrayAdapter<String>(this,R.layout.row_layout,R.id.txt,garnish);
        garnishList.setAdapter(adapter1);
        ArrayAdapter<String> adapter2= new ArrayAdapter<String>(this,R.layout.row_layout,R.id.txt,drinkware);
        drinkwareList.setAdapter(adapter2);


        checkableList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem =((TextView)view).getText().toString();
                if(checkedItems.contains(selectedItem))
                {
                    checkedItems.remove(selectedItem);
                }
                else
                {
                    checkedItems.add(selectedItem);
                }


            }
        });
        garnishList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemgarnish =((TextView)view).getText().toString();
                if(checkedItems.contains(selectedItemgarnish))
                {
                    checkedItems.remove(selectedItemgarnish);
                }
                else
                {
                    checkedItems.add(selectedItemgarnish);
                }


            }
        });
        drinkwareList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemdrinkware =((TextView)view).getText().toString();
                if(checkedItems.contains(selectedItemdrinkware))
                {
                    checkedItems.remove(selectedItemdrinkware);
                }
                else
                {
                    checkedItems.add(selectedItemdrinkware);
                }


            }
        });

        Add= (Button) findViewById(R.id.add);
        Sub= (Button) findViewById(R.id.sub);
        Result=findViewById(R.id.result);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              servings=Integer.parseInt(Result.getText().toString());
              ans=servings+10;
              if (ans <= 50) {
                  Result.setText(String.valueOf(ans));
              }
              else
              {
                  ans=50;
                  Result.setText(String.valueOf(ans));
                  servings=10;
              }
              result=Integer.parseInt(Result.getText().toString());
              total_result=50*(result/10);
              orderTotal.setText(String.valueOf(total_result));

            }
        });
        Sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                servings=Integer.parseInt(Result.getText().toString());
                ans=servings-10;
                if (ans >= 10) {
                    Result.setText(String.valueOf(ans));
                }
                else
                {
                    ans=10;
                    Result.setText(String.valueOf(ans));
                    servings=50;
                }
                result=Integer.parseInt(Result.getText().toString());
                total_result=50*(result/10);
                orderTotal.setText(String.valueOf(total_result));



            }
        });


    }
   public void nextActivity(View view)
   {
       serveCount=Integer.parseInt(Result.getText().toString());
       Intent intent = new Intent(this,ConfirmOrder.class);
       Bundle extras = new Bundle();
       extras.putStringArrayList("Item Details",checkedItems);
       extras.putInt("Total",total_result);
       extras.putString("Smoothie",heading);
       extras.putInt("Servings",serveCount);
       intent.putExtras(extras);
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
