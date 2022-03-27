package com.haluki.yesiledon.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.haluki.yesiledon.R;

public class ResultActivity extends AppCompatActivity {

    Button dkButton,smsButton,intButton;
    TextView atikResultInfo,tebrikler;
    int alinanAtikAdedi = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        dkButton = (Button) findViewById(R.id.resultButton1);
        intButton = (Button) findViewById(R.id.resultButton2);
        smsButton = (Button) findViewById(R.id.resultButton3);

        tebrikler = findViewById(R.id.tebrikler);
        atikResultInfo = findViewById(R.id.atıkResult);
        atikResultInfo.setText("Atık adedi : " + alinanAtikAdedi);

        if(alinanAtikAdedi >= 0 && alinanAtikAdedi <=10){
            dkButton.setText("10 DK");
            intButton.setText("100 MB");
            smsButton.setText("10 SMS");
        }else if(alinanAtikAdedi > 10 && alinanAtikAdedi <=20){
            dkButton.setText("30 DK");
            intButton.setText("150 MB");
            smsButton.setText("25 SMS");
        }else if(alinanAtikAdedi > 20){
            dkButton.setText("100 DK");
            intButton.setText("500 MB");
            smsButton.setText("100 SMS");
        }
    }

    public void dk(View view){
        Toast.makeText(ResultActivity.this,"Dakika hakkınız en kısa sürede hattınıza tanımlanacaktır.",Toast.LENGTH_LONG).show();
        dkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //dkButton.setVisibility(View.INVISIBLE);
                smsButton.setVisibility(View.INVISIBLE);
                intButton.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void internet(View view){
        Toast.makeText(ResultActivity.this,"İnternet hakkınız en kısa sürede hattınıza tanımlanacaktır.",Toast.LENGTH_LONG).show();
        intButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dkButton.setVisibility(View.INVISIBLE);
                smsButton.setVisibility(View.INVISIBLE);
                //intButton.setVisibility(View.INVISIBLE);
            }
        });


    }

    public void sms(View view){
        Toast.makeText(ResultActivity.this,"SMS hakkınız en kısa sürede hattınıza tanımlanacaktır.",Toast.LENGTH_LONG).show();
        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dkButton.setVisibility(View.INVISIBLE);
                //smsButton.setVisibility(View.INVISIBLE);
                intButton.setVisibility(View.INVISIBLE);
            }
        });

    }


}