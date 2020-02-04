package com.bawp.paractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private Button newButton;
    private Button deposite;
    private Button withdraw;
    private EditText amount;
    private TextView amountView;
    private int initialValue=0;
    private String amountValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        newButton = findViewById(R.id.button);
//        newButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"AsalamOalikum",Toast.LENGTH_SHORT).show();
//            }
//        });


        deposite = findViewById(R.id.button_deposit);
        withdraw = findViewById(R.id.button_withdraw);
        amount = findViewById(R.id.enterAmount);
        amountView = findViewById(R.id.view_moneyValue);
        deposite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(0<=initialValue){
                 amountValue = amount.getText().toString();
                int amountInt = Integer.parseInt(amountValue);
                initialValue+=amountInt;
                    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                    amountView.setText(String.valueOf(numberFormat.format(initialValue)));
                }
            }
        });
        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(0 < initialValue) {
                    String amountValue = amount.getText().toString();
                    int amountInt = Integer.parseInt(amountValue);
                    if(amountInt<=initialValue){
                        initialValue-=amountInt;
                        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
                        amountView.setText(String.valueOf(numberFormat.format(initialValue)));
                    }else{
                        Toast.makeText(getApplicationContext(),"You have insufficent balance",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}