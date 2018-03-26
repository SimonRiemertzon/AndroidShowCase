package com.example.sriemert.androidskillportfolio.Demos.InteractiveStory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sriemert.androidskillportfolio.Demos.InteractiveStory.model.Page;
import com.example.sriemert.androidskillportfolio.Demos.InteractiveStory.model.Story;
import com.example.sriemert.androidskillportfolio.R;

public class StoryActivity extends AppCompatActivity {
	private static final String TAG = StoryActivity.class.getSimpleName();
	private Story story;
	private ImageView storyImageView;
	private Button choice1Button;
	private Button choice2Button;
    private String name;
	private TextView storyTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_story);
		storyImageView = findViewById(R.id.storyImageView);
		choice1Button = findViewById(R.id.choice1Button);
		choice2Button = findViewById(R.id.choice2Button);
		storyTextView = findViewById(R.id.storyTextView);

		Intent intent = getIntent();
		name = intent.getStringExtra(getString(R.string.key_name));
		if (name == null || name.isEmpty()) {name = "Friend";}

		Log.d(TAG, "This is name: " + name );

		story = new Story();
		loadPage(0);
	}

	private void loadPage(int pageNumber) {
		Page page = story.getPage(pageNumber);

		Drawable image = ContextCompat.getDrawable(this, page.getImageId());
		storyImageView.setImageDrawable(image);

		String pageText = getString(page.getTextId());
		// Add name if placeholder included. Wont add if not
		pageText = String.format(pageText, name);
		storyTextView.setText(pageText);

		choice1Button.setText(page.getChoice1().getTextId());
		choice2Button.setText(page.getChoice2().getTextId());

	}













}
