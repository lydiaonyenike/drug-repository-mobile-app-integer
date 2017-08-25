package com.staarline.drugdirectory;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eloka Augustine on 23/08/2017.
 */
public class DrugArrayAdapter extends BaseAdapter implements Filterable {

    private List<Drug> drugsList;
    private List<Drug> filteredList;
    private FriendFilter friendFilter;
    private Context context;

    public DrugArrayAdapter(List<Drug> drugTypes, Context context) {
        this.drugsList = drugTypes;
        this.filteredList = drugTypes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.drugsList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.drugsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Filter getFilter() {
        if (friendFilter == null) {
            friendFilter = new FriendFilter();
        }

        return friendFilter;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Drug drg = this.drugsList.get(position);


        LayoutInflater inflater = ((AppCompatActivity) this.context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.drugitem, parent, false);


        TextView drugName = (TextView) convertView.findViewById(R.id.drugNameTextView);
        drugName.setText(drg.drugName);

        ImageView drugImage = (ImageView) convertView.findViewById(R.id.drugImageView);
        Drawable newDrawable = context.getResources().getDrawable(drg.imageResourceId);
        drugImage.setImageDrawable(newDrawable);
        return convertView;
    }

    private class FriendFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                ArrayList<Drug> tempList = new ArrayList<>();

                // search content in friend list
                for (Drug drug : drugsList) {
                    if (drug.drugName.toLowerCase().contains(constraint.toString().toLowerCase())) {
                        tempList.add(drug);
                    }
                }

                filterResults.count = tempList.size();
                filterResults.values = tempList;
            }
            else {
                filterResults.count = drugsList.size();
                filterResults.values = drugsList;
            }

            return filterResults;
        }

        /**
         * Notify about filtered list to ui
         *
         * @param constraint text
         * @param results    filtered result
         */
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredList = (ArrayList<Drug>) results.values;
            notifyDataSetChanged();
        }

    }
}
