package com.ez.ez_home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class MainActivity extends AppCompatActivity {


    socketClientConnections sc = new socketClientConnections();
    private ToggleButton toggleButton1, toggleButton2, toggleButton3, toggleButton4;
    private Button btnDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sc.serverIP="192.168.0.13";
        sc.serverPort = 6000;

        addListenerOnButton();

    }

    public void addListenerOnButton(){

        toggleButton1=(ToggleButton)findViewById(R.id.toggleButton1);
        toggleButton2=(ToggleButton)findViewById(R.id.toggleButton2);
        toggleButton3=(ToggleButton)findViewById(R.id.toggleButton3);
        toggleButton4=(ToggleButton)findViewById(R.id.toggleButton4);
        // btnDisplay=(Button) findViewById(R.id.btnDisplay);

        toggleButton1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result=new StringBuffer();
                result.append("toggleButton1: ").append(toggleButton1.getText());

                if(toggleButton1.isChecked()) {
                    sc.onRelayNumber="a";
                    new Thread(sc).start();
                }
                else{
                    sc.onRelayNumber = "a_off";
                    new Thread(sc).start();
                }

                Toast.makeText(MainActivity.this, result.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        toggleButton2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result=new StringBuffer();
                result.append("toggleButton2: ").append(toggleButton2.getText());

                if(toggleButton2.isChecked()) {
                    sc.onRelayNumber = "b";
                    new Thread(sc).start();
                }
                else{
                    sc.onRelayNumber = "b_off";
                    new Thread(sc).start();
                }

                Toast.makeText(MainActivity.this, result.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        toggleButton3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result=new StringBuffer();
                result.append("toggleButton3: ").append(toggleButton3.getText());

                if(toggleButton3.isChecked()) {
                    sc.onRelayNumber = "c";
                    new Thread(sc).start();
                }
                else{
                    sc.onRelayNumber = "c_off";
                    new Thread(sc).start();
                }

                Toast.makeText(MainActivity.this, result.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        toggleButton4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer result=new StringBuffer();
                result.append("toggleButton4: ").append(toggleButton4.getText());

                if(toggleButton4.isChecked()) {
                    sc.onRelayNumber = "d";
                    new Thread(sc).start();
                }
                else{
                    sc.onRelayNumber = "d_off";
                    new Thread(sc).start();
                }

                Toast.makeText(MainActivity.this, result.toString(),Toast.LENGTH_SHORT).show();
            }
        });



    }


    public void onClickSwitch1(View view) {
        Button btn1 = (Button) view;






    }

/*
    ToggleButton toggle = (ToggleButton) findViewById(R.id.switch1);
    toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                // The toggle is enabled
            } else {
                // The toggle is disabled
            }
        }
    });*/







    public void onClickSwitch2(View view) {
        Button btn2 = (Button) view;

        //  sc.onRelayNumber = 2;
        new Thread(sc).start();

    }


    public void onClickSwitch3(View view){
        Button btn3 = (Button) view;

        // sc.onRelayNumber = 3;
        new Thread(sc).start();


    }

    public void onClickSwitch4(View view){
        Button btn4 = (Button) view;

        //sc.onRelayNumber = 4;
        new Thread(sc).start();
    }











}
