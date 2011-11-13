package baynes.kathleen.graphics.models;

import java.util.HashSet;
import java.util.Set;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

/**
 * The Class Candle.
 */
public class Candle extends ImageViewRube {

	/**
	 * Candle states.
	 */
	private enum State implements RubeState {

		/** The Unlit. */
		Unlit,
		/** The Burning. */
		Burning

	}

	/**
	 * Instantiates a new candle, setting up initial state, drawable hash and
	 * state machine.
	 * 
	 * @param context
	 *          the context
	 */
	public Candle(Context context) {
		super(context);
		currentState = State.Unlit;

		drawables.put(State.Unlit, context.getResources().getDrawable(R.drawable.candle_unlit));
		drawables.put(State.Burning, context.getResources().getDrawable(R.drawable.candle_burning));

		addTransition(State.Unlit, Event.Heat, State.Burning);
		addTransition(State.Unlit, Event.Start, State.Burning);

		addTransition(State.Burning, Event.Pulse, State.Burning);
		addTransition(State.Burning, Event.Water, State.Unlit);

		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.candle_unlit);
	}

	/**
	 * returns "Candle".
	 * 
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getItemName()
	 */
	@Override
	public String getItemName() {
		return "Candle";
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
		eventsToProcess.add(Event.Start);
		eventsToProcess.add(Event.Heat);
		eventsToProcess.add(Event.Water);
		eventsToProcess.add(Event.Pulse);
		return eventsToProcess;
	}
}
