package baynes.kathleen.graphics;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public abstract class Sprite extends View {

	protected State currentState;
	protected Map<State, Drawable> drawables = new HashMap<State, Drawable>();
	protected Map<State, Map<Event, State>> transitions = new HashMap<State, Map<Event, State>>();

	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public Sprite(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		throw new UnsupportedOperationException();
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public Sprite(Context context, AttributeSet attrs) {
		super(context, attrs);
		throw new UnsupportedOperationException();
	}

	/**
	 * @param context
	 */
	public Sprite(Context context) {
		super(context);
	}

	public void addTransition(State currentState, Event event, State nextState) {
		Map<Event, State> transitionMap = (transitions.get(currentState) == null) ? new HashMap<Event, State>()
		    : transitions.get(currentState);
		transitionMap.put(event, nextState);
	}

	public void getNextState(Event event) {
		if (transitions.get(currentState) != null) {
			if (transitions.get(currentState).get(event) != null) {
				currentState = transitions.get(currentState).get(event);
			}
		}
	}
}
