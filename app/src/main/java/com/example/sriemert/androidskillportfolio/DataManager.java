package com.example.sriemert.androidskillportfolio;



import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import com.example.sriemert.androidskillportfolio.Demos.SkillList.SkillInfo;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Jim.
 */
public class DataManager {
	private static DataManager mOurInstance = null;
	private List<SkillInfo> mSkills = new ArrayList<>();
	private Context mContext;


	private DataManager(Context context) {
		mContext = context;
	}


	public String getString(@StringRes int id) {
		return mContext.getString(id);
	}

	public Drawable getDrawable(@DrawableRes int id) {
		return mContext.getDrawable(id);
	}



	public static void init(Context context) {
		mOurInstance = new DataManager(context.getApplicationContext());
		mOurInstance.initializeSkills();
	}



	public static DataManager getInstance() {
		return mOurInstance;
	}

	//Adds a menuitem for the skill-list.
	private void initializeSkills() {
		mSkills.add(new SkillInfo(
				0,
				getInstance().getString(R.string.skill0_title),
				getInstance().getString(R.string.skill0_description)));
		mSkills.add(new SkillInfo(
				1,
				getInstance().getString(R.string.skill1_title),
				getInstance().getString(R.string.skill1_description)));
		mSkills.add(new SkillInfo(
				2,
				getInstance().getString(R.string.skill2_title),
				getInstance().getString(R.string.skill2_description)
		));

	}

	public List<SkillInfo> getSkills() {
		return mSkills;
	}

}
