package com.example.user.login;

import android.content.Intent;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;


public class NewNoteActivity extends AppCompatActivity {


    private Toolbar mToolbar;
    private Button Logout;
    private FirebaseAuth firebaseAuth;
    private EditText Title;
    private EditText Descritpion;
    private Button Save;
    private Button LogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        firebaseAuth = FirebaseAuth.getInstance();

        Save = (Button)findViewById(R.id.btnSave);
        Title = (EditText)findViewById(R.id.etTitle);
        Descritpion = (EditText)findViewById(R.id.etDescription);
        LogOut = (Button)findViewById(R.id.btnLogout);

        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(NewNoteActivity.this, MainActivity.class));
            }
        });

    }


}


