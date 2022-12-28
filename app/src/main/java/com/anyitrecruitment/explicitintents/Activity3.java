package com.anyitrecruitment.explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    public static final String KEY_NAME = "NAME";
    public static final String KEY_NAME2 = "WORD";
    EditText etSurname;
    EditText etWord;
    Button btnSubmit;
    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        etSurname = findViewById(R.id.etSurname);
        etWord = findViewById(R.id.etWord);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnCancel = findViewById(R.id.btnCancel);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String surname = etSurname.getText().toString().trim();
                String word = etWord.getText().toString().trim();
                Intent intent = new Intent();
                intent.putExtra(KEY_NAME, surname);
                intent.putExtra(KEY_NAME2, word);
                setResult(RESULT_OK, intent);
                Activity3.this.finish();
                //finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                Activity3.this.finish();
            }
        });

    }
}