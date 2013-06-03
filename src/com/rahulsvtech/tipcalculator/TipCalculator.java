package com.rahulsvtech.tipcalculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculator extends Activity {

	private Double dblTotal;
	private Double dblTipValue;
	private String strBlank;
	private String strZero;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        
        dblTotal =  0.00;
        dblTipValue =  0.00;
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
		et.setText((CharSequence)strBlank);
		tv.setText((CharSequence)strZero);
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

		// Validate the input
    	String total = et.getText().toString();
    	if(valid(total)) {
    		dblTotal = Double.parseDouble(total);
    		dblTipValue = dblTotal*tipPercent;
    		DecimalFormat twoDForm = new DecimalFormat("#.##");
    		String x = twoDForm.format(dblTipValue);
    		tv.setText((CharSequence)x);
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
