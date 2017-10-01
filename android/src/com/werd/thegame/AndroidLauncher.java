package com.werd.thegame;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdView;

public class AndroidLauncher extends AndroidApplication {



	protected AdView adView;
	protected View gameView;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		RelativeLayout layout = new RelativeLayout(this);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);

		View gameView = initializeForView(new TheGame(), config);

		layout.addView(gameView);

//		adView = new AdView(this);
//		//adView.setAdUnitId(getResources().getString(R.string.admob_publisher_id));
//		adView.setAdSize(AdSize.BANNER);
//
//		AdRequest adRequest = new AdRequest.Builder()
//				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//				.addTestDevice(".............")
//				.build();
//		adView.loadAd(adRequest);
//
//		RelativeLayout.LayoutParams adParams =
//				new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
//						RelativeLayout.LayoutParams.WRAP_CONTENT);
//		adParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
//		adParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
//
//		layout.addView(adView, adParams);

		setContentView(layout);
	}


	@Override
	public void onResume() {
		super.onResume();
		if (adView != null) {
			adView.resume();
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		if (adView != null) {
			adView.pause();
		}
	}


	@Override
	public void onDestroy() {
		if (adView != null) {
			adView.destroy();
		}
		super.onDestroy();
	}
//	@Override
//	protected void onCreate (Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
//		initialize(new TheGame(this), config);
//	}
}
