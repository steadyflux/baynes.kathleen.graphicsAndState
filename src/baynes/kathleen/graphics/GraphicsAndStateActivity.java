package baynes.kathleen.graphics;

import baynes.kathleen.graphics.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * The Class GraphicsAndStateActivity. Main activity for assignment
 */
public class GraphicsAndStateActivity extends Activity {
	
	/** The Constant TAG. */
	protected static final String TAG = "baynes.kathleen.graphics";
	
	/**
	 * part of activity creation
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		FrameLayout frameLayout = ((FrameLayout)findViewById(R.id.frame));
		frameLayout.setBackgroundColor(Color.WHITE);
		
		setupRubeSelector();

		setUpButton(R.id.water_button, Event.Water);
		setUpButton(R.id.heat_button, Event.Heat);
		setUpButton(R.id.pulse_button, Event.Pulse);
		setUpButton(R.id.steam_button, Event.Steam);
		setUpButton(R.id.alex_button, Event.Alex);
		setUpButton(R.id.electric_on_button, Event.ElectricOn);
		setUpButton(R.id.electric_off_button, Event.ElectricOff);
	}

	/**
	 * attachs an event to a button button.
	 *
	 * @param button_id the button_id
	 * @param associatedEvent the associated event
	 */
	private void setUpButton(int button_id, final Event associatedEvent) {
	  Button button = (Button) findViewById(button_id);
	  button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				FrameLayout frame = ((FrameLayout)findViewById(R.id.frame));
				View updatedView = ((RubeItem)frame.getChildAt(0)).getNextStateView(associatedEvent);
				clearFrame(frame);
				frame.addView(updatedView);
				((TextView) findViewById(R.id.current_state)).setText(((RubeItem) updatedView).getCurrentState());
				frame.invalidate();
			}
		});
  }

	/**
	 * Setup rube selector. This connects the spinner select to the images in the frame
	 */
	private void setupRubeSelector() {
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
				clearFrame(frame);
				
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
				
				((TextView) findViewById(R.id.current_state)).setText(((RubeItem) toAdd).getCurrentState());
      }

			@Override
      public void onNothingSelected(AdapterView<?> parentView) {
	      return;
      }
		});
  }
	
	/**
	 * Clear frame, clears any animations and removes all views from the frame 
	 *
	 * @param frame the frame to be cleared
	 */
	public static void clearFrame(FrameLayout frame) {
    if (frame.getChildCount() > 0) {
			for (int i = 0; i < frame.getChildCount(); i++) {
				View currentView = frame.getChildAt(i);
				currentView.clearAnimation(); 
				frame.removeViewInLayout(currentView);
      }
		}
  }
}