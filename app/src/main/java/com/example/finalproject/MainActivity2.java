package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText txtName, txtMail, txtAddress;
    Button btnSave;
    Spinner cbxDepart;
    RadioButton rbFull,rbPart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtName = findViewById(R.id.txtName);
        txtMail = findViewById(R.id.txtMail);
        txtAddress = findViewById(R.id.txtAddress);
        cbxDepart = findViewById(R.id.cbx_Depart);
        rbFull = findViewById(R.id.rbFull);
        rbPart = findViewById(R.id.rbPart);
        btnSave = findViewById(R.id.btnSave);

        // BUTTON ACTION
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtName.getText().toString().equals("") || txtMail.getText().toString().equals("") || txtAddress.getText().toString().equals("") || cbxDepart.getSelectedItem().toString().equals("") || (rbFull.isChecked() == false  && rbPart.isChecked() == false)){
                    Toast.makeText(MainActivity2.this,"Complete All Fields",Toast.LENGTH_LONG).show();
                }else{
                   Intent next = new Intent(MainActivity2.this,ActivitySave.class);
                    next.putExtra("txtName",txtName.getText().toString());
                    next.putExtra("txtMail",txtMail.getText().toString());
                    next.putExtra("txtAddress",txtAddress.getText().toString());
                    next.putExtra("cbxDepart",cbxDepart.getSelectedItem().toString());
                    String schedule = "";

                    if(rbFull.isChecked()){
                        schedule = "Full Time";
                    }else{
                        schedule = "Part Time";
                    }

                    next.putExtra("schedule",schedule);
                    startActivity(next);
                }
            }
        });
    }
}