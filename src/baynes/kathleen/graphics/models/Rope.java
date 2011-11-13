package baynes.kathleen.graphics.models;

import java.util.HashSet;
import java.util.Set;

import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

public abstract class Rope extends ImageViewRube {

	/**
	 * Rope states
	 */
	protected enum State implements RubeState {
		Slack, BurningSlack, Taut, BurningTaut, Ashes
	}

	public Rope(Context context) {
		super(context);
		currentState = State.Slack;

		setupImages(context);

		addTransition(State.Slack, Event.Heat, State.BurningSlack);
		addTransition(State.Slack, Event.Pull, State.Taut);

		addTransition(State.BurningSlack, Event.Water, State.Slack);
		addTransition(State.BurningSlack, Event.Heat, State.Ashes);

		addTransition(State.Taut, Event.Release, State.Slack);
		addTransition(State.Taut, Event.Pull, State.Taut);
		addTransition(State.Taut, Event.Heat, State.BurningTaut);
		
		addTransition(State.BurningTaut, Event.Water, State.Taut);
		addTransition(State.BurningTaut, Event.Heat, State.Ashes);

		this.setScaleType(ScaleType.CENTER);
	}

	protected abstract void setupImages(Context context);

	/**
	 * returns "Rope".
	 * 
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getItemName()
	 */
	@Override
	public String getItemName() {
		return "Rope";
	}
	
	/**
	 * 
	 * returns events that this item responds to
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getEventsToProcess(android.content.Context)
	 */
	@Override
  public Set<Event> getEventsToProcess(Context baseContext) {
		Set<Event> eventsToProcess = new HashSet<Event>();
		eventsToProcess.add(Event.Water);
		eventsToProcess.add(Event.Heat);
		eventsToProcess.add(Event.Release);
		eventsToProcess.add(Event.Pull);
		return eventsToProcess;
  }
}
