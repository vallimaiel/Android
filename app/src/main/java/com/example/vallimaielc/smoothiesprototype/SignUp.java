package com.example.vallimaielc.smoothiesprototype;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    Button signupButton;
    NewUsers obj;
    String phone;
    EditText usernameText,userPhone,passwordUser;
    String name,password;
    Boolean chckusr;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        obj = new NewUsers(this);
        signupButton=findViewById(R.id.signup_button);

        usernameText=findViewById(R.id.username_text);
        userPhone=findViewById(R.id.user_phone);
        passwordUser=findViewById(R.id.password_user);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=usernameText.getText().toString();
                phone=userPhone.getText().toString();
                password=passwordUser.getText().toString();
                if(name.equals("")|| phone.equals("")||password.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();

                }
                else if(phone.length()>10 || phone.length()<10)
                {
                    Toast.makeText(getApplicationContext(),"Enter a valid mobile number",Toast.LENGTH_SHORT).show();
                }
                else {
                    chckusr=obj.userexists(phone,password);
                    if(chckusr==true) {
                        Register();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"User already exists - sign in",Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }

    public void Register()
    {
        AddUsers(phone,name,password);
        Log.d("Testing db insert :",phone+name+password);
      //  Toast.makeText(this, "Testing db insert :"+phone+name+password, Toast.LENGTH_SHORT).show();
     // Intent intent = new Intent(this,SignIn.class);
     // startActivity(intent);
    }
    public void AddUsers(String Phone,String Name,String Password)
    {
        boolean insertData = obj.addUsers(Phone,Name,Password);
        if(insertData)
        {
            Toast.makeText(this,"Registered successfully",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,SignIn.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"wrong",Toast.LENGTH_SHORT).show();
        }

    }

}
