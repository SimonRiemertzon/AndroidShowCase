package com.example.sriemert.androidskillportfolio;

import static javax.swing.UIManager.getString;

import com.example.sriemert.androidskillportfolio.Demos.SkillList.SkillInfo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

/**
 * Created by Jim.
 */
public class DataManager {
	private static DataManager ourInstance = null;
	private List<SkillInfo> mSkills = new ArrayList<>();

	public static DataManager getInstance() {
		if (ourInstance == null) {
			ourInstance = new DataManager();
			ourInstance.initializeSkills();
		}
		return ourInstance;
	}

	//Adds a menuitem for the skill-list.
	private void initializeSkills() {
		mSkills.add(new SkillInfo(
				0,
				getString(R.string.skill0_title),
				getString(R.string.skill0_description)));
		mSkills.add(new SkillInfo(
				1,
				getString(R.string.skill1_title),
				getString(R.string.skill1_description)));
		mSkills.add(new SkillInfo(
				2,
				getString(R.string.skill2_title),
				getString(R.string.skill2_description)
		));

	}

	public List<SkillInfo> getSkills() {
		return mSkills;
	}

}
