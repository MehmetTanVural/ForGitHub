package com.haluki.yesiledon.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.haluki.yesiledon.R;

public class QrActivity extends AppCompatActivity {
    Intent intentToResult;
    Button sonrakiButton;
    TextView KA;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        intentToResult = new Intent(this, ResultActivity.class);
        sonrakiButton = (Button) findViewById(R.id.sonraki);

        KA = findViewById(R.id.kullaniciAdi);
        bundle = new Bundle();
        bundle = getIntent().getExtras();
        String kullaniciAdi = bundle.getString("KA");
        KA.setText("Kullanıcı Adı: "+ kullaniciAdi);

    }


    public void sonraki(View view) {

            sonrakiButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(MainActivity.this,"Başarıyla kaydolundu.",Toast.LENGTH_LONG).show();
                    startActivity(intentToResult);
                }
            });
        }
    }