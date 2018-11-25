package com.example.user.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FingerprintActivity extends AppCompatActivity {

    public TextView Text;
    public ImageView Jazz;
    public Button Next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint);

        Text = (TextView)findViewById(R.id.tvInfo);
        Jazz = (ImageView)findViewById(R.id.ivJazz);
        Next = (Button)findViewById(R.id.btnNext);

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FingerprintActivity.this, FingerprintAuthenticationActivity.class));
            }
        });



    }
}


