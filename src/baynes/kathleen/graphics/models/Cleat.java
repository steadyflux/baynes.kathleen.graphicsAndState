package baynes.kathleen.graphics.models;

import java.util.HashSet;
import java.util.Set;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

/**
 * The Class Cleat.
 */
public class Cleat extends ImageViewRube {

	/**
	 * Cleat states.
	 */
	private enum State implements RubeState {
		
		/** The Exists. */
		Exists
	}
	
	/**
	 * Instantiates a new cleat.
	 *
	 * @param context the context
	 */
	public Cleat(Context context) {
	  super(context);
	  
	  currentState = State.Exists;

		drawables.put(State.Exists, context.getResources().getDrawable(R.drawable.cleat_exists));
		
		addTransition(State.Exists, Event.Pulse, State.Exists);
		
		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.cleat_exists);
  }

	/**
	 * returns "Cleat".
	 * 
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getItemName()
	 */
	@Override
	public String getItemName() {
		return "Cleat";
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
		eventsToProcess.add(Event.Pulse);
		return eventsToProcess;
  }
}
