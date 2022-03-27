package com.haluki.yesiledon.view;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.haluki.yesiledon.R;
import com.haluki.yesiledon.Users;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText telNo,isimSoyisim,sifre;
    Button kaydolButton,girisYapButton;
    Intent intentToQRCode,intentToSignIn;
    Users user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        telNo = findViewById(R.id.telNo);
        isimSoyisim = findViewById(R.id.isimSoyisim);
        sifre = findViewById(R.id.sifre);

        kaydolButton = (Button) findViewById(R.id.kaydol);//buton id kullanarak ulaşmak
        girisYapButton = (Button) findViewById(R.id.girisyap);

        intentToQRCode = new Intent(this, QrActivity.class);//Aktiviteler arası geçişler için
        intentToSignIn = new Intent(this,SignInActivity.class);

        user = new Users(telNo.getText().toString(),isimSoyisim.getText().toString(),sifre.getText().toString());
        //Kullanıcı bilgileri çöp konteynırı ile paylaşılır.
    }


    public void kaydol(View view) {

        if(telNo.getText().toString().matches("") || isimSoyisim.getText().toString().matches("") || sifre.getText().toString().matches("")){
            Toast.makeText(MainActivity.this,"Eksik veya hatalı giriş!",Toast.LENGTH_LONG).show();
        }else{
            kaydolButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,"Başarıyla kaydolundu.",Toast.LENGTH_LONG).show();
                    intentToQRCode.putExtra("KA",isimSoyisim.getText().toString());
                    startActivity(intentToQRCode);
                }
            });
        }
    }

    public void girisyap(View view){
        girisYapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentToSignIn);
            }
        });

    }

}