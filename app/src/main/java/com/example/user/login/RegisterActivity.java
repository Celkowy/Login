package com.example.user.login;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText UserName;
    private EditText UserPassword;
    private EditText UserEmail;
    private Button regButton;
    private Button Back;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){

                    //Upload data to the database//

                    String user_email = UserEmail.getText().toString().trim();
                    String user_password = UserPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                        }else{
                                Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                            }
                    });
                }
            }
        });


        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(j);
            }
        });
    }
            private void setupUIViews() {
                UserName = (EditText) findViewById(R.id.etUserName);
                UserEmail = (EditText) findViewById(R.id.etUserEmail);
                UserPassword = (EditText) findViewById(R.id.etUserPassword);
                regButton = (Button) findViewById(R.id.btnRegister);
                Back = (Button) findViewById(R.id.btnBack);
            }

            private Boolean validate(){
                Boolean result = false;

                String name = UserName.getText().toString();
                String password =  UserPassword.getText().toString();
                String email = UserEmail.getText().toString();

                if (name.isEmpty() || password.isEmpty() || email.isEmpty()){
                    Toast.makeText(this, "Please enter lacking details", Toast.LENGTH_SHORT).show();
                }else{
                    result = true;
                }
                return  result;


            }

}
