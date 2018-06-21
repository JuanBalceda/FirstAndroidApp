package com.apps.balceda.test02.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.balceda.test02.R;

public class MainFragment extends Fragment {

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View rootView;
    rootView = inflater.inflate(R.layout.fragment_layout, container, false);
    //return super.onCreateView(inflater, container, savedInstanceState);
    return rootView;
  }
}
