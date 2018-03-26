package com.example.sriemert.androidskillportfolio.Demos.InteractiveStory.model;

/**
 * Created by sirie1 on 2018-03-23.
 */
public class Choice {
  private int textId;
  private int nextPage;

	public Choice(int textId, int nextPage) {
		this.textId = textId;
		this.nextPage = nextPage;
	}

	public int getTextId() {
		return textId;
	}

	public int getNextPage() {
		return nextPage;
	}
}
