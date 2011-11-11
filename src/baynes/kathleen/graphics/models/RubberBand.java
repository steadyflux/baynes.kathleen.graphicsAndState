package baynes.kathleen.graphics.models;

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

}
