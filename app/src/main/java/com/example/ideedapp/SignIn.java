package com.example.ideedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ideedapp.DAO.UserDAO;
import com.example.ideedapp.DataBase.AppDataBase;
import com.example.ideedapp.entities.User;

public class SignIn extends AppCompatActivity {


    //var
    String EMAIL = "";

    //widgets
     EditText email;
     EditText password;
     Button login;
     Button signuppagebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        setTitle("SignIn");


        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signuppagebtn = findViewById(R.id.signuppage);
        login= findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String emailT = email.getText().toString();
                final String passwordT = password.getText().toString();
                if (emailT.isEmpty() || passwordT.isEmpty()) {
                    Toast.makeText(getApplicationContext(),"Fill all Fields !", Toast.LENGTH_SHORT).show();
                } else {
                    //Perform Query

                    //database init
                    AppDataBase appDataBase = AppDataBase.getInstance(getApplicationContext());

                    //Dao init
                    UserDAO userDAO = appDataBase.userDAO();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //calling login methode
                            User user = userDAO.login(emailT, passwordT);
                            if (user == null) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"Invalid Credentials!",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else{
                                String email = user.getEmail().toString();
                                startActivity(new Intent(SignIn.this, TaskView.class)
                                        .putExtra("email",email));

                            }


                        }
                    }).start();
                }




            }
        });

        signuppagebtn.setOnClickListener(View -> {
            Intent changeToSignInPageIntent = new Intent(this, SignUp.class);
            startActivity(changeToSignInPageIntent);
        });

    }
}
