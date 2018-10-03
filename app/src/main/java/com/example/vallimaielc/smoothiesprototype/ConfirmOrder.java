package com.example.vallimaielc.smoothiesprototype;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ConfirmOrder extends AppCompatActivity {
    ListView orderList;
    Button confirmOrder,locRequest;
    String smoothieName,phoneUser;
    TextView smoothieHeading,total;
    int amt,serves;
    Toolbar toolbarOrders;
    Button b;
    TextView addressInfo;
    Geocoder geocoder;
    LocationManager locationManager;
    LocationListener listener;
    double lat,lon;
    NewUsers obj;
    String addresses,city,country,postalcode,area,fullAddress;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_order);
        smoothieHeading=(TextView) findViewById(R.id.smoothie_heading);
        b = (Button) findViewById(R.id.loc_request);
        addressInfo=(TextView) findViewById(R.id.address_info);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        phoneUser=SignIn.mobileno;
        confirmOrder=(Button) findViewById(R.id.confirm_order);
        orderList = (ListView) findViewById(R.id.order_list);
        toolbarOrders=(Toolbar) findViewById(R.id.toolbar_orders);
        total=(TextView) findViewById(R.id.total);
        setSupportActionBar(toolbarOrders);
        getSupportActionBar().setTitle("Confirm Order");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        obj = new NewUsers(this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        ArrayList<String> orderItem = extras.getStringArrayList("Item Details");
        amt = extras.getInt("Total");
        serves = extras.getInt("Servings");
        smoothieName=extras.getString("Smoothie");
        smoothieHeading.setText(smoothieName + "  *  " + serves +"  servings ");
        total.setText(String.valueOf(amt));
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.orders_rowlayout, R.id.orders, orderItem);
        orderList.setAdapter(adapter);
        confirmOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                lat=location.getLatitude();
                lon=location.getLongitude();
                // Log.d("hyyy", String.valueOf(lat));
                try {
                    List<Address> loc ;
                    geocoder=new Geocoder(getApplicationContext(), Locale.getDefault());

                    loc = geocoder.getFromLocation(lat,lon,1);
                    Log.d("latitude ",String.valueOf(lat));
                    addresses=loc.get(0).getAddressLine(0);
                    area=loc.get(0).getLocality();
                    city=loc.get(0).getAdminArea();
                    country=loc.get(0).getCountryName();
                    postalcode=loc.get(0).getPostalCode();
                    fullAddress=addresses + " ," + area + ","+city +","+country+","+postalcode;
                    addressInfo.setText(fullAddress);


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

                Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(i);
            }
        };
        configure_button();



    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 10:
                configure_button();
                break;
            default:
                break;
        }
    }

    void configure_button(){

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.INTERNET}
                        ,10);
            }
            return;
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //noinspection MissingPermission
                locationManager.requestLocationUpdates("gps", 5000, 0, listener);
            }
        });
    }


   public void AddOrders(String phone,String smoothieName,String serves,String amt)
    {
        boolean insertData = obj.orders(phone,smoothieName,serves,amt);
        //if(insertData)
        //{
           // Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();
       // }
        //else
       // {
         //   Toast.makeText(this,"wrong",Toast.LENGTH_SHORT).show();
       // }

    }
    public void openActivity2()
    {
        AddOrders(phoneUser,smoothieName,String.valueOf(serves),String.valueOf(amt));
        Intent intent = new Intent(this,LoadingPage.class);
        startActivity(intent);
    }
    public void openActivity()
    {

    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}
