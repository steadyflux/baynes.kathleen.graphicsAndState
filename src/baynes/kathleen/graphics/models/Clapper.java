package baynes.kathleen.graphics.models;

import java.util.HashSet;
import java.util.Set;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

/**
 * The Class Clapper.
 */
public class Clapper extends ImageViewRube {
	
	/**
	 * Clapper states.
	 */
	private enum State implements RubeState {
		
		/** The Power off. */
		PowerOff, 
 /** The Switch off. */
 SwitchOff, 
 /** The Switch on. */
 SwitchOn, 
 /** The Wet. */
 Wet, 
 /** The Fried. */
 Fried

	}
	
	/**
	 * Instantiates a new clapper.
	 *
	 * @param context the context
	 */
	public Clapper(Context context) {
	  super(context);
		currentState = State.PowerOff;

		drawables.put(State.PowerOff, context.getResources().getDrawable(R.drawable.clapper_power_off));
		drawables.put(State.SwitchOff, context.getResources().getDrawable(R.drawable.clapper_switch_off));
		drawables.put(State.SwitchOn, context.getResources().getDrawable(R.drawable.clapper_switch_on));
		drawables.put(State.Wet, context.getResources().getDrawable(R.drawable.clapper_wet));
		drawables.put(State.Fried, context.getResources().getDrawable(R.drawable.clapper_fried));
	  
		addTransition(State.PowerOff, Event.Heat, State.Fried);
		addTransition(State.PowerOff, Event.ElectricOn, State.SwitchOff);
		addTransition(State.PowerOff, Event.Water, State.Wet);

		addTransition(State.SwitchOff, Event.Water, State.Fried);
		addTransition(State.SwitchOff, Event.Heat, State.Fried);
		addTransition(State.SwitchOff, Event.Clap, State.SwitchOn);
		addTransition(State.SwitchOff, Event.ElectricOff, State.PowerOff);
		
		addTransition(State.Wet, Event.Heat, State.PowerOff);
		addTransition(State.Wet, Event.ElectricOn, State.Fried);
		
		addTransition(State.SwitchOn, Event.Clap, State.SwitchOff);
		addTransition(State.SwitchOn, Event.Water, State.Fried);
		addTransition(State.SwitchOn, Event.Heat, State.Fried);
		addTransition(State.SwitchOn, Event.ElectricOn, State.SwitchOn);
		addTransition(State.SwitchOn, Event.ElectricOff, State.PowerOff);
		
		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.clapper_power_off);
  }

	/**
	 * returns "Clapper".
	 * 
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getItemName()
	 */
	@Override
	public String getItemName() {
		return "Clapper";
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
		eventsToProcess.add(Event.ElectricOn);
		eventsToProcess.add(Event.ElectricOff);
		eventsToProcess.add(Event.Heat);
		eventsToProcess.add(Event.Water);
		eventsToProcess.add(Event.Clap);
		return eventsToProcess;
  }
}
