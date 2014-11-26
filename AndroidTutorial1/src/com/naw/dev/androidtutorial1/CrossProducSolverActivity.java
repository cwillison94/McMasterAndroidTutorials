package com.naw.dev.androidtutorial1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Cole Willison
 * @since 2014-11-25
 * 
 * 
 * */
public class CrossProducSolverActivity extends Activity implements OnClickListener {
	private String infoPassed;
	private TextView tvDisplay, tvAns;
	private EditText etA1, etA2, etA3, etB1, etB2, etB3;
	private Button bCalc, bClear;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cross_product);
		
		Log.d(MainPage.DEBUG_TAG, "Starting cross product activity");
		
		setUpWidgets();

		/*
		 * This is how you get the information you sent from the other activity.
		 * Since you sent the information with the intent you must get the intent
		 * this activity was launched with then get the bundle extras with getExtras
		 * then get what ever information you sent
		 * 
		 * */
		infoPassed = getIntent().getExtras()
				.getString(MainPage.ITEM_KEY, "default value if failed or if no information was sent");

		// set the TextView display with the information sent from the other
		// activity
		tvDisplay.setText(infoPassed);

	}

	private void setUpWidgets() {
		tvDisplay = (TextView) findViewById(R.id.tvDisplay);
		tvAns = (TextView) findViewById(R.id.tvAns);
		etA1 = (EditText) findViewById(R.id.etA1);
		etA2 = (EditText) findViewById(R.id.etA2);
		etA3 = (EditText) findViewById(R.id.etA3);
		etB1 = (EditText) findViewById(R.id.etB1);
		etB2 = (EditText) findViewById(R.id.etB2);
		etB3 = (EditText) findViewById(R.id.etB3);
		bCalc = (Button) findViewById(R.id.bCalculate);
		bClear = (Button) findViewById(R.id.bClear);
		
		//attach the buttons to an onClickListener which in this 
		//case it the class itself since it implements the View.OnClickListener interface
		bCalc.setOnClickListener(this);
		bClear.setOnClickListener(this);	
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bCalculate:
			//Button Calculate clicked
			calculateCross();
			break;
		case R.id.bClear:
			//Button Clear clicked
			clearFields();
			break;
		}	
	}

	private void clearFields() {
		etA1.setText("");
		etA2.setText("");
		etA3.setText("");
		etB1.setText("");
		etB2.setText("");
		etB3.setText("");
		tvAns.setText("");
		//this is not necessary but puts the focus back on A1 when 
		//you hit clear, this allows the user to easily type a new vector
		etA1.requestFocus();
	}

	private void calculateCross() {
		//this is how you get the inputs to an EditText box
		String a1 = etA1.getText().toString();
		String a2 = etA2.getText().toString();
		String a3 = etA3.getText().toString();
		String b1 = etB1.getText().toString();
		String b2 = etB2.getText().toString();
		String b3 = etB3.getText().toString();
		
		if (a1.equals("") || a2.equals("") ||a3.equals("") ||b1.equals("") ||b2.equals("") ||b3.equals("")) {
			//make sure all input fields are filled in
			Toast.makeText(this, "FILL IN ALL FIELDS!", Toast.LENGTH_SHORT).show();
		} else {
			
			Vec3D vecA = new Vec3D(Double.parseDouble(a1),Double.parseDouble(a2),Double.parseDouble(a3));
			Vec3D vecB = new Vec3D(Double.parseDouble(b1),Double.parseDouble(b2),Double.parseDouble(b3));
			Vec3D resultantVec = vecA.cross(vecB);
			
			//this is how you set the text of a TextView
			tvAns.setText(resultantVec.toString());
		}
		
	}
}
