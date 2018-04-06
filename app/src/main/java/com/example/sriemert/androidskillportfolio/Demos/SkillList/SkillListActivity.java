package com.example.sriemert.androidskillportfolio.Demos.SkillList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sriemert.androidskillportfolio.DataManager;
import com.example.sriemert.androidskillportfolio.Demos.InteractiveStory.ui
		.InteractiveStoryActivity;
import com.example.sriemert.androidskillportfolio.Demos.TapRecognizerActivity;
import com.example.sriemert.androidskillportfolio.R;

import java.util.List;

public class SkillListActivity extends AppCompatActivity {
	private static final String TAG = "SkillListActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_skill_list);
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		initializeDisplayContent();
	}

	private void initializeDisplayContent() {
		final ListView listSkills = findViewById(R.id.list_skills);
		final List<SkillInfo> skills = DataManager.getInstance().getSkills();
		ArrayAdapter<SkillInfo> adapterSkills = new ArrayAdapter<SkillInfo>(this,
				android.R.layout.simple_list_item_1, skills);
		listSkills.setAdapter(adapterSkills);

		//Starts an activity based on the ID in the list.
		listSkills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				Intent intent;
				switch (skills.get(i).getmSkillId()) {
					case 0:
						intent = new Intent(SkillListActivity.this, TapRecognizerActivity.class);
						break;
					case 1:
						intent = new Intent(SkillListActivity.this, InteractiveStoryActivity
								.class);
						break;
					default:
						intent = null;
						Log.wtf(TAG, "Intent is null. No content provided for menuitem.");
				}
				startActivity(intent);

			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_skills, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}
