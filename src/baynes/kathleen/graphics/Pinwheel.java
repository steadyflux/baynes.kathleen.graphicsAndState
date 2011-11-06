package baynes.kathleen.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

public class Pinwheel extends View implements RubeItem {

	/** Used in logging */
	protected static final String TAG = "baynes.kathleen.graphics";

	private Bitmap scaledBitmap = null;

	private boolean doSpin = false;

	private Animation animation = null;
	
	private String stateName = "Not Spinning";

	/**
	 * @param context
	 */
	public Pinwheel(Context context) {
		super(context);
	}

	public void start() {
		startAnimation(animation);
	}

	private void defineAnimation(Canvas canvas) {
		Log.d(TAG, "canvas width: " + canvas.getWidth());
		Log.d(TAG, "canvas height: " + canvas.getHeight());
		animation = new RotateAnimation(0, 108000, 230, 250);
		animation.setRepeatCount(Animation.INFINITE);
		animation.setInterpolator(new LinearInterpolator());
		
		animation.setDuration(300000);
	}

	private void getScaledBitmap(Canvas canvas) {
		Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.pinwheel);
		int max = Math.max(image.getWidth(), image.getHeight());
		int min = Math.min(canvas.getWidth(), canvas.getHeight());
		float scale = ((float) min) / max ;
		Matrix matrix = new Matrix();
		matrix.preScale(scale, scale);
		scaledBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
	}

	@Override
	protected void onDraw(Canvas canvas) {

		int x = 0;
		int y = 0;

		if (scaledBitmap == null) {
			getScaledBitmap(canvas);

		}

		if (doSpin) {
			if (animation == null) {
				defineAnimation(canvas);
			}
			doSpin = false;
			start();
		}

		canvas.drawBitmap(scaledBitmap, x, y, null);
	}

	@Override
	public View getNextStateView(Event event) {
		if (event.equals(Event.Steam)) {
			doSpin = true;
			stateName = "Spinning";
		}
		if (event.equals(Event.Pulse)) {
			clearAnimation();
			animation = null;
			stateName = "Not Spinning";
		}
		return this;
	}

	@Override
	public String getItemName() {
		return "Pinwheel";
	}

	@Override
  public CharSequence getCurrentState() {
		return stateName;
  }
}
