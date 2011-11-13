package baynes.kathleen.graphics.models;

import java.util.HashSet;
import java.util.Set;

import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

/**
 * The Class Wire.
 */
public abstract class Wire extends ImageViewRube {

	/**
	 * Wire states.
	 */
	protected enum State implements RubeState {

		/** The No current. */
		NoCurrent,
		/** The Wet. */
		Wet,
		/** The Has current. */
		HasCurrent,
		/** The Toasted. */
		Toasted,
		/** The Shorted. */
		Shorted

	}

	/**
	 * Instantiates a new wire.
	 * 
	 * @param context
	 *          the context
	 */
	public Wire(Context context) {
		super(context);
		currentState = State.NoCurrent;

		setupImages(context);

		addTransition(State.NoCurrent, Event.Water, State.Wet);
		addTransition(State.NoCurrent, Event.ElectricOn, State.HasCurrent);
		addTransition(State.NoCurrent, Event.Heat, State.Toasted);

		addTransition(State.HasCurrent, Event.ElectricOn, State.HasCurrent);
		addTransition(State.HasCurrent, Event.Heat, State.Toasted);
		addTransition(State.HasCurrent, Event.ElectricOff, State.NoCurrent);

		addTransition(State.Wet, Event.Heat, State.NoCurrent);
		addTransition(State.Wet, Event.ElectricOn, State.Shorted);

		this.setScaleType(ScaleType.CENTER);
	}

	/**
	 * Sets the up images.
	 * 
	 * @param context
	 *          the new up images
	 */
	protected abstract void setupImages(Context context);

	/**
	 * returns "Wire".
	 * 
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getItemName()
	 */
	@Override
	public String getItemName() {
		return "Wire";
	}

	/**
	 * returns events that this item responds to.
	 * 
	 * @param baseContext
	 *          the base context
	 * @return the events to process
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getEventsToProcess(android.content.Context)
	 */
	@Override
	public Set<Event> getEventsToProcess(Context baseContext) {
		Set<Event> eventsToProcess = new HashSet<Event>();
		eventsToProcess.add(Event.ElectricOn);
		eventsToProcess.add(Event.ElectricOff);
		eventsToProcess.add(Event.Heat);
		eventsToProcess.add(Event.Water);
		return eventsToProcess;
	}
}
