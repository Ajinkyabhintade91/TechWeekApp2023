package com.example.techweek;

import android.os.Bundle;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Schedule extends AppCompatActivity {

    ExpandableListView expandableListView;
    private List<String> listDataHeader;
    private HashMap<String, List<EventClass>> listHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        expandableListView = findViewById(R.id.elvEvents);

        populateData();

        ExpandableListViewAdaptor viewAdaptor = new ExpandableListViewAdaptor(Schedule.this, listDataHeader, listHashMap);
        expandableListView.setAdapter(viewAdaptor);
    }

    private void populateData() {
        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add(getString(R.string.monday));
        listDataHeader.add(getString(R.string.tuesday));
        listDataHeader.add(getString(R.string.wednesday));
        listDataHeader.add(getString(R.string.thursday));
        listDataHeader.add(getString(R.string.friday));


        List<EventClass> mondayEvents = new ArrayList<>();
        mondayEvents.add(new EventClass(getString(R.string.event0_title), getString(R.string.venue1),
                getString(R.string.timeslot0_1), getString(R.string.speaker0),
                getString(R.string.description0), getString(R.string.description), R.drawable.opening_ceremony));


        mondayEvents.add(new EventClass(getString(R.string.event1_title), getString(R.string.venue1),
                getString(R.string.timeslot1), getString(R.string.speaker1),
                getString(R.string.description1), getString(R.string.speaker1bio), R.drawable.img1));
        mondayEvents.add(new EventClass(getString(R.string.event3_title), getString(R.string.venue1),
                getString(R.string.timeslot3), getString(R.string.panel1), R.drawable.img3));
        mondayEvents.add(new EventClass(getString(R.string.event4_title), getString(R.string.venue1),
                getString(R.string.timeslot4), getString(R.string.speaker3),
                getString(R.string.description3), getString(R.string.speaker3bio), R.drawable.img4));


        listHashMap.put(getString(R.string.monday), mondayEvents);


        List<EventClass> tuesdayEvents = new ArrayList<>();

        tuesdayEvents.add(new EventClass(getString(R.string.event5_title), getString(R.string.venue1),
                getString(R.string.timeslot4), getString(R.string.speaker4),
                getString(R.string.description4), getString(R.string.speaker4bio), R.drawable.img5));

        listHashMap.put(getString(R.string.tuesday), tuesdayEvents);


        List<EventClass> wednesdayEvents = new ArrayList<>();
        wednesdayEvents.add(new EventClass(getString(R.string.event6_title), getString(R.string.venue1),
                getString(R.string.timeslot1), getString(R.string.speaker5),
                getString(R.string.description5), getString(R.string.speaker5bio), R.drawable.img6));
        wednesdayEvents.add(new EventClass(getString(R.string.event7_title), getString(R.string.venue1),
                getString(R.string.timeslot2), getString(R.string.speaker6),
                getString(R.string.description6), getString(R.string.speaker6bio), R.drawable.img7));
        wednesdayEvents.add(new EventClass(getString(R.string.event8_title), getString(R.string.venue1),
                getString(R.string.timeslot3), getString(R.string.panel2), R.drawable.img8));
        wednesdayEvents.add(new EventClass(getString(R.string.event9_title), getString(R.string.venue2),
                getString(R.string.timeslot6), R.drawable.img9));

        listHashMap.put(getString(R.string.wednesday), wednesdayEvents);

        List<EventClass> thursdayEvents = new ArrayList<>();
        thursdayEvents.add(new EventClass(getString(R.string.event2_title), getString(R.string.venue1),
                getString(R.string.timeslot0), getString(R.string.speaker2),
                getString(R.string.description2), getString(R.string.speaker2bio), R.drawable.img2));
        thursdayEvents.add(new EventClass(getString(R.string.event10_title), getString(R.string.venue1),
                getString(R.string.timeslot1), getString(R.string.speaker7), R.drawable.img10));
        thursdayEvents.add(new EventClass(getString(R.string.event11_title), getString(R.string.venue1),
                getString(R.string.timeslot2), getString(R.string.speaker8), R.drawable.img11));
        thursdayEvents.add(new EventClass(getString(R.string.event12_title), getString(R.string.venue1),
                getString(R.string.timeslot3), getString(R.string.panel3), R.drawable.img12));

        thursdayEvents.add(new EventClass(getString(R.string.event14_title), getString(R.string.venue1),
                getString(R.string.timeslot3_1), getString(R.string.speaker10), R.drawable.thought_leadership));

        listHashMap.put(getString(R.string.thursday), thursdayEvents);

        List<EventClass> fridayEvents = new ArrayList<>();
        fridayEvents.add(new EventClass(getString(R.string.event13_title), getString(R.string.venue1),
                getString(R.string.timeslot5), getString(R.string.speaker9),
                getString(R.string.description9), getString(R.string.speaker9bio), R.drawable.img13));


        listHashMap.put(getString(R.string.friday), fridayEvents);
    }
}