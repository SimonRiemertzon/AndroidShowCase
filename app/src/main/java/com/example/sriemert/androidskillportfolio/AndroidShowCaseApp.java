package com.example.sriemert.androidskillportfolio;

import android.app.Activity;
import android.app.Application;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.StringRes;

/**
 * Created by sirie1 on 2018-03-22.
 */
public class AndroidShowCaseApp extends Application {


	@Override
	public void onCreate() {
		super.onCreate();
		DataManager.init(this);

		registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
			@Override
			public void onActivityCreated(Activity activity, Bundle bundle) {
				activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			}

			@Override
			public void onActivityStarted(Activity activity) {

			}

			@Override
			public void onActivityResumed(Activity activity) {

			}

			@Override
			public void onActivityPaused(Activity activity) {

			}

			@Override
			public void onActivityStopped(Activity activity) {

			}

			@Override
			public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

			}

			@Override
			public void onActivityDestroyed(Activity activity) {

			}
		});
	}
}
