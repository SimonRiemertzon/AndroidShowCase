package com.example.sriemert.androidskillportfolio.Demos.InteractiveStory.ui;

import static android.view.View.*;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sriemert.androidskillportfolio.R;

public class InteractiveStoryActivity extends AppCompatActivity {

	private EditText nameField;
	private Button startButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_interactive_story);

		nameField = findViewById(R.id.nameEditText);
		startButton = findViewById(R.id.startButton);

		startButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				String name = nameField.getText().toString();
				startStory(name);
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		nameField.setText("");
	}



	private void startStory(String name) {
		Intent intent = new Intent(this, StoryActivity.class);
		String key = getString(R.string.key_name);
		intent.putExtra(key, name);
		startActivity(intent);

	}

}
