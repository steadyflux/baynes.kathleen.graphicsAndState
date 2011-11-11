package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

public class TV extends ImageViewRube {

	/**
	 * TV states
	 */
	private enum State implements RubeState {
		NoPower, Standby, Wet, PowerOn, Fried
	}
	
	public TV(Context context) {
	  super(context);
	  currentState = State.NoPower;

		drawables.put(State.NoPower, context.getResources().getDrawable(R.drawable.tv_no_power));
		drawables.put(State.Standby, context.getResources().getDrawable(R.drawable.tv_standby));
		drawables.put(State.Wet, context.getResources().getDrawable(R.drawable.tv_wet));
		drawables.put(State.PowerOn, context.getResources().getDrawable(R.drawable.tv_power_on));
		drawables.put(State.Fried, context.getResources().getDrawable(R.drawable.tv_fried));
		
		addTransition(State.NoPower, Event.Water, State.Wet);
		addTransition(State.NoPower, Event.ElectricOn, State.Standby);
		
		addTransition(State.Standby, Event.Water, State.Fried);
		addTransition(State.Standby, Event.Turn, State.PowerOn);
		addTransition(State.Standby, Event.ElectricOff, State.NoPower);
		
		addTransition(State.Wet, Event.Heat, State.NoPower);
		addTransition(State.Wet, Event.ElectricOn, State.Fried);
		
		addTransition(State.PowerOn, Event.Pulse, State.PowerOn);
		addTransition(State.PowerOn, Event.Water, State.Fried);
		
		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.rubberband_intact);
  }

	/**
	 * returns "TV".
	 * 
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getItemName()
	 */
	@Override
	public String getItemName() {
		return "TV";
	}

}
