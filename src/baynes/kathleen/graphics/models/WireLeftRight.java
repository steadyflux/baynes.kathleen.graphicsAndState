package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.R;
import android.content.Context;

public class WireLeftRight extends Wire {

	public WireLeftRight(Context context) {
	  super(context);
  }

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
