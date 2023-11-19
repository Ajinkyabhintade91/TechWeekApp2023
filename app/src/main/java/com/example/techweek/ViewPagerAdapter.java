package com.example.techweek;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    EventClass eventClass;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity, EventClass eventClass) {
        super(fragmentActivity);
        this.eventClass = eventClass;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new DescriptionFragment(eventClass.getEventDescription());
            case 1:
                return new SpeakerBioFragment(eventClass.getEventSpeakerBio());
            default:
                return new DescriptionFragment(eventClass.getEventDescription());
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
