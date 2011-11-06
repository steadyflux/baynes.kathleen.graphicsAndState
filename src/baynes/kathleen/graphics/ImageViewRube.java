package baynes.kathleen.graphics;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ImageViewRube extends ImageView implements RubeItem {

	/** Used in logging */
	protected static final String TAG = "baynes.kathleen.graphics";
	
	protected State currentState;
	protected Map<State, Drawable> drawables = new HashMap<State, Drawable>();
	protected Map<State, Map<Event, State>> transitions = new HashMap<State, Map<Event, State>>();

	/**
	 * @param context
	 */
	public ImageViewRube(Context context) {
		super(context);
	}

	public void addTransition(State currentState, Event event, State nextState) {
		Map<Event, State> transitionMap = (transitions.get(currentState) == null) ? new HashMap<Event, State>()
		    : transitions.get(currentState);
		transitionMap.put(event, nextState);
		transitions.put(currentState, transitionMap);
	}

	public View getNextStateView(Event event) {
		Log.d(TAG, "getNextStateView: Total number of transitions for " + getItemName() + " = " + transitions.size());
		if (transitions.get(currentState) != null) {
			if (transitions.get(currentState).get(event) != null) {
				currentState = transitions.get(currentState).get(event);
			}
		}
		this.setImageDrawable(drawables.get(currentState));
		return this;
	}
  
	@Override protected void onDraw(Canvas canvas) {
		Log.d(TAG, "a transitioning rube is drawn");
		Log.d(TAG, "current state: " + currentState.toString());
		this.setImageDrawable(drawables.get(currentState));
		super.onDraw(canvas);
	}

	@Override
  public String getItemName() {
	  return "ImageViewRube";
  }

	@Override
  public CharSequence getCurrentState() {
	  return currentState.toString();
  }
}
