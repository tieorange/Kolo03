package msk.mylists;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class PokemonActivity extends AppCompatActivity {

  private TextView textView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pokemon);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null)
            .show();
      }
    });
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    textView = (TextView) findViewById(R.id.pokemon_text);

    String imageUrl = getIntent().getExtras().getString("image");
    String desc = getIntent().getExtras().getString("desc");
    String text = getIntent().getExtras().getString("text");

    textView.setText(text + " \n " + imageUrl + " \n" + desc);
  }

  @Override public void onBackPressed() {
    super.onBackPressed();

  }
}
