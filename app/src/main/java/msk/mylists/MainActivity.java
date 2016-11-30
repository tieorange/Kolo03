package msk.mylists;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  RecyclerView recyclerView;
  TextView text;

  List<Pokemon> data;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    data = new ArrayList<>();
    for (int i = 0; i < 20; i++)
      data.add(new Pokemon("Text " + i, "Description " + i,
          "http://cdn.bulbagarden.net/upload/thumb/0/02/009Blastoise.png/250px-009Blastoise.png",
          "https://img1.steemit.com/0x0/https://storage.googleapis.com/steemimgimgs/2016/10/20/FBb91d9.png"));

    recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    recyclerView.setAdapter(new MyAdapter(data, this));

    text = (TextView) findViewById(R.id.main_text);
  }
}
