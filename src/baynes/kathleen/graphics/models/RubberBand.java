package baynes.kathleen.graphics.models;

import java.util.HashSet;
import java.util.Set;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

public class RubberBand extends ImageViewRube {

	/**
	 * RubberBand states
	 */
	private enum State implements RubeState {
		Intact, Melted
	}
	
	public RubberBand(Context context) {
	  super(context);
	  currentState = State.Intact;

		drawables.put(State.Intact, context.getResources().getDrawable(R.drawable.rubberband_intact));
		drawables.put(State.Melted, context.getResources().getDrawable(R.drawable.rubberband_melted));
		
		addTransition(State.Intact, Event.Turn, State.Intact);
		addTransition(State.Intact, Event.Heat, State.Melted);
		
		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.rubberband_intact);
  }

	/**
	 * returns "RubberBand".
	 * 
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getItemName()
	 */
	@Override
	public String getItemName() {
		return "RubberBand";
	}

	/**
	 * 
	 * returns events that this item responds to
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getEventsToProcess(android.content.Context)
	 */
	@Override
  public Set<Event> getEventsToProcess(Context baseContext) {
		Set<Event> eventsToProcess = new HashSet<Event>();
		eventsToProcess.add(Event.Turn);
		eventsToProcess.add(Event.Heat);
		return eventsToProcess;
  }
}
