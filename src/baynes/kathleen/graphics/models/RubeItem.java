package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.util.Event;
import android.view.View;

/**
 * The Interface RubeItem, all views implement this to react to events
 */
public interface RubeItem {
	
	/**
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public String getItemName();
	
	/**
	 * Gets the current state.
	 *
	 * @return the current state
	 */
	public CharSequence getCurrentState();
	
	/**
	 * Gets the next state view.
	 *
	 * @param event the event
	 * @return the next state view
	 */
	public View getNextStateView(Event event);
}
