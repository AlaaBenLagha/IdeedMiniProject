package com.example.ideedapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ideedapp.DAO.UserDAO;
import com.example.ideedapp.DataBase.AppDataBase;
import com.example.ideedapp.entities.User;


public class EditProfile extends AppCompatActivity {


    //var
    private User user;
 //   private AppDataBase appDataBase;
  //  private UserDAO userDAO;
    //widgets
    private EditText emailet;
    private EditText passwordet;
//    private EditText firstnameet;
//    private EditText lastnameet;
    private Button update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);



        //binding
  //      usernameet = findViewById(R.id.usernameET);
        emailet = findViewById(R.id.emailET);
        passwordet = findViewById(R.id.passwordET);
 //       firstnameet = findViewById(R.id.firstnameET);
 //       lastnameet = findViewById(R.id.lastnameET);
        update = findViewById(R.id.insert);


        //Get DATA
        user = (User) getIntent().getSerializableExtra("MODEL");
        emailet.setText(user.getEmail());
        passwordet.setText(user.getPassword());




            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //  if (usernameet.getText().toString().isEmpty() || emailet.getText().toString().isEmpty() || passwordet.getText().toString().isEmpty() || firstnameet.getText().toString().isEmpty() || lastnameet.getText().toString().isEmpty()) {
                    //       Toast.makeText(getApplicationContext(),"Please Complete Your Informations", Toast.LENGTH_LONG).show();
                    if (emailet.getText().toString().isEmpty() || passwordet.getText().toString().isEmpty()) {
                        Toast.makeText(getApplicationContext(),"Please Complete Your Informations", Toast.LENGTH_LONG).show();
                    }else {

                        AppDataBase instance = AppDataBase.getInstance(getApplicationContext());
                        UserDAO userdao = instance.userDAO();
                        //      userDAO.updateUser(userModel);

                        //              User userModel = new User(user.getId(),usernameet.getText().toString(),emailet.getText().toString(),passwordet.getText().toString(),firstnameet.getText().toString(),lastnameet.getText().toString());
                        User userModel = new User(user.getId(),emailet.getText().toString(),passwordet.getText().toString());
                        userModel.setEmail(emailet.getText().toString());
                        userModel.setPassword(passwordet.getText().toString());
                        //   userModel.setUserName(usernameet.getText().toString());
                        //   userModel.setFirstName(firstnameet.getText().toString());
                        //  userModel.setLastName(lastnameet.getText().toString());
                        userdao.setUser(userModel);
                        userdao.updateUsers(userModel);


                        Toast.makeText(getApplicationContext(),"Profile Complete with Sucess", Toast.LENGTH_LONG).show();

                    }
           /*     String username = usernameet.getText().toString();
                String email = usernameet.getText().toString();
                String password = usernameet.getText().toString();
                String firstName = usernameet.getText().toString();
                String lastName = usernameet.getText().toString();

                User user = new User();
                user.setUserName(username);
                user.setEmail(email);
                user.setPassword(password);
                user.setFirstName(firstName);
                user.setLastName(lastName);

                SignUp.appdatabase.userDAO().updateUser(user); */





                }

        });






    }
}



