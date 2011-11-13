package baynes.kathleen.graphics.models;

import java.util.HashSet;
import java.util.Set;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

public class WaterCooler extends ImageViewRube {

	/**
	 * WaterCooler states
	 */
	private enum State implements RubeState {
		Empty, Full
	}
	
	public WaterCooler(Context context) {
	  super(context);
	  currentState = State.Empty;

		drawables.put(State.Empty, context.getResources().getDrawable(R.drawable.water_cooler_empty));
		drawables.put(State.Full, context.getResources().getDrawable(R.drawable.water_cooler_full));
		
		addTransition(State.Empty, Event.Release, State.Full);
		addTransition(State.Full, Event.Pull, State.Empty);
		
		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.rubberband_intact);
  }

	/**
	 * returns "WaterCooler".
	 * 
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getItemName()
	 */
	@Override
	public String getItemName() {
		return "WaterCooler";
	}
	
	/**
	 * 
	 * returns events that this item responds to
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getEventsToProcess(android.content.Context)
	 */
	@Override
  public Set<Event> getEventsToProcess(Context baseContext) {
		Set<Event> eventsToProcess = new HashSet<Event>();
		eventsToProcess.add(Event.Release);
		eventsToProcess.add(Event.Pull);
		return eventsToProcess;
  }
}
