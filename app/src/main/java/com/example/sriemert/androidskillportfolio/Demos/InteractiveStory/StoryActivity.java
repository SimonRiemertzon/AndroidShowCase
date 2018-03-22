package com.example.sriemert.androidskillportfolio.Demos.InteractiveStory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sriemert.androidskillportfolio.R;

public class StoryActivity extends AppCompatActivity {
	private static final String TAG = StoryActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_story);

		Intent intent = getIntent();

		String name = intent.getStringExtra("name");
		if (name == null || name.isEmpty()) {
			name = "Friend";
		}


		Log.d(TAG, "This is name: " + name );


	}



}
