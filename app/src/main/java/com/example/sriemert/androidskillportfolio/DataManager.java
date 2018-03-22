package com.example.sriemert.androidskillportfolio;

import com.example.sriemert.androidskillportfolio.Demos.SkillList.SkillInfo;

import java.util.ArrayList;
import java.util.List;

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
                "Taprecongnizers",
                "Showcasing how to use taprecongnizers"));
	    mSkills.add(new SkillInfo(
			    1,
			    "Interactive Story",
			    "An interactive story where I learned several basic Java-programming elements"));
	    }


    public List<SkillInfo> getSkills() {
        return mSkills;
    }


}
