package com.example.sriemert.androidskillportfolio;

/**
 * Created by sriemert on 2018-03-14.
 */

public final class SkillInfo {
    private final String mSkillId;
    private final String mTitle;
    private final String mDescription;

    public SkillInfo(String skillId, String title, String description) {
        mSkillId = skillId;
        mTitle = title;
        mDescription = description;
    }

    public String getmSkillId() {
        return mSkillId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    @Override
    public String toString() {
        return mTitle;
    }


}
