package com.example.techweek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListViewAdaptor extends BaseExpandableListAdapter {
    private final Context context;
    private final List<String> dataHeader;
    private final HashMap<String, List<EventClass>> listHashMap;
    private final LayoutInflater inflater;

    public ExpandableListViewAdaptor(Context context, List<String> dataHeader, HashMap<String, List<EventClass>> listHashMap) {
        this.context = context;
        this.dataHeader = dataHeader;
        this.listHashMap = listHashMap;
        inflater = LayoutInflater.from(this.context.getApplicationContext());
    }

    @Override
    public int getGroupCount() {
        return dataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return dataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.exp_list_header, parent, false);

            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.tvDayOfTheWeek);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(getGroup(groupPosition).toString());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.exp_list_body, parent, false);
            holder = new ViewHolder();

            holder.gridView = convertView.findViewById(R.id.gvEvents);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String groupTitle = dataHeader.get(groupPosition);
        List<EventClass> events = listHashMap.get(groupTitle);

        // Set up the GridView adapter
        GridViewAdaptor gridAdapter = new GridViewAdaptor(context, events);
        holder.gridView.setAdapter(gridAdapter);

        // set an item click listener for the GridView
        holder.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EventClass event = events.get(position);

                gridAdapter.showEventDetails(event);
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private static class ViewHolder {
        TextView textView;
        GridView gridView;
    }
}
