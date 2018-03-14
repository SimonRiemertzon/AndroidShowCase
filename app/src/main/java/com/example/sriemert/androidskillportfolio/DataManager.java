package com.example.sriemert.androidskillportfolio;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jim.
 */

public class DataManager {
    private static DataManager ourInstance = null;

    private List<SkillInfo> mSkills = new ArrayList<>();

    public static DataManager getInstance() {
        if(ourInstance == null) {
            ourInstance = new DataManager();
            ourInstance.initializeSkills();
        }
        return ourInstance;
    }

    private void initializeSkills() {
        mSkills.add(new SkillInfo(
                0,
                "Taprecongnizers",
                "Showcasing how to use taprecongnizers"));
    }


    public List<SkillInfo> getSkills() {
        return mSkills;
    }



}
