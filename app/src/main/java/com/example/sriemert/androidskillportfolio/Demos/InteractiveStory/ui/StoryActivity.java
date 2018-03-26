package com.example.sriemert.androidskillportfolio.Demos.InteractiveStory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.example.sriemert.androidskillportfolio.Demos.InteractiveStory.model.Page;
import com.example.sriemert.androidskillportfolio.Demos.InteractiveStory.model.Story;
import com.example.sriemert.androidskillportfolio.R;

public class StoryActivity extends AppCompatActivity {
	private static final String TAG = StoryActivity.class.getSimpleName();
	private Story story;
	private ImageView storyImageView;
	private Button choice1Button;
	private Button choice2Button;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_story);
		storyImageView = findViewById(R.id.storyImageView);
		choice1Button = findViewById(R.id.choice1Button);
		choice2Button = findViewById(R.id.choice2Button);

		Intent intent = getIntent();
		String name = intent.getStringExtra(getString(R.string.key_name));
		if (name == null || name.isEmpty()) {name = "Friend";}

		Log.d(TAG, "This is name: " + name );

		story = new Story();
		loadPage(0);
	}

	private void loadPage(int pageNumber) {
		Page page = story.getPage(pageNumber);

		Drawable image = ContextCompat.getDrawable(this, page.getImageId());
		storyImageView.setImageDrawable(image);
	}

}
