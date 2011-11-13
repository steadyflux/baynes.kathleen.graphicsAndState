package baynes.kathleen.graphics.models;

import java.util.HashSet;
import java.util.Set;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;

import android.content.Context;

// TODO: Auto-generated Javadoc
/**
 * The Class ChristmasTree.
 */
public class ChristmasTree extends ImageViewRube {

	/**
	 * ChristmasTree State.
	 */
	private enum State implements RubeState {

		/** The Unlit. */
		Unlit,
		/** The Lit. */
		Lit,
		/** The Burning. */
		Burning,
		/** The Wet. */
		Wet,
		/** The Fried. */
		Fried
	}

	/**
	 * Instantiates a new tree, setting up initial state, drawable hash and state
	 * machine.
	 * 
	 * @param context
	 *          the context
	 */
	public ChristmasTree(Context context) {
		super(context);
		currentState = State.Unlit;

		drawables.put(State.Unlit, context.getResources().getDrawable(R.drawable.tree_unlit));
		drawables.put(State.Lit, context.getResources().getDrawable(R.drawable.tree_lit));
		drawables.put(State.Burning, context.getResources().getDrawable(R.drawable.tree_burning));
		drawables.put(State.Fried, context.getResources().getDrawable(R.drawable.tree_burnt));
		drawables.put(State.Wet, context.getResources().getDrawable(R.drawable.tree_wet));

		addTransition(State.Wet, Event.Heat, State.Unlit);
		addTransition(State.Wet, Event.ElectricOn, State.Fried);

		addTransition(State.Burning, Event.Heat, State.Fried);
		addTransition(State.Burning, Event.Water, State.Unlit);
		addTransition(State.Burning, Event.Pulse, State.Fried);

		addTransition(State.Unlit, Event.ElectricOn, State.Lit);
		addTransition(State.Unlit, Event.Water, State.Wet);
		addTransition(State.Unlit, Event.Heat, State.Burning);

		addTransition(State.Lit, Event.ElectricOff, State.Unlit);
		addTransition(State.Lit, Event.Heat, State.Burning);
		addTransition(State.Lit, Event.Water, State.Fried);

		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.tree_unlit);
	}

	/**
	 * returns "Tree".
	 * 
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getItemName()
	 */
	@Override
	public String getItemName() {
		return "Tree";
	}
	
	/**
	 * 
	 * returns events that this item responds to
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getEventsToProcess(android.content.Context)
	 */
	@Override
  public Set<Event> getEventsToProcess(Context baseContext) {
		Set<Event> eventsToProcess = new HashSet<Event>();
		eventsToProcess.add(Event.ElectricOn);
		eventsToProcess.add(Event.ElectricOff);
		eventsToProcess.add(Event.Heat);
		eventsToProcess.add(Event.Water);
		eventsToProcess.add(Event.Pulse);
		return eventsToProcess;
  }	
}
