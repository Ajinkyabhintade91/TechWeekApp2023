package com.example.techweek;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DescriptionFragment extends Fragment {

    TextView txtDescription;
    String description;

    public DescriptionFragment() {
    }

    public DescriptionFragment(String description) {
        this.description = description;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        txtDescription = view.findViewById(R.id.tvDescription);
        txtDescription.setText(description);
        return view;
    }

}