package com.apps.balceda.test02.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.balceda.test02.R;
import com.apps.balceda.test02.adapters.NotesAdapter;
import com.apps.balceda.test02.model.Notes;

import java.util.ArrayList;
import java.util.List;

public class PrincipalFragment extends Fragment {

  RecyclerView recyclerView;
  List<Notes> notesList;
  NotesAdapter adapter;
  FloatingActionButton fab;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View rootView;
    rootView = inflater.inflate(R.layout.fragment_principal, container, false);
    return rootView;
    //  return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    recyclerView = view.findViewById(R.id.recyclerView);
    LinearLayoutManager linearLayoutManager =
      new LinearLayoutManager(getActivity().getApplicationContext(),
        LinearLayoutManager.VERTICAL, false);
    recyclerView.setLayoutManager(linearLayoutManager);
    cargarData();
    adapter = new NotesAdapter(getActivity().getApplicationContext(), notesList);
    recyclerView.setAdapter(adapter);


    fab = view.findViewById(R.id.fab);
    fab.setOnClickListener((v) -> {
      //Toast.makeText(getActivity().getApplicationContext(),"FAB Clicked",Toast.LENGTH_LONG).show();
      AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
      EditText editText = new EditText(getActivity());
      alert.setMessage("Ingrese un elemento");
      alert.setTitle("Nueva Nota");
      alert.setView(editText);

      alert.setPositiveButton("OK", (dialog, which) -> {
        Toast.makeText(getActivity().getApplicationContext(),"Si",Toast.LENGTH_LONG).show();
        notesList.add(new Notes(300,editText.getText().toString(),"Body"));
        adapter.notifyDataSetChanged();
      });

      alert.setNegativeButton("NO", (dialog, which) -> {
        Toast.makeText(getActivity().getApplicationContext(),"No",Toast.LENGTH_LONG).show();
      });

      alert.show();
    });
  }

  public void cargarData() {
    notesList = new ArrayList<>();
    notesList.add(new Notes(1, "Nota 1", "Texto de la nota 1"));
    notesList.add(new Notes(2, "Nota 2", "Texto de la nota 2"));
    notesList.add(new Notes(3, "Nota 3", "Texto de la nota 3"));
    notesList.add(new Notes(4, "Nota 4", "Texto de la nota 4"));
    notesList.add(new Notes(5, "Nota 5", "Texto de la nota 5"));
    notesList.add(new Notes(6, "Nota 6", "Texto de la nota 6"));
    notesList.add(new Notes(7, "Nota 7", "Texto de la nota 7"));
    notesList.add(new Notes(8, "Nota 8", "Texto de la nota 8"));
    notesList.add(new Notes(9, "Nota 9", "Texto de la nota 9"));
    notesList.add(new Notes(10, "Nota 10", "Texto de la nota 10"));
    notesList.add(new Notes(11, "Nota 11", "Texto de la nota 11"));
    notesList.add(new Notes(12, "Nota 12", "Texto de la nota 12"));
    notesList.add(new Notes(13, "Nota 13", "Texto de la nota 13"));
    notesList.add(new Notes(14, "Nota 14", "Texto de la nota 14"));
    notesList.add(new Notes(15, "Nota 15", "Texto de la nota 15"));

  }
}
