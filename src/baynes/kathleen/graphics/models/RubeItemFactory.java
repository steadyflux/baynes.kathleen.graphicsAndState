package baynes.kathleen.graphics.models;

import android.content.Context;
import android.view.View;

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
	 * 7: Rope
	 * 8: RubberBand
	 * 9: TV
	 * 10: Water Cooler
	 * 11: Wire
	 * @param context 
	 *
	 * @return the rube item
	 */
	public static View getRubeItemView(int index, Context context) {
		
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
			return new Rope(context);
		case 8:
			return new RubberBand(context);
		case 9:
			return new TV(context);
		case 10:
			return new WaterCooler(context);
		case 11:
			return new Wire(context);
		}
		return null;
  }
}
