package baynes.kathleen.graphics.util;

import java.util.EnumSet;
import java.util.Set;

import baynes.kathleen.graphics.R;

/**
 * The Enum Event.
 */
public enum Event {

	/** The Heat. */
	Heat(R.string.heat),
	/** The Water. */
	Water(R.string.water),
	/** The Start. */
	Start(R.string.start),
	/** The Pulse. */
	Pulse(R.string.pulse),
	/** The Electric on. */
	ElectricOn(R.string.electric_on),
	/** The Electric off. */
	ElectricOff(R.string.electric_off),
	/** The Clap. */
	Clap(R.string.clap),
	/** The Alex. */
	Alex(R.string.alex),
	/** The Turn. */
	Turn(R.string.turn),
	/** The Steam. */
	Steam(R.string.steam),
	/** The Pull. */
	Pull(R.string.pull),
	/** The Release. */
	Release(R.string.release);

	/** The string name resource. */
	private int stringNameResource;

	/**
	 * Instantiates a new event.
	 * 
	 * @param stringNameResource
	 *          the string name resource
	 */
	private Event(int stringNameResource) {
		this.stringNameResource = stringNameResource;
	}

	/**
	 * Gets the all events.
	 * 
	 * @return the all events
	 */
	public static Set<Event> getAllEvents() {
		return EnumSet.allOf(Event.class);
	}

	/**
	 * Gets the string name resource, used for button text
	 * 
	 * @return the string name resource
	 */
	public int getStringNameResource() {
		return stringNameResource;
	}

}
