package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;
import baynes.kathleen.graphics.util.RubeState;
import android.content.Context;

public class Rope extends ImageViewRube {

	/**
	 * Rope states
	 */
	private enum State implements RubeState {
		Slack, BurningSlack, Taut, BurningTaut, Ashes
	}

	public Rope(Context context) {
		super(context);
		currentState = State.Slack;

		drawables.put(State.Slack, context.getResources().getDrawable(R.drawable.rope_slack_up_right));
		drawables.put(State.BurningSlack, context.getResources().getDrawable(R.drawable.rope_burning_slack_up_right));
		drawables.put(State.Taut, context.getResources().getDrawable(R.drawable.rope_taut_up_right));
		drawables.put(State.BurningTaut, context.getResources().getDrawable(R.drawable.rope_burning_taut_up_right));

		addTransition(State.Slack, Event.Heat, State.BurningSlack);
		addTransition(State.Slack, Event.Pull, State.Taut);

		addTransition(State.BurningSlack, Event.Water, State.Slack);
		addTransition(State.BurningSlack, Event.Heat, State.Ashes);

		addTransition(State.Taut, Event.Release, State.Slack);
		addTransition(State.Taut, Event.Pull, State.Taut);
		addTransition(State.Taut, Event.Heat, State.BurningTaut);
		
		addTransition(State.BurningTaut, Event.Water, State.Taut);
		addTransition(State.BurningTaut, Event.Heat, State.Ashes);

		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.rope_slack_up_right);
	}

	/**
	 * returns "Rope".
	 * 
	 * @return the item name
	 * @see baynes.kathleen.graphics.models.ImageViewRube#getItemName()
	 */
	@Override
	public String getItemName() {
		return "Rope";
	}

}
