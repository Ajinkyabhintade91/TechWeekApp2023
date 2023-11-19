package com.example.techweek;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

import java.util.List;


public class GridViewAdaptor extends BaseAdapter {

    LayoutInflater inflater;
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;
    private final Context context;
    private final List<EventClass> events;
    private OnItemClickListener listener;

    public GridViewAdaptor(Context context, List<EventClass> events) {
        this.context = context;
        this.events = events;
    }

    // Method to set the listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getCount() {
        if (events != null) {
            return events.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        return events.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.cardview_layout, parent, false);
        }

        EventClass event = events.get(position);
        ImageView eventImage = convertView.findViewById(R.id.header_image);
        TextView title = convertView.findViewById(R.id.tvEventtitle);

        Glide.with(convertView)
                .load(event.getImageID())
                .into(eventImage);

        title.setText(event.getEventTitle());

        return convertView;
    }

    public void showEventDetails(EventClass eventClass) {

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.event_description);

        ImageView modalImage = dialog.findViewById(R.id.imgvEventImage);
        TextView modalTitle = dialog.findViewById(R.id.tvTitleEvent);
        TextView modalVenue = dialog.findViewById(R.id.tvVenue);
        TextView modalTime = dialog.findViewById(R.id.tvTime);
        TextView modalSpeaker = dialog.findViewById(R.id.tvEventSpeaker);

        tabLayout = dialog.findViewById(R.id.tlDescriptionAndBio);
        viewPager2 = dialog.findViewById(R.id.viewPager);


        if (context instanceof FragmentActivity) {
            viewPagerAdapter = new ViewPagerAdapter((FragmentActivity) context, eventClass);
            viewPager2.setAdapter(viewPagerAdapter);
        }

        if (tabLayout != null) {
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager2.setCurrentItem(tab.getPosition());
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

        modalImage.setImageResource(eventClass.getImageID());
        modalTitle.setText(eventClass.getEventTitle());
        modalVenue.setText(eventClass.getEventVenue());
        modalTime.setText(eventClass.getEventTime());
        modalSpeaker.setText(eventClass.getEventSpeaker());

        dialog.show();
    }

    // Interface for click events
    public interface OnItemClickListener {
        void onItemClick(EventClass event);
    }

}
