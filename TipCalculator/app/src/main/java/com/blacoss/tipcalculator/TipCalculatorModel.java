package com.blacoss.tipcalculator;

import java.text.NumberFormat;

/**
 * Created by WhatWhat on 9/3/2017.
 */

public class TipCalculatorModel {
    private float bill;
    private float tipPercent;
    private float tip;

    public TipCalculatorModel(String billStr, String tipPercentStr){
        bill = Float.parseFloat(billStr);
        tipPercent = Float.parseFloat((tipPercentStr));
        tip = bill * (tipPercent / 100);
    }

    public String calculateTip(){
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
        return moneyFormat.format(tip);
    }

    public String calculateTotal(){
        float total = bill + tip;
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();
        return moneyFormat.format(total);
    }
}
