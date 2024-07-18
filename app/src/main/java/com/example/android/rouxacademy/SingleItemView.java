package com.example.android.rouxacademy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SingleItemView extends Activity {
	// Declare Variables
	 int CaseNumber;
	int Case_pic_dis;
	 String Casetitle;
	 String description;
	TextView txtrank;
	TextView txtcountry;

	ImageView imgflag;
	ImageView imgflag2;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.singleitemview);
		// Get the intent from ListViewAdapter
		Intent i = getIntent();

		// Get the results of rank
		Casetitle = i.getStringExtra("Casetitle");
		// Get the results of country
		description = i.getStringExtra("description");

		// Get the results of flag
		CaseNumber = i.getIntExtra("CaseNumber", CaseNumber);
// Get the results of flag
		Case_pic_dis = i.getIntExtra("Case_pic_dis", Case_pic_dis);

		// Locate the TextViews in singleitemview.xml
		txtrank = (TextView) findViewById(R.id.rank);
		txtcountry = (TextView) findViewById(R.id.country);


		// Locate the ImageView in singleitemview.xml
		imgflag = (ImageView) findViewById(R.id.flag);
		imgflag2 = (ImageView) findViewById(R.id.flag2);

		// Load the results into the TextViews
		txtrank.setText(Casetitle);
		txtcountry.setText(description);


		// Load the image into the ImageView
		imgflag.setImageResource(CaseNumber);
		imgflag2.setImageResource(Case_pic_dis);
	}
}