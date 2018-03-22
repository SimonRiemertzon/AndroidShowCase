package com.example.sriemert.androidskillportfolio.Demos.SkillList;

/**
 * Created by sriemert on 2018-03-14.
 */

public final class SkillInfo {
    private final int mSkillId;
    private final String mTitle;
    private final String mDescription;

    public SkillInfo(int skillId, String title, String description) {
        mSkillId = skillId;
        mTitle = title;
        mDescription = description;
    }

    public int getmSkillId() {
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
        return getmSkillId() + " | " + getmTitle() + " | " + getmDescription();
    }


}
