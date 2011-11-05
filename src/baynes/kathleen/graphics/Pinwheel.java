package baynes.kathleen.graphics;

import android.content.Context;
import android.util.AttributeSet;

public class Pinwheel extends Sprite {

	/**
   * @param context
   * @param attrs
   * @param defStyle
   */
  public Pinwheel(Context context, AttributeSet attrs, int defStyle) {
	  super(context, attrs, defStyle);
  }

	/**
   * @param context
   * @param attrs
   */
  public Pinwheel(Context context, AttributeSet attrs) {
	  super(context, attrs);
  }

	/**
   * @param context
   */
  public Pinwheel(Context context) {
	  super(context);
	  currentState = State.Stopped;
	  
	  drawables.put(State.Unlit, context.getResources().getDrawable(R.drawable.pinwheel));
	  
	  addTransition(State.Stopped, Event.Steam, State.Turning);
	  addTransition(State.Turning, Event.Pulse, State.Stopped);
  }

}
