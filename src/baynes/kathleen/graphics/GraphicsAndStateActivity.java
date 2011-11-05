package baynes.kathleen.graphics;

import baynes.kathleen.graphics.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class GraphicsAndStateActivity extends Activity {
	
		
	protected static final String TAG = "baynes.kathleen.graphics";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sprite_list,
		    android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setAdapter(adapter);
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
      public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
				CharSequence spinnerChoice = ((TextView)selectedItemView).getText();
				Log.d(TAG, "spinner item selected: " + spinnerChoice);
				
				FrameLayout frame = ((FrameLayout)findViewById(R.id.frame));
				frame.removeAllViews();
				
				View toAdd = null;
				
				if ("Clapping Monkey".contentEquals(spinnerChoice)) {
					Log.d(TAG, "ooh a monkey!");
					toAdd = new Monkey(getBaseContext());
				}
				else if ("Christmas Tree".contentEquals(spinnerChoice)) {
					Log.d(TAG, "pretty tree ....");
					toAdd = new Tree(getBaseContext());
				}
				else if ("Pinwheel".contentEquals(spinnerChoice)) {
					Log.d(TAG, "pinwheel");
					toAdd = new Pinwheel(getBaseContext());
				}
				else {
					Log.d(TAG, "NOTHING! ABSOLUTELY NOTHING!");
				}

				frame.addView(toAdd);
				frame.invalidate();
      }

			@Override
      public void onNothingSelected(AdapterView<?> parentView) {
	      return;
      }
		});

		FrameLayout frameLayout = ((FrameLayout)findViewById(R.id.frame));
		frameLayout.setBackgroundColor(Color.WHITE);
	}
}