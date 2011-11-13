package baynes.kathleen.graphics.models;

import android.content.Context;

public class RubeItemFactory {

	/**
	 * Gets the rube item.
	 * 
	 * Expected List Order:
 	 * 0: Candle
	 * 1: Christmas Tree
	 * 2: Clapper
	 * 3: Cleat
	 * 4: Electrical Outlet
	 * 5: Kettle
	 * 6: Monkey
	 * 7: Rope Down Right
	 * 8: Rope Left Right
	 * 9: Rope Up Down
	 * 10: Rope Up Right
	 * 11: RubberBand
	 * 12: TV
	 * 13: Water Cooler
	 * 14: Wire Left Right
	 * 15: Wire Up Down
	 * @param context 
	 *
	 * @return the rube item
	 */
	public static RubeItem getRubeItemView(int index, Context context) {
		
		switch (index) {
		case 0:
			return new Candle(context);
		case 1:
			return new ChristmasTree(context);
		case 2:
			return new Clapper(context);
		case 3:
			return new Cleat(context);
		case 4:
			return new ElecticalOutlet(context);
		case 5:
			return new Kettle(context);
		case 6:
			return new Monkey(context);
		case 7:
			return new RopeDownRight(context);
		case 8:
			return new RopeLeftRight(context);
		case 9:
			return new RopeUpDown(context);
		case 10:
			return new RopeUpRight(context);
		case 11:
			return new RubberBand(context);
		case 12:
			return new TV(context);
		case 13:
			return new WaterCooler(context);
		case 14:
			return new WireLeftRight(context);
		case 15:
			return new WireUpDown(context);
		}
		return null;
  }
}
