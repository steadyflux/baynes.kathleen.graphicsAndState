package baynes.kathleen.graphics;
import android.content.Context;

/**
 * The Class Monkey.
 */
public class Monkey extends ImageViewRube {

	/**
	 * Instantiates a new monkey, setting up initial state, drawable hash and state machine.
	 *
	 * @param context the context
	 */
	public Monkey(Context context) {
		super(context);
		currentState = State.Bored;
		
		drawables.put(State.Wet, context.getResources().getDrawable(R.drawable.monkey_wet));
		drawables.put(State.Burning, context.getResources().getDrawable(R.drawable.monkey_burning));
		drawables.put(State.Bored, context.getResources().getDrawable(R.drawable.monkey_bored));
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

		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.monkey_bored);
	}
	
	/**
	 * returns "Monkey"
	 * @see baynes.kathleen.graphics.ImageViewRube#getItemName()
	 */
	@Override
  public String getItemName() {
	  return "Monkey";
  }
}
