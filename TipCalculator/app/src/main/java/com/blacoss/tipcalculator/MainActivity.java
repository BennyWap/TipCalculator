package com.blacoss.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private EditText billEditText;
    private EditText tipPercentEditText;
    private TextView tipAmountTextView;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the widgets to class variables
        billEditText = (EditText) findViewById(R.id.billEditText);
        tipPercentEditText = (EditText) findViewById(R.id.tipPercentEditText);
        tipAmountTextView = (TextView) findViewById(R.id.tipAmountTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
    }

    public void calculateClick(View view) {

        // Get the text that was typed into the EditText
        String billStr = billEditText.getText().toString();
        String tipPercentStr = tipPercentEditText.getText().toString();

        // Convert the text into a float
        try {
            TipCalculatorModel tipCalculatorModel = new TipCalculatorModel(billStr, tipPercentStr);

            String tipAmountStr = tipCalculatorModel.calculateTip();
            String totalStr = tipCalculatorModel.calculateTotal();

            tipAmountTextView.setText(tipAmountStr);
            totalTextView.setText(totalStr);
        }
        catch(NumberFormatException e){
            Toast.makeText(this, getString(R.string.missingNumber), Toast.LENGTH_SHORT).show();
            tipAmountTextView.setText("");
            totalTextView.setText("");
        }

    }
}
