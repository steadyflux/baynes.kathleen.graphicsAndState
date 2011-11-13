package baynes.kathleen.graphics.models;

import java.util.Set;

import baynes.kathleen.graphics.util.Event;
import android.content.Context;
import android.view.View;

/**
 * The Interface RubeItem, all views implement this to react to events.
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

	/**
	 * Gets the events to process. This correlates to the buttons to be created on the screen
	 *
	 * @param baseContext the base context
	 * @return the events to process
	 */
	public Set<Event> getEventsToProcess(Context baseContext);
}
