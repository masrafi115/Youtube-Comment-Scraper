package com.masrafi115.ytcommscraper;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

	private Toolbar mainToolbar;

	// fragment used for scraping any youtube video
	private ScraperFragment scraperFragment;

	private String sharedText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setTheme(R.style.AppTheme);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// obtaining an instance of this class by calling getInstance() method, like initialising mAuth variable.

		// obtaining an instance of this class by calling getInstance() method, like initialising firebaseFirestore variable.

		mainToolbar = (Toolbar) findViewById(R.id.MainToolbar);
		setSupportActionBar(mainToolbar);

		// setting title to actionbar of MainActivity
		getSupportActionBar().setTitle("YT Scraper");

		
		scraperFragment = new ScraperFragment(); // Fragment which shows youtube  video comment scraping feature
		
		initializeFragment(); // Fragments are initialized.

		
		Intent intent = getIntent();
		String action = intent.getAction();
		String type = intent.getType();

		if (Intent.ACTION_SEND.equals(action) && type != null) {
			if ("text/plain".equals(type)) {
				sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
				if (sharedText != null) {
					// Update UI to reflect text being shared
					// textBox.setText(sharedText);
				}

			}
		}

	}

	public String getLink() {
		return sharedText;
	}

	@Override
	protected void onStart() {
		super.onStart();

	}

	@Override
	// main menu means export button has created in actionbar.
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;

	}

	@Override
	// for performing export operation when export menu button in actionbar has tapped.
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.action_export_btn:
			//export;
			return true;

		default:
			return false;

		}

	}

	
	// function for initialising fragments.
	private void initializeFragment() {

		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

		fragmentTransaction.add(R.id.main_container, scraperFragment);

		fragmentTransaction.commit();

	}

}
