package baynes.kathleen.graphics;

import java.util.Set;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.models.RubeItem;
import baynes.kathleen.graphics.models.RubeItemFactory;
import baynes.kathleen.graphics.util.Event;
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
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * The Class GraphicsAndStateActivity. Main activity for assignment
 */
public class GraphicsAndStateActivity extends Activity {
	
	/** The Constant TAG. */
	protected static final String TAG = "baynes.kathleen.graphics";
	
	/**
	 * part of activity creation.
	 *
	 * @param savedInstanceState the saved instance state
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		FrameLayout frameLayout = ((FrameLayout)findViewById(R.id.frame));
		frameLayout.setBackgroundColor(Color.WHITE);
		
		setupRubeSelector();

	}


	/**
	 * attaches an event to a button button.
	 *
	 * @param button_id the button_id
	 * @param associatedEvent the associated event
	 */
	private void setUpButton(Button button, final Event associatedEvent) {
	  button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				FrameLayout frame = ((FrameLayout)findViewById(R.id.frame));
				RubeItem currentView = ((RubeItem)frame.getChildAt(0));
				CharSequence oldState = currentView.getCurrentState();
				View updatedView = currentView.getNextStateView(associatedEvent);
				
				//only clear the frame and update if the state has changed
				if (oldState != (((RubeItem) updatedView).getCurrentState())) {
					clearFrame(frame);
					frame.addView(updatedView);
					((TextView) findViewById(R.id.current_state)).setText(((RubeItem) updatedView).getCurrentState());
					frame.invalidate();
				}
				
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
				
				Log.d(TAG,"Position selection: " + position);
				CharSequence spinnerChoice = ((TextView)selectedItemView).getText();
				Log.d(TAG, "spinner item selected: " + spinnerChoice);
				
				FrameLayout frame = ((FrameLayout)findViewById(R.id.frame));
				clearFrame(frame);
				
				clearButtons();
				
				RubeItem toAdd = RubeItemFactory.getRubeItemView(position, getBaseContext());
				Set<Event> events = toAdd.getEventsToProcess(getBaseContext());
				
				for (Event event : events) {
					addButtonForEvent(event);
				}
				
				frame.addView((View)toAdd);
				frame.invalidate();
				
				((TextView) findViewById(R.id.current_state)).setText(((RubeItem) toAdd).getCurrentState());
      }

			private void addButtonForEvent(Event event) {
				LinearLayout buttonBar = ((LinearLayout) findViewById(R.id.button_bar));
	      Button button = new Button(getBaseContext());
	      button.setText(event.getStringNameResource());
	      setUpButton(button, event);
	      buttonBar.addView(button);
	      buttonBar.invalidate();
      }

			private void clearButtons() {
	      LinearLayout buttonBar = ((LinearLayout) findViewById(R.id.button_bar));
	      buttonBar.removeAllViews();
      }

			@Override
      public void onNothingSelected(AdapterView<?> parentView) {
	      return;
      }
		});
  }
	
	/**
	 * Clear frame, clears any animations and removes all views from the frame.
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