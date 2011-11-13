package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.R;
import android.content.Context;

public class RopeDownRight extends Rope {

	public RopeDownRight(Context context) {
		super(context);
	}

	@Override
  protected void setupImages(Context context) {
		drawables.put(State.Slack, context.getResources().getDrawable(R.drawable.rope_slack_down_right));
		drawables.put(State.BurningSlack, context.getResources().getDrawable(R.drawable.rope_burning_slack_down_right));
		drawables.put(State.Taut, context.getResources().getDrawable(R.drawable.rope_taut_down_right));
		drawables.put(State.BurningTaut, context.getResources().getDrawable(R.drawable.rope_burning_taut_down_right));
		
		this.setImageResource(R.drawable.rope_slack_down_right);
  }

}
