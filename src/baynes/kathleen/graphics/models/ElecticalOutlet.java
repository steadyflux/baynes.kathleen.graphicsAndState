package baynes.kathleen.graphics.models;

import java.util.HashSet;
import java.util.Set;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

/**
 * The Class ElecticalOutlet.
 */
public class ElecticalOutlet extends ImageViewRube {

	/**
	 * ElecticalOutlet states.
	 */
	private enum State implements RubeState {

		/** The On. */
		On,
		/** The Burnt. */
		Burnt,
		/** The Shocked. */
		Shocked
	}

	/**
	 * Instantiates a new electical outlet.
	 * 
	 * @param context
	 *          the context
	 */
	public ElecticalOutlet(Context context) {
		super(context);
		currentState = State.On;

		drawables.put(State.On, context.getResources().getDrawable(R.drawable.electric_outlet_on));
		drawables.put(State.Burnt, context.getResources().getDrawable(R.drawable.electric_outlet_burnt));
		drawables.put(State.Shocked, context.getResources().getDrawable(R.drawable.electric_outlet_shocked));

		addTransition(State.On, Event.Pulse, State.On);
		addTransition(State.On, Event.Heat, State.Burnt);
		addTransition(State.On, Event.Water, State.Shocked);

		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.electric_outlet_on);
	}

	/**
	 * returns "ElecticalOutlet".
	 * 
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getItemName()
	 */
	@Override
	public String getItemName() {
		return "ElecticalOutlet";
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
		eventsToProcess.add(Event.Heat);
		eventsToProcess.add(Event.Water);
		eventsToProcess.add(Event.Pulse);
		return eventsToProcess;
	}
}
