package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.R;
import android.content.Context;

/**
 * The Class WireLeftRight.
 */
public class WireLeftRight extends Wire {

	/**
	 * Instantiates a new wire left right.
	 * 
	 * @param context
	 *          the context
	 */
	public WireLeftRight(Context context) {
		super(context);
	}

	/**
	 * sets up images for this wire subclass
	 * 
	 * @see baynes.kathleen.graphics.models.Wire#setupImages(android.content.Context)
	 */
	@Override
	protected void setupImages(Context context) {
		drawables.put(State.NoCurrent, context.getResources().getDrawable(R.drawable.wire_no_current_left_right));
		drawables.put(State.Wet, context.getResources().getDrawable(R.drawable.wire_wet_left_right));
		drawables.put(State.HasCurrent, context.getResources().getDrawable(R.drawable.wire_has_current_left_right));
		drawables.put(State.Toasted, context.getResources().getDrawable(R.drawable.wire_toasted_left_right));
		drawables.put(State.Shorted, context.getResources().getDrawable(R.drawable.wire_shorted_left_right));

		this.setImageResource(R.drawable.wire_no_current_left_right);
	}

}
