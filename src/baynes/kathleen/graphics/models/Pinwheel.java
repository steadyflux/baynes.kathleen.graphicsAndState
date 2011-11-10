package baynes.kathleen.graphics.models;

import baynes.kathleen.graphics.R;
import baynes.kathleen.graphics.util.Event;

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

/**
 * The Class Pinwheel.
 */
public class Pinwheel extends View implements RubeItem {

	/** Used in logging. */
	protected static final String TAG = "baynes.kathleen.graphics";

	/** The scaled bitmap. */
	private Bitmap scaledBitmap = null;

	/** The do spin indicator. */
	private boolean doSpin = false;

	/** The animation. */
	private Animation animation = null;
	
	/** The state name (not tracked like the ImageViewRube children. */
	private String stateName = "Not Spinning";

	/**
	 * Instantiates a new pinwheel
	 *
	 * @param context the context
	 */
	public Pinwheel(Context context) {
		super(context);
	}

	/**
	 * Starts the animation.
	 */
	public void start() {
		startAnimation(animation);
	}

	/**
	 * Define animation.
	 *
	 * @param canvas the canvas
	 */
	private void defineAnimation(Canvas canvas) {
		Log.d(TAG, "canvas width: " + canvas.getWidth());
		Log.d(TAG, "canvas height: " + canvas.getHeight());
		animation = new RotateAnimation(0, 108000, 230, 250); // lots of rotations before reset, just looks smoother this way
		animation.setRepeatCount(Animation.INFINITE);
		animation.setInterpolator(new LinearInterpolator());
		
		animation.setDuration(300000);
	}

	/**
	 * Gets the scaled bitmap.
	 *
	 * @param canvas the canvas
	 * @return the scaled bitmap
	 */
	private void getScaledBitmap(Canvas canvas) {
		Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.pinwheel);
		int max = Math.max(image.getWidth(), image.getHeight());
		int min = Math.min(canvas.getWidth(), canvas.getHeight());
		float scale = ((float) min) / max ;
		Matrix matrix = new Matrix();
		matrix.preScale(scale, scale);
		scaledBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
	}

	/**
	 * puts the image on the canvas
	 * @see android.view.View#onDraw(android.graphics.Canvas)
	 */
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

	/**
	 * reacts to the Pulse and Steam events
	 * @see baynes.kathleen.graphics.models.RubeItem#getNextStateView(baynes.kathleen.graphics.util.Event)
	 */
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

	/**
	 * returns "Pinwheel"
	 * @see baynes.kathleen.graphics.models.RubeItem#getItemName()
	 */
	@Override
	public String getItemName() {
		return "Pinwheel";
	}

	/**
	 * returns the current state
	 * @see baynes.kathleen.graphics.models.RubeItem#getCurrentState()
	 */
	@Override
  public CharSequence getCurrentState() {
		return stateName;
  }
}
