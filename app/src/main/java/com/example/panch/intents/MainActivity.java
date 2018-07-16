package com.example.panch.intents;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnActivity2, btnActivity3;
    TextView tvMessage;
    final int activity3=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText)findViewById(R.id.etName);
        btnActivity2 = (Button)findViewById(R.id.btnActivity2);
        btnActivity3 = (Button)findViewById(R.id.btnActivity3);
        tvMessage = (TextView)findViewById(R.id.tvMessage);

        btnActivity2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //get text from edit text
                String name = etName.getText().toString().trim();

                Toast.makeText(MainActivity.this, "Clicked activity 2",
                        Toast.LENGTH_LONG).show();
                //parameter (from(here), where go)
                Intent a2 = new Intent(MainActivity.this, Activity2.class);
                //in the intent save data to send new activity,params (nameofdata,valuedata)
                a2.putExtra("username", name);//can use putExtra u need
                startActivity(a2);
            }
        });

        btnActivity3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "Clicked activity 3",
                        Toast.LENGTH_LONG).show();

                Intent a3 = new Intent(MainActivity.this, Activity3.class);

                startActivityForResult(a3,activity3);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        String surname, name;

        if(requestCode==activity3 && resultCode==RESULT_OK){
            //get data intent
            surname = data.getStringExtra("surname");
            name = etName.getText().toString().trim();

            tvMessage.setText(name+" "+surname);
        }else if(requestCode==RESULT_CANCELED){
            Toast.makeText(this,"the user did not enter anything",
                    Toast.LENGTH_LONG);
        }
    }
}
