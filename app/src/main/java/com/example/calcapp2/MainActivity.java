package com.example.calcapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    //add variables

    EditText arg1;
    EditText arg2;
    TextView answer;

    float Arg1;
    float Arg2;
    float Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arg1 = (EditText)findViewById(R.id.arg1);
        arg2 = (EditText)findViewById(R.id.arg2);
        answer = (TextView) findViewById(R.id.answer);
    }

    @SuppressLint("SetTextI18n")
    public void get_data(){
        try {
            this.Arg1 = Integer.parseInt(arg1.getText().toString());
            this.Arg2 = Integer.parseInt(arg2.getText().toString());
        }
        catch (NumberFormatException nfe){
            answer.setText("Input Error");
        }
    }
    public void clear_data(){
        answer.setText("");
    }

    public void put_data(){
        if ((!answer.getText().toString().equals("Input Error")) && (!answer.getText().toString().equals("Div by zero"))){
            answer.setText(String.valueOf(this.Answer));
        }

    }

    public void add(View view) {
        clear_data();
        get_data();
        this.Answer=this.Arg1+this.Arg2;
        put_data();
    }

    public void subtr(View view) {
        clear_data();
        get_data();
        this.Answer=this.Arg1-this.Arg2;
        put_data();
    }

    public void mul(View view) {
        clear_data();
        get_data();
        this.Answer=this.Arg1*this.Arg2;
        put_data();
    }


    @SuppressLint("SetTextI18n")
    public void divide(View view) {
        clear_data();
        get_data();
        try {
            this.Answer=this.Arg1/this.Arg2;
        }
        catch (ArithmeticException ae){
            if (!answer.getText().toString().equals("Input Error")){
                answer.setText("Div by zero");
            }
        }
        put_data();
    }

    public void clear(View view) {
        clear_data();
        arg1.setText("");
        arg2.setText("");
    }
}
