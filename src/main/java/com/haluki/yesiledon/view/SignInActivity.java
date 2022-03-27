package com.haluki.yesiledon.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.haluki.yesiledon.R;

public class SignInActivity extends AppCompatActivity {
    EditText telNo,sifre;
    Intent intentToQRCode;
    Button girisButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        telNo = findViewById(R.id.telNo2);
        sifre = findViewById(R.id.sifre2);
        intentToQRCode = new Intent(this,QrActivity.class);
        girisButton = (Button) findViewById(R.id.girisyap2);
    }


    public void giris(View view){

        if(telNo.getText().toString().matches("") || sifre.getText().toString().matches("")){
            Toast.makeText(SignInActivity.this,"Eksik veya hatalı giriş!",Toast.LENGTH_LONG).show();
        }else{
            girisButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intentToQRCode);
                }
            });
        }
    }
}