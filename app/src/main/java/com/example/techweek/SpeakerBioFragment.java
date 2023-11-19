package com.example.techweek;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SpeakerBioFragment extends Fragment {

    TextView txtSpeakerBio;
    String speakerBio;

    public SpeakerBioFragment() {
    }

    public SpeakerBioFragment(String speakerBio) {
        this.speakerBio = speakerBio;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_speaker_bio, container, false);
        txtSpeakerBio = view.findViewById(R.id.tvSpeakerBio);
        txtSpeakerBio.setText(speakerBio);
//        txtDes.setText(R.string.speaker1);
        return view;
    }
//    public void setSpeakerBio(String speakerBio) {
//        if (txtSpeakerBio != null && speakerBio != null) {
//            txtSpeakerBio.setText(speakerBio);
//        }
//    }

//    @Override
//    public void onItemClick(String txtInformation) {
//        txtSpeakerBio.setText(txtInformation);
//    }
}