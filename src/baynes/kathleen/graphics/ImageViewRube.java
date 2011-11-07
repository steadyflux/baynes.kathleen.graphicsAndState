package baynes.kathleen.graphics;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

// TODO: Auto-generated Javadoc
/**
 * The Class ImageViewRube.
 */
public class ImageViewRube extends ImageView implements RubeItem {

	/** Used in logging. */
	protected static final String TAG = "baynes.kathleen.graphics";
	
	/** The current state. */
	protected State currentState;
	
	/** The drawables, map state to image. */
	protected Map<State, Drawable> drawables = new HashMap<State, Drawable>();
	
	/** The transitions between states and the events that cause them. */
	protected Map<State, Map<Event, State>> transitions = new HashMap<State, Map<Event, State>>();

	/**
	 * Instantiates a new image view rube.
	 *
	 * @param context the context
	 */
	public ImageViewRube(Context context) {
		super(context);
	}

	/**
	 * Adds the transition to the state machine.
	 *
	 * @param currentState the current state
	 * @param event the event
	 * @param nextState the next state
	 */
	public void addTransition(State currentState, Event event, State nextState) {
		Map<Event, State> transitionMap = (transitions.get(currentState) == null) ? new HashMap<Event, State>()
		    : transitions.get(currentState);
		transitionMap.put(event, nextState);
		transitions.put(currentState, transitionMap);
	}

	/**
	 * 
	 *  returns the view to be drawn on the FrameLayout
	 *  
	 * @see baynes.kathleen.graphics.RubeItem#getNextStateView(baynes.kathleen.graphics.Event)
	 */
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
  
	/**
	 * puts the image on the canvas
	 * @see android.widget.ImageView#onDraw(android.graphics.Canvas)
	 */
	@Override protected void onDraw(Canvas canvas) {
		Log.d(TAG, "a transitioning rube is drawn");
		Log.d(TAG, "current state: " + currentState.toString());
		this.setImageDrawable(drawables.get(currentState));
		super.onDraw(canvas);
	}

	/** 
	 * returns the name of this item
	 * @see baynes.kathleen.graphics.RubeItem#getItemName()
	 */
	@Override
  public String getItemName() {
	  return "ImageViewRube";
  }

	/**
	 * returns the current state
	 * @see baynes.kathleen.graphics.RubeItem#getCurrentState()
	 */
	@Override
  public CharSequence getCurrentState() {
	  return currentState.toString();
  }
}
