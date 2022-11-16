package com.example.ideedapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ideedapp.DAO.AdapterListener;
import com.example.ideedapp.DAO.UserDAO;
import com.example.ideedapp.DataBase.AppDataBase;
import com.example.ideedapp.entities.User;

public class SignUp extends AppCompatActivity {




    //var





    //widgets
    private EditText emailet;
    private EditText passwordet;
    private Button signupbtn1;
    private Button signupagebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setTitle("SignUp");






        //databading
        emailet = findViewById(R.id.emailET);
        passwordet = findViewById(R.id.passwordET);
        signupbtn1 = findViewById(R.id.signupbtn1);
        signupagebtn = findViewById(R.id.signippage1);



        //switch SingIn Date
        signupagebtn.setOnClickListener(View -> {
            Intent changeToSignUpPageIntent = new Intent(this, SignIn.class);
            startActivity(changeToSignUpPageIntent);
        });

        //signup
        signupbtn1.setOnClickListener(View ->{
            User user = new User();
            user.setEmail(emailet.getText().toString());
            user.setPassword(passwordet.getText().toString());

            if (validInput(user)){
                //insert operation
                AppDataBase instance = AppDataBase.getInstance(getApplicationContext());
                UserDAO userdao = instance.userDAO();
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        // Register User
                        userdao.setUser(user);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"User Registrated ! Please Complete Your Informations", Toast.LENGTH_LONG).show();

                            }
                        });
                        OnUpdate(user);
                    }


                }).start();

            }else {
                Toast.makeText(getApplicationContext(), "Fill all fields !" , Toast.LENGTH_LONG).show();
            }
        });
    }


    private Boolean validInput(User user){
        if (user.getEmail().isEmpty() ||
                user.getPassword().isEmpty()) {
            return false;
        }
        return true;
    }


    public void OnUpdate(User user) {
        Intent intent = new Intent(this, EditProfile.class);
        intent.putExtra("MODEL",user);
        startActivity(intent);

    }



}
