package com.rahulsvtech.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculator extends Activity {

	private String strBlank;
	private String strZero;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        
        strBlank="";
        strZero="0.00";
        reset();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        
        return true;
    }

    public void reset() {
    	EditText et = (EditText) findViewById(R.id.totalAmount);
		TextView tv = (TextView) findViewById(R.id.labelTipValue);
		TextView tv2 = (TextView) findViewById(R.id.labelGrandTotalValue);
		
		et.setText((CharSequence)strBlank);
		tv.setText((CharSequence)strZero);
		tv2.setText((CharSequence)strZero);
    }
    
    public boolean valid(String val) {

    	// Check if the string is a valid string
    	// For this app it has to be a decimal number
    	  try  
    	  {  
    	    double d = Double.parseDouble(val);  
    	  }  
    	  catch(NumberFormatException nfe)  
    	  {  
    	    return false;   
    	  }  
    	  return true;     
    }
    
    public void calcTip(Double tipPercent, View view) {
    	EditText et = (EditText) findViewById(R.id.totalAmount);
		TextView tv = (TextView) findViewById(R.id.labelTipValue);
		TextView tv2 = (TextView) findViewById(R.id.labelGrandTotalValue);
		
		Double dblTotal;
		Double dblTipValue;
		String strTipValue;
		Double dblGrandTotal;
		String strGrandTotal;

		// Validate the input
    	String total = et.getText().toString();
    	if(valid(total)) {
    		DecimalFormat twoDForm = new DecimalFormat("#.##");

    		dblTotal = Double.parseDouble(total);

    		dblTipValue = dblTotal*tipPercent;
    		strTipValue = twoDForm.format(dblTipValue);
    		tv.setText((CharSequence)strTipValue);

    		dblGrandTotal = dblTotal + dblTipValue;
    		strGrandTotal = twoDForm.format(dblGrandTotal);
    		tv2.setText((CharSequence)strGrandTotal);
    		
    	}
    	else {
    			reset();
    	}
    		
    }
    
    public void tipPercent10(View view) {
    	calcTip(0.10, view);
    }
    
    public void tipPercent15(View view) {
    	calcTip(0.15, view);
    }

    public void tipPercent20(View view) {
    	calcTip(0.20, view);
    }
}
