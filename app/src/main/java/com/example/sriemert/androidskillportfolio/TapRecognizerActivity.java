package com.example.sriemert.androidskillportfolio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;



public class TapRecognizerActivity extends AppCompatActivity {
	private static final String TAG = "TapRecognizerActivity";

    private Button mAddButton;
    private Button mSubtractButton;
    private TextView mTextCounter;
    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            int countValue = Integer.parseInt(mTextCounter.getText().toString());

            switch (view.getId()) {
                case  R.id.button_taprcognizeractivity_add:
                    countValue++;
                    updateCounter(countValue);
                    break;
                case R.id.button_taprcognizeractivity_subtract:
                    countValue--;
                    updateCounter(countValue);
	            default:
		            Log.wtf(TAG, "Button not recognized");

            }
        }
    };

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
        mAddButton.setOnClickListener(onClickListener);
        mSubtractButton.setOnClickListener(onClickListener);
    }

    private void updateCounter(int value) {
	    mTextCounter.setText(String.valueOf(value));
    }

}
