package com.example.suweikai.espressotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtInput;
    private Button btnShow;
    private Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtInput = findViewById(R.id.editTextUserInput);
        btnShow = findViewById(R.id.changeTextBt);
        btnNext = findViewById(R.id.btn_next);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showText();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ChildActivity.class));
            }
        });
    }

    private void showText() {
        String input = edtInput.getText().toString();
        if(!input.isEmpty()) {
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        }
        edtInput.setText("");
    }
}
