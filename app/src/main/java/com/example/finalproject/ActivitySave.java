package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivitySave extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        TextView textName = findViewById(R.id.textName);
        TextView textView = findViewById(R.id.txtView);

        String dates = "Email: " + getIntent().getStringExtra("txtMail") +
                "\n Address: " +  getIntent().getStringExtra("txtAddress") +
                "\n Department: " +  getIntent().getStringExtra("cbxDepart") +
                "\n Schedule: " + getIntent().getStringExtra("schedule");

        textName.setText("Name: " + getIntent().getStringExtra("txtName"));
        textView.setText(dates);
    }

    public void backPage(View view){
        Intent back= new Intent(this, MainActivity2.class);
        startActivity(back);
    }

    public void nextPage(View view){
        Intent next= new Intent(this, MainActivity3.class);
        startActivity(next);
    }
}