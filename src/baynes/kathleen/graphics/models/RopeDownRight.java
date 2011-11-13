package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.R;
import android.content.Context;

/**
 * The Class RopeDownRight.
 */
public class RopeDownRight extends Rope {

	/**
	 * Instantiates a new rope down right.
	 *
	 * @param context the context
	 */
	public RopeDownRight(Context context) {
		super(context);
	}

	/**
	 * sets up images for this rope subclass
	 * @see baynes.kathleen.graphics.models.Rope#setupImages(android.content.Context)
	 */
	@Override
  protected void setupImages(Context context) {
		drawables.put(State.Slack, context.getResources().getDrawable(R.drawable.rope_slack_down_right));
		drawables.put(State.BurningSlack, context.getResources().getDrawable(R.drawable.rope_burning_slack_down_right));
		drawables.put(State.Taut, context.getResources().getDrawable(R.drawable.rope_taut_down_right));
		drawables.put(State.BurningTaut, context.getResources().getDrawable(R.drawable.rope_burning_taut_down_right));
		
		this.setImageResource(R.drawable.rope_slack_down_right);
  }

}
