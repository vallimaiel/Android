package com.example.vallimaielc.smoothiesprototype;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity{
    Button signinButton;
    TextView signOut,signUp;
    EditText phoneNo,passwordUser;
    static String phone,password;
    boolean login;
    NewUsers obj;
    static String mobileno;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        obj = new NewUsers(this);
        signinButton = findViewById(R.id.signin_button);
        passwordUser= findViewById(R.id.password_user);
        phoneNo=findViewById(R.id.phone_no);
        signOut=findViewById(R.id.sign_out);
        signUp=findViewById(R.id.sign_up);
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
}
    public void openActivity2()
    {
        phone=phoneNo.getText().toString();
        mobileno=phone;
        password=passwordUser.getText().toString();
        if( phone.equals("")||password.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();

        }
        else if(phone.length()>10 || phone.length()<10)
        {
            Toast.makeText(getApplicationContext(),"Enter a valid mobile number",Toast.LENGTH_SHORT).show();
        }
        else
            {
            login=obj.userexists(phone,password);
            if(login==true) {
                Toast.makeText(getApplicationContext(),"Wrong phone no or password",Toast.LENGTH_SHORT).show();


            }
            else
            {
                Toast.makeText(getApplicationContext(),"Successfully logged in",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,NavDrawer.class);
                startActivity(intent);

            }
        }
       // Intent intent = new Intent(this,NavDrawer.class);
       // startActivity(intent);
    }
    public void openActivity3()
    {

        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }
    public void onBackPressed() {
        Intent intent = new Intent(this,Activity1.class);
        startActivity(intent);

    }
}
