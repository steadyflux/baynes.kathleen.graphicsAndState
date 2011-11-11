package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

public class Kettle extends ImageViewRube {
	/**
	 * Kettle states
	 */
	private enum State implements RubeState {
		Empty, Hot, Full
	}
	
	public Kettle(Context context) {
	  super(context);
	  currentState = State.Empty;

		drawables.put(State.Empty, context.getResources().getDrawable(R.drawable.kettle_empty));
		drawables.put(State.Hot, context.getResources().getDrawable(R.drawable.kettle_hot));
		drawables.put(State.Full, context.getResources().getDrawable(R.drawable.kettle_full));
		
		addTransition(State.Empty, Event.Heat, State.Hot);
		addTransition(State.Empty, Event.Water, State.Full);
		
		addTransition(State.Hot, Event.Water, State.Full);
		
		addTransition(State.Full, Event.Heat, State.Full);
		addTransition(State.Full, Event.Steam, State.Full);
		
		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.kettle_empty);
  }

	/**
	 * returns "Kettle".
	 * 
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getItemName()
	 */
	@Override
	public String getItemName() {
		return "Kettle";
	}

}
