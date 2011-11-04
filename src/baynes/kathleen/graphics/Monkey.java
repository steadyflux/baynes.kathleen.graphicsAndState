package baynes.kathleen.graphics;

import android.content.Context;
import android.util.AttributeSet;

public class Monkey extends Sprite {

	public Monkey(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public Monkey(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public Monkey(Context context) {
		super(context);
		currentState = State.Bored;
		
		drawables.put(State.Bored, context.getResources().getDrawable(R.drawable.monkey_bored));
		drawables.put(State.Wet, context.getResources().getDrawable(R.drawable.monkey_wet));
		drawables.put(State.Burning, context.getResources().getDrawable(R.drawable.monkey_burning));
		drawables.put(State.Ashes, context.getResources().getDrawable(R.drawable.monkey_ashes));
		drawables.put(State.ClappingWide, context.getResources().getDrawable(R.drawable.monkey_clapping_wide));
		drawables.put(State.ClappingClosed, context.getResources().getDrawable(R.drawable.monkey_clapping_closed));
		drawables.put(State.WetClappingWide, context.getResources().getDrawable(R.drawable.monkey_wet_clapping_wide));
		drawables.put(State.WetClappingClosed, context.getResources().getDrawable(R.drawable.monkey_wet_clapping_closed));
		
		addTransition(State.Bored, Event.Alex, State.ClappingWide);
		addTransition(State.Bored, Event.Water, State.Wet);
		addTransition(State.Bored, Event.Heat, State.Burning);
		
		addTransition(State.Wet, Event.Alex, State.WetClappingWide);
		addTransition(State.Wet, Event.Heat, State.Bored);
		
		addTransition(State.Burning, Event.Heat, State.Ashes);
		addTransition(State.Burning, Event.Water, State.Bored);
		
		addTransition(State.ClappingWide, Event.Alex, State.ClappingClosed);
		addTransition(State.ClappingWide, Event.Water, State.WetClappingWide);
		addTransition(State.ClappingWide, Event.Heat, State.Burning);
		
		addTransition(State.ClappingClosed, Event.Alex, State.ClappingWide);
		addTransition(State.ClappingClosed, Event.Water, State.WetClappingClosed);
		addTransition(State.ClappingClosed, Event.Heat, State.Burning);
		
		addTransition(State.WetClappingClosed, Event.Alex, State.WetClappingWide);
		addTransition(State.WetClappingClosed, Event.Heat, State.ClappingClosed);
		
		addTransition(State.WetClappingWide, Event.Alex, State.WetClappingClosed);
		addTransition(State.WetClappingWide, Event.Heat, State.ClappingWide);
		
	}
}
