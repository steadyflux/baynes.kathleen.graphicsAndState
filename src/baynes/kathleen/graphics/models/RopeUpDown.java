package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.R;
import android.content.Context;

public class RopeUpDown extends Rope {

	public RopeUpDown(Context context) {
		super(context);

	}

	@Override
  protected void setupImages(Context context) {
		drawables.put(State.Slack, context.getResources().getDrawable(R.drawable.rope_slack_up_down));
		drawables.put(State.BurningSlack, context.getResources().getDrawable(R.drawable.rope_burning_slack_up_down));
		drawables.put(State.Taut, context.getResources().getDrawable(R.drawable.rope_taut_up_down));
		drawables.put(State.BurningTaut, context.getResources().getDrawable(R.drawable.rope_burning_taut_up_down));
		
		this.setImageResource(R.drawable.rope_slack_up_down);
  }
}
