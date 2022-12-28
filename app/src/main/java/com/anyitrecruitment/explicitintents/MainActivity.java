package com.anyitrecruitment.explicitintents;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnAct2, btnAct3;
    TextView tvResults;
    //final int ACTIVITY3 = 3;

    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result != null && result.getResultCode() == RESULT_OK)
            {
                if(result.getData() != null && result.getData().getStringExtra(Activity3.KEY_NAME) != null && result.getData().getStringExtra(Activity3.KEY_NAME2) != null)
                {
                    String results = result.getData().getStringExtra(Activity3.KEY_NAME) + " | " + result.getData().getStringExtra(Activity3.KEY_NAME2);
                    tvResults.setText(results);
                }
            }

            if(result.getResultCode() == RESULT_CANCELED)
            {
                tvResults.setText("Cancelled by user");
                Toast.makeText(MainActivity.this, "Cancelled by user", Toast.LENGTH_SHORT).show();
            }

        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        tvResults = findViewById(R.id.tvResults);

        btnAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(etName.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String name = etName.getText().toString().trim();
                    Intent intent = new Intent(MainActivity.this,
                            com.anyitrecruitment.explicitintents.Activity2.class);
                    intent.putExtra("name", name);
                    startActivity(intent);
                }

            }
        });

        btnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,
                        com.anyitrecruitment.explicitintents.Activity3.class);
                startForResult.launch(intent);
                //startActivityForResult(intent,ACTIVITY3);
            }
        });
    }
}