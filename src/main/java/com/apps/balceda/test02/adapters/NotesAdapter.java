package com.apps.balceda.test02.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.apps.balceda.test02.R;
import com.apps.balceda.test02.model.Notes;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

  Context context;
  List<Notes> notesList;

  public NotesAdapter(Context context, List<Notes> notesList) {
    this.context = context;
    this.notesList = notesList;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.note_item,parent,false);
    ViewHolder viewHolder = new ViewHolder(view);

    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.id.setText(String.valueOf(notesList.get(position).getId()));
    holder.title.setText(notesList.get(position).getTitle());
    holder.body.setText(notesList.get(position).getBody());
    holder.trash.setOnClickListener((v)->{
      notesList.remove(position);
      notifyDataSetChanged();
    });
  }

  @Override
  public int getItemCount() {
    return notesList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder{

    TextView id, title, body;
    ImageView trash;

    public ViewHolder(View itemView) {
      super(itemView);
      id = itemView.findViewById(R.id.id);
      title = itemView.findViewById(R.id.titulo);
      body = itemView.findViewById(R.id.cuerpo);
      trash = itemView.findViewById(R.id.trash);
    }
  }
}
