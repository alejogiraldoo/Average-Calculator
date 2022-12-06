package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    private EditText txt_mat, txt_che, txt_pro, txt_fi;
    private TextView tv_result, tv_msg;
    private double mathPorc = 0.25;
    private double chemPorc = 0.40;
    private double proPorc = 0.25;
    private double fisPorc = 0.10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Connect the visual width logical way
        txt_mat = (EditText)findViewById(R.id.txt_mat);
        txt_che = (EditText)findViewById(R.id.txt_che);
        txt_pro = (EditText)findViewById(R.id.txt_pro);
        txt_fi = (EditText)findViewById(R.id.txt_fi);
        tv_result = (TextView)findViewById(R.id.tv_result);
        tv_msg = (TextView)findViewById(R.id.tv_msg);
    }

    public void calculate(View view){
        // Define Variables like String
        String math_s = txt_mat.getText().toString();
        String chemestry_s = txt_che.getText().toString();
        String programming_s = txt_pro.getText().toString();
        String fisic_s = txt_fi.getText().toString();

        // Verify null fields
        if (math_s.equals("") || chemestry_s.equals("") || programming_s.equals("") || fisic_s.equals("")){
            tv_msg.setText("Complete all Fields");
        }else {
            if (isInteger(math_s) && isInteger(chemestry_s) && isInteger(programming_s) && isInteger(fisic_s)){
                // Change the kind -> (Casteo)
                double math_d = Double.parseDouble(math_s);
                double chemestry_d = Double.parseDouble(chemestry_s);
                double programming_d = Double.parseDouble(programming_s);
                double fisic_d = Double.parseDouble(fisic_s);
                // Define Promedio
                double average;
                average = math_d*mathPorc + chemestry_d*chemPorc + programming_d*proPorc + fisic_d*fisPorc;
                if (average <= 3) {
                    tv_result.setText("The Student don't aproved, Student State:" + average);
                }
                if (3 < average && average > 3) {
                    tv_result.setText("The Student aproved, Student State:" + average);
                }
                borrar();
            }else{
                tv_msg.setText("Type subject Average in the Fields");
            }
        }
    }

    private void borrar(){
        txt_mat.setText("");
        txt_che.setText("");
        txt_pro.setText("");
        txt_fi.setText("");
        tv_msg.setText("");
    }

    public void backPage(View view){
        Intent back= new Intent(this, MainActivity2.class);
        startActivity(back);
    }

    public boolean isInteger(String numero){
        try{
            Integer.parseInt(numero);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}