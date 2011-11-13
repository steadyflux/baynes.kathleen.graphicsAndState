package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.R;
import android.content.Context;

/**
 * The Class WireUpDown.
 */
public class WireUpDown extends Wire {

	/**
	 * Instantiates a new wire up down.
	 *
	 * @param context the context
	 */
	public WireUpDown(Context context) {
	  super(context);
  }

	/**
	 * sets up images for this wire subclass
	 * @see baynes.kathleen.graphics.models.Wire#setupImages(android.content.Context)
	 */
	@Override
	protected void setupImages(Context context) {
	  drawables.put(State.NoCurrent, context.getResources().getDrawable(R.drawable.wire_no_current_up_down));
		drawables.put(State.Wet, context.getResources().getDrawable(R.drawable.wire_wet_up_down));
		drawables.put(State.HasCurrent, context.getResources().getDrawable(R.drawable.wire_has_current_up_down));
		drawables.put(State.Toasted, context.getResources().getDrawable(R.drawable.wire_toasted_up_down));
		drawables.put(State.Shorted, context.getResources().getDrawable(R.drawable.wire_shorted_up_down));
		
		this.setImageResource(R.drawable.wire_no_current_up_down);
		}

}
