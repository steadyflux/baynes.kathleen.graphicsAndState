package baynes.kathleen.graphics;

import android.view.View;

public interface RubeItem {
	
	public String getItemName();
	public CharSequence getCurrentState();
	
	public View getNextStateView(Event event);
}
