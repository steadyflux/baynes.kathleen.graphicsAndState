package baynes.kathleen.graphics.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * The Class ImageViewRube.
 */
public class ImageViewRube extends ImageView implements RubeItem {

	/** Used in logging. */
	protected static final String TAG = "baynes.kathleen.graphics";
	
	/** The current state. */
	protected RubeState currentState;
	
	/** The drawables, map state to image. */
	protected Map<RubeState, Drawable> drawables = new HashMap<RubeState, Drawable>();
	
	/** The transitions between states and the events that cause them. */
	protected Map<RubeState, Map<Event, RubeState>> transitions = new HashMap<RubeState, Map<Event, RubeState>>();

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
	public void addTransition(RubeState currentState, Event event, RubeState nextState) {
		Map<Event, RubeState> transitionMap = (transitions.get(currentState) == null) ? new HashMap<Event, RubeState>()
		    : transitions.get(currentState);
		transitionMap.put(event, nextState);
		transitions.put(currentState, transitionMap);
	}

	/**
	 * returns the view to be drawn on the FrameLayout.
	 *
	 * @param event the event
	 * @return the next state view
	 * @see baynes.kathleen.graphics.models.RubeItem#getNextStateView(baynes.kathleen.graphics.util.Event)
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
	 * puts the image on the canvas.
	 *
	 * @param canvas the canvas
	 * @see android.widget.ImageView#onDraw(android.graphics.Canvas)
	 */
	@Override protected void onDraw(Canvas canvas) {
		Log.d(TAG, "a transitioning rube is drawn");
		Log.d(TAG, "current state: " + currentState.toString());
		this.setImageDrawable(drawables.get(currentState));
		super.onDraw(canvas);
	}

	/**
	 * returns the name of this item.
	 *
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.RubeItem#getItemName()
	 */
	@Override
  public String getItemName() {
	  return "ImageViewRube";
  }

	/**
	 * returns the current state.
	 *
	 * @return the current state
	 * @see baynes.kathleen.graphics.models.RubeItem#getCurrentState()
	 */
	@Override
  public CharSequence getCurrentState() {
	  return currentState.toString();
  }

	/**
	 * returns all events ... this shouldnt happen
	 * @see baynes.kathleen.graphics.models.RubeItem#getEventsToProcess(android.content.Context)
	 */
	@Override
  public Set<Event> getEventsToProcess(Context baseContext) {
		return Event.getAllEvents();
  }

}
