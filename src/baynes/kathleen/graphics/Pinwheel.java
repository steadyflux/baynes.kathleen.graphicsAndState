package baynes.kathleen.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

public class Pinwheel extends View implements RubeItem {
	
	/** Used in logging */
	protected static final String TAG = "baynes.kathleen.graphics";
	
	private Animation animation;
	
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
  }
  
	public void start() {
		startAnimation(animation);
	}
	private void defineAnimation(Canvas canvas) {
		Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.pinwheel);
		int max = Math.max(image.getWidth(), image.getHeight());
		int min = Math.min(canvas.getWidth(), canvas.getHeight());
		float scale = ((float)min) / max / 2;
		Matrix matrix = new Matrix();
		matrix.preScale(scale, scale);
		scaledBitmap = Bitmap.createBitmap(image, 0, 0, image.getWidth(), image.getHeight(), matrix, true);
		
		animation = new RotateAnimation(0, 360, canvas.getWidth()/2, canvas.getHeight()/2);

		animation.setRepeatCount(1);

		animation.setInterpolator(new AccelerateDecelerateInterpolator());
		animation.setDuration(3000);

	}
	
	private Bitmap scaledBitmap;
	
	@Override protected void onDraw(Canvas canvas) {
		Log.d(TAG, "pinwheel draw");
		defineAnimation(canvas);

		int x = canvas.getWidth()/2 - scaledBitmap.getWidth()/2;
		int y = canvas.getHeight()/2 - scaledBitmap.getHeight()/2 - 150;
		
		canvas.drawBitmap(scaledBitmap, x, y, null);
	}

	@Override
  public void addTransition(State currentState, Event event, State nextState) {
	  // TODO Auto-generated method stub
	  
  }

	@Override
  public void getNextState(Event event) {
	  // TODO Auto-generated method stub
	  
  }
}
