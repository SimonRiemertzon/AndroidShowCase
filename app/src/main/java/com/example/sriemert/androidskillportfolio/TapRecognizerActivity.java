package com.example.sriemert.androidskillportfolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TapRecognizerActivity extends AppCompatActivity {
	private Button mAddButton;
	private Button mSubtractButton;
	private TextView mTextCounter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tap_recognizer);

		initializeDisplayContent();

	}

	private void initializeDisplayContent() {
		mAddButton = findViewById(R.id.button_taprcognizeractivity_add);
		mSubtractButton = findViewById(R.id.button_taprcognizeractivity_subtract);
		mTextCounter = findViewById(R.id.textview_counter);

		mAddButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				int countValue = Integer.parseInt(mTextCounter.getText().toString());
				countValue++;
				mTextCounter.setText(String.valueOf(countValue));

			}
		});


	}

}
