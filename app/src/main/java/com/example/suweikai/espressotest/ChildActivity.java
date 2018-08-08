package com.example.suweikai.espressotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChildActivity extends AppCompatActivity {

    private EditText edtInput;
    private Button btnShow;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        edtInput = findViewById(R.id.editTextUserInput);
        btnShow = findViewById(R.id.changeTextBt);
        btnBack = findViewById(R.id.btn_back);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showText();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void showText() {
        String input = edtInput.getText().toString();
        if(!input.isEmpty()) {
            Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
        }
        edtInput.setText("");
        test();
    }

    private void test() {

    }
}
