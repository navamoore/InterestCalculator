package com.navamoore.interestcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.navamoore.interestcalculator.R.id.textView;

public class InterestCalculator extends AppCompatActivity {

    // Variable Declaration

    private EditText principal;
    private EditText percentage;
    private EditText year;
    private TextView result;
    private Button calculate;

    double amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_calculator);

        principal = (EditText) findViewById(R.id.editText2);
        percentage = (EditText) findViewById(R.id.editText5);
        year = (EditText) findViewById(R.id.editText6);
        calculate = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(textView);
        result.setText("");
        //result.setMovementMethod(new ScrollingMovementMethod());   //Makes text view scroll

        calculate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Double principalValue = Double.parseDouble(principal.getText().toString());
                Double percentageValue  = Double.parseDouble(percentage.getText().toString())/100;
                Double yearValue = Double.parseDouble(year.getText().toString());

                String answer = "";

                for (int i = 1; i <= yearValue; i++) {
                    amount = principalValue * Math.pow(1 + percentageValue, i);
                    answer += "The Compound Interest for year " + i + " is : " + String.format("%.0f", amount) + "\n";
                }

                result.setText(answer);

            }
        });
    }
}
