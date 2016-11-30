package msk.mylists;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.List;
import tyrantgit.explosionfield.ExplosionField;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

  private List<Pokemon> data;
  private Context context;

  public MyAdapter(List<Pokemon> data, Context context) {
    this.data = data;
    this.context = context;
  }

  @Override public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new MyViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false));
  }

  @Override public void onBindViewHolder(MyViewHolder holder, int position) {

    holder.getTextView().setText(data.get(position).getText());
    holder.getDescription().setText(data.get(position).getDescription());
    Picasso.with(context).load(data.get(position).getImageUrl()).into(holder.getImage());
    Picasso.with(context).load(data.get(position).getLikeImageUrl()).into(holder.getLikeButton());
  }

  @Override public int getItemCount() {
    return data.size();
  }

  class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView image;
    private TextView text;
    private TextView description;
    private View listItem;

    private ImageView likeButton;

    public MyViewHolder(View view) {
      super(view);
      image = (ImageView) view.findViewById(R.id.list_item_image);
      text = (TextView) view.findViewById(R.id.list_item_text);
      description = (TextView) view.findViewById(R.id.list_item_description);
      likeButton = (ImageView) view.findViewById(R.id.list_item_like_button);
      //likeButton.setOnClickListener(this);
      listItem = view;
      view.setOnClickListener(this);
    }

    public ImageView getLikeButton() {
      return likeButton;
    }

    public ImageView getImage() {
      return image;
    }

    public TextView getDescription() {
      return description;
    }

    public TextView getTextView() {
      return text;
    }

    public View getListItem() {
      return listItem;
    }

    @Override public void onClick(View v) {
      final int adapterPosition = getAdapterPosition();

      // Explosion:
      ExplosionField explosionField = new ExplosionField(context);
      explosionField.explode(likeButton);

      final Pokemon pokemon = data.get(adapterPosition);
      Intent intent = new Intent(context, PokemonActivity.class);
      // Przekazujemy danne:
      intent.putExtra("image", pokemon.getImageUrl());
      intent.putExtra("text", pokemon.getText());
      intent.putExtra("desc", pokemon.getDescription());

      context.startActivity(intent);

      MainActivity mainActivity = (MainActivity) context;
      mainActivity.finish();
    }
  }
}
