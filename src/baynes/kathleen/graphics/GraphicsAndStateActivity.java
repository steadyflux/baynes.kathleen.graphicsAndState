package baynes.kathleen.graphics;

import baynes.kathleen.graphics.R;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class GraphicsAndStateActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.sprite_list,
		    android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setAdapter(adapter);
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
      public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
	      
      }

			@Override
      public void onNothingSelected(AdapterView<?> parentView) {
	      return;
      }
		});

		Drawable[] layers = { getResources().getDrawable(R.drawable.monkey_bored),
		    getResources().getDrawable(R.drawable.monkey_ashes) };
		TransitionDrawable transitionDrawable = new TransitionDrawable(layers);
		transitionDrawable.setCrossFadeEnabled(true);
		((ImageView) findViewById(R.id.image)).setImageDrawable(transitionDrawable);
		transitionDrawable.setBounds(0, 0, transitionDrawable.getIntrinsicWidth(), transitionDrawable.getIntrinsicHeight());
		transitionDrawable.startTransition(5000);

	}
}