package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

public class Cleat extends ImageViewRube {

	/**
	 * Cleat states
	 */
	private enum State implements RubeState {
		Exists
	}
	
	public Cleat(Context context) {
	  super(context);
	  
	  currentState = State.Exists;

		drawables.put(State.Exists, context.getResources().getDrawable(R.drawable.cleat_exists));
		
		addTransition(State.Exists, Event.Pulse, State.Exists);
		
		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.cleat_exists);
  }

	/**
	 * returns "Cleat".
	 * 
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getItemName()
	 */
	@Override
	public String getItemName() {
		return "Cleat";
	}
}
