package com.example.panch.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //Getting data sended to this activity
        //depends the data was sended use getDataTypeExtra, param=saved data
        String name = getIntent().getStringExtra("username");

        tvWelcome = (TextView)findViewById(R.id.tvWelcome);
        //put format String trought getString(R.resourcetyoe.resourcename,string to concat)
        //string to concat depends from "%1$s" elements indicated on string.xml
        tvWelcome.setText(getString(R.string.welcomemsg,name));
    }
}
