package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

public class Wire extends ImageViewRube {

	/**
	 * Wire states
	 */
	private enum State implements RubeState {
	  NoCurrent, Wet, HasCurrent, Toasted, Shorted
		
	}
	
	public Wire(Context context) {
	  super(context);
	  currentState = State.NoCurrent;

	  drawables.put(State.NoCurrent, context.getResources().getDrawable(R.drawable.wire_no_current_up_down));
		drawables.put(State.Wet, context.getResources().getDrawable(R.drawable.wire_wet_up_down));
		drawables.put(State.HasCurrent, context.getResources().getDrawable(R.drawable.wire_has_current_up_down));
		drawables.put(State.Toasted, context.getResources().getDrawable(R.drawable.wire_toasted_up_down));
		drawables.put(State.Shorted, context.getResources().getDrawable(R.drawable.wire_shorted_up_down));
		
		addTransition(State.NoCurrent, Event.Water, State.Wet);
		addTransition(State.NoCurrent, Event.ElectricOn, State.HasCurrent);
		addTransition(State.NoCurrent, Event.Heat, State.Toasted);
		
		addTransition(State.HasCurrent, Event.ElectricOn, State.HasCurrent);
		addTransition(State.HasCurrent, Event.Heat, State.Toasted);
		addTransition(State.HasCurrent, Event.ElectricOff, State.NoCurrent);
		
		addTransition(State.Wet, Event.Heat, State.NoCurrent);
		addTransition(State.Wet, Event.ElectricOn, State.Shorted);
		
		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.wire_no_current_up_down);
  }

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
}
