package com.example.sriemert.androidskillportfolio.Demos.InteractiveStory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sriemert.androidskillportfolio.Demos.InteractiveStory.model.Page;
import com.example.sriemert.androidskillportfolio.Demos.InteractiveStory.model.Story;
import com.example.sriemert.androidskillportfolio.R;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {
	private static final String TAG = StoryActivity.class.getSimpleName();
	private Story story;
	private ImageView storyImageView;
	private Button choice1Button;
	private Button choice2Button;
	private String name;
	private TextView storyTextView;
	private Stack<Integer> pageStack  = new Stack<Integer>();


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
		if (name == null || name.isEmpty()) {
			name = "Friend";
		}

		Log.d(TAG, "This is name: " + name);

		story = new Story();
		loadPage(0);
	}

	private void loadPage(int pageNumber) {
		pageStack.push(pageNumber);

		final Page page = story.getPage(pageNumber);

		Drawable image = ContextCompat.getDrawable(this, page.getImageId());
		storyImageView.setImageDrawable(image);

		String pageText = getString(page.getTextId());
		// Add name if placeholder included. Wont add if not
		pageText = String.format(pageText, name);
		storyTextView.setText(pageText);

		if (page.isFinalPage()) {
			choice1Button.setVisibility(View.INVISIBLE);
			choice2Button.setText(R.string.play_again_button_pressed);
			choice2Button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
				    loadPage(0);
				}
			});

		} else {
			loadButtons(page);
		}

	}

	private void loadButtons(final Page page) {
		if (choice1Button.getVisibility() == View.INVISIBLE) {
			choice1Button.setVisibility(View.VISIBLE);
		}
		choice1Button.setText(page.getChoice1().getTextId());
		choice1Button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				int nextPage = page.getChoice1().getNextPage();
				loadPage(nextPage);
			}
		});
		choice2Button.setText(page.getChoice2().getTextId());
		choice2Button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				int nextPage = page.getChoice1().getNextPage();
				loadPage(nextPage);
			}
		});
	}

	@Override
	public void onBackPressed() {
		pageStack.pop();
		if(pageStack.isEmpty()){
			super.onBackPressed();
		}
		else {
			loadPage(pageStack.pop());
		}
	}
}
