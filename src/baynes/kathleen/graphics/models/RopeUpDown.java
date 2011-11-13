package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.R;
import android.content.Context;

/**
 * The Class RopeUpDown.
 */
public class RopeUpDown extends Rope {

	/**
	 * Instantiates a new rope up down.
	 * 
	 * @param context
	 *          the context
	 */
	public RopeUpDown(Context context) {
		super(context);

	}

	/**
	 * sets up images for this rope subclass
	 * 
	 * @see baynes.kathleen.graphics.models.Rope#setupImages(android.content.Context)
	 */
	@Override
	protected void setupImages(Context context) {
		drawables.put(State.Slack, context.getResources().getDrawable(R.drawable.rope_slack_up_down));
		drawables.put(State.BurningSlack, context.getResources().getDrawable(R.drawable.rope_burning_slack_up_down));
		drawables.put(State.Taut, context.getResources().getDrawable(R.drawable.rope_taut_up_down));
		drawables.put(State.BurningTaut, context.getResources().getDrawable(R.drawable.rope_burning_taut_up_down));

		this.setImageResource(R.drawable.rope_slack_up_down);
	}
}
