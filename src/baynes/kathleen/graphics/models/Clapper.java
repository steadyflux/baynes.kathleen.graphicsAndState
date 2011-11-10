package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

public class Clapper extends ImageViewRube {
	
	/**
	 * Clapper states
	 */
	private enum State implements RubeState {
		PowerOff, SwitchOff, SwitchOn, Wet, Fried

	}
	
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
}
