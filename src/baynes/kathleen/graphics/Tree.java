package baynes.kathleen.graphics;

import android.content.Context;

/**
 * The Class Tree.
 */
public class Tree extends ImageViewRube {

	/**
	 * Instantiates a new tree, setting up initial state, drawable hash and state machine.
	 *
	 * @param context the context
	 */
  public Tree(Context context) {
	  super(context);
		currentState = State.Unlit;
		
		drawables.put(State.Unlit, context.getResources().getDrawable(R.drawable.tree_unlit));
		drawables.put(State.Lit, context.getResources().getDrawable(R.drawable.tree_lit));
		drawables.put(State.Burning, context.getResources().getDrawable(R.drawable.tree_burning));
		drawables.put(State.Fried, context.getResources().getDrawable(R.drawable.tree_burnt));
		drawables.put(State.Wet, context.getResources().getDrawable(R.drawable.tree_wet));
		
		addTransition(State.Wet, Event.Heat, State.Unlit);
		addTransition(State.Wet, Event.ElectricOn, State.Fried);
		
		addTransition(State.Burning, Event.Heat, State.Fried);
		addTransition(State.Burning, Event.Water, State.Unlit);
		
		addTransition(State.Unlit, Event.ElectricOn, State.Lit);
		addTransition(State.Unlit, Event.Water, State.Wet);
		addTransition(State.Unlit, Event.Heat, State.Burning);
		
		addTransition(State.Lit, Event.ElectricOff, State.Unlit);
		addTransition(State.Lit, Event.Heat, State.Burning);
		addTransition(State.Lit, Event.Water, State.Fried);
		
		this.setScaleType(ScaleType.CENTER);
		this.setImageResource(R.drawable.tree_unlit);
  }
  
  /**
   * returns "Tree"
   * @see baynes.kathleen.graphics.ImageViewRube#getItemName()
   */
  @Override
  public String getItemName() {
	  return "Tree";
  }
}
