package com.example.android.rouxacademy;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

	// Declare Variables
	Context mContext;
	LayoutInflater inflater;
	private List<Case> worldpopulationlist = null;
	private ArrayList<Case> arraylist;

	public ListViewAdapter(Context context,
			List<Case> worldpopulationlist) {
		mContext = context;
		this.worldpopulationlist = worldpopulationlist;
		inflater = LayoutInflater.from(mContext);
		this.arraylist = new ArrayList<Case>();
		this.arraylist.addAll(worldpopulationlist);
	}

	public class ViewHolder {
		ImageView Case_pic_dis;
		ImageView CaseNumber;
		TextView Casetitle;
		TextView description;

	}

	@Override
	public int getCount() {
		return worldpopulationlist.size();
	}

	@Override
	public Case getItem(int position) {
		return worldpopulationlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup parent) {
		final ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.listview_item, null);
			// Locate the TextViews in listview_item.xml
			holder.Casetitle= (TextView) view.findViewById(R.id.rank);
		//	holder.description = (TextView) view.findViewById(R.id.country);
			// Locate the ImageView in listview_item.xml
			holder.CaseNumber = (ImageView) view.findViewById(R.id.flag);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// Set the results into TextViews
		holder.Casetitle.setText(worldpopulationlist.get(position).getCaseTitle());
	//	holder.description.setText(worldpopulationlist.get(position).getDescription());



		// Set the results into ImageView
		holder.CaseNumber.setImageResource(worldpopulationlist.get(position)
				.getCaseNumber());
		// Listen for ListView Item Click
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Send single item click data to SingleItemView Class
				Intent intent = new Intent(mContext, SingleItemView.class);
				// Pass all data rank
				intent.putExtra("Casetitle",
						(worldpopulationlist.get(position).getCaseTitle()));
				// Pass all data country
				intent.putExtra("description",
						(worldpopulationlist.get(position).getDescription()));
				// Pass all data population

				// Pass all data flag
				intent.putExtra("CaseNumber",
						(worldpopulationlist.get(position).getCaseNumber()));
// Pass all data flag
				intent.putExtra("Case_pic_dis",
						(worldpopulationlist.get(position).getCase_pic_des()));



				// Start SingleItemView Class
				mContext.startActivity(intent);
			}
		});

		return view;
	}

	// Filter Class
	public void filter(String charText) {
		charText = charText.toLowerCase(Locale.getDefault());
		worldpopulationlist.clear();
		if (charText.length() == 0) {
			worldpopulationlist.addAll(arraylist);
		} else {
			for (Case wp : arraylist) {
				if (wp.getDescription().toLowerCase(Locale.getDefault())
						.contains(charText)) {
					worldpopulationlist.add(wp);
				}
			}
		}
		notifyDataSetChanged();
	}

}
