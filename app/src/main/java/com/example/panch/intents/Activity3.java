package com.example.panch.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity3 extends AppCompatActivity {

    EditText etSurname;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        etSurname = (EditText)findViewById(R.id.etSurname);
        submit = (Button)findViewById(R.id.btnSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String surname = etSurname.getText().toString().trim();

                Intent intent = new Intent();
                intent.putExtra("surname", surname);

                setResult(RESULT_OK, intent);

                Activity3.this.finish();


            }
        });


    }
}
