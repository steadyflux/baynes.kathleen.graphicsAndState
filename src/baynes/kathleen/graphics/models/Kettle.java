package baynes.kathleen.graphics.models;

import java.util.HashSet;
import java.util.Set;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

/**
 * The Class Kettle.
 */
public class Kettle extends ImageViewRube {
	
	/**
	 * Kettle states.
	 */
	private enum State implements RubeState {
		
		/** The Empty. */
		Empty, 
 /** The Hot. */
 Hot, 
 /** The Full. */
 Full
	}
	
	/**
	 * Instantiates a new kettle.
	 *
	 * @param context the context
	 */
	public Kettle(Context context) {
	  super(context);
	  currentState = State.Empty;

		drawables.put(State.Empty, context.getResources().getDrawable(R.drawable.kettle_empty));
		drawables.put(State.Hot, context.getResources().getDrawable(R.drawable.kettle_hot));
		drawables.put(State.Full, context.getResources().getDrawable(R.drawable.kettle_full));
		
		addTransition(State.Empty, Event.Heat, State.Hot);
		addTransition(State.Empty, Event.Water, State.Full);
		
		addTransition(State.Hot, Event.Water, State.Full);
		
		addTransition(State.Full, Event.Heat, State.Full);
		addTransition(State.Full, Event.Steam, State.Full);
		
		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.kettle_empty);
  }

	/**
	 * returns "Kettle".
	 * 
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getItemName()
	 */
	@Override
	public String getItemName() {
		return "Kettle";
	}
	
	/**
	 * returns events that this item responds to.
	 *
	 * @param baseContext the base context
	 * @return the events to process
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getEventsToProcess(android.content.Context)
	 */
	@Override
  public Set<Event> getEventsToProcess(Context baseContext) {
		Set<Event> eventsToProcess = new HashSet<Event>();
		eventsToProcess.add(Event.Steam);
		eventsToProcess.add(Event.Heat);
		eventsToProcess.add(Event.Water);
		return eventsToProcess;
  }
}
