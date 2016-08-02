package com.dailydeals.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.adobe.mobile.Target;
import com.dailydeals.BuyScreen;
import com.dailydeals.R;
import com.dailydeals.custom.CustomFragment;
import com.dailydeals.model.DataDeals;
import com.dailydeals.target.MboxCaller;

// TODO: Auto-generated Javadoc
/**
 * The Class DailyDealsContainer is basically a fragment contains the details of 
 * Deals in a list formate.
 */
public class DailyDealsContainer extends CustomFragment {

	/** The ListView for Deals list. */
	private ListView list;

	/** The data used for deals. */
	private List<DataDeals> info;

	/** The Adapter holds the listview. */
	private DealItemAdapter adapter1;

	/**
	 * Instantiates a new daily deals container.
	 */
	public DailyDealsContainer() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		ViewGroup v = (ViewGroup) inflater.inflate(R.layout.deal_container,
				container, false);
		loadContent(v);

		return v;
	}

	/**
	 * Load content for the activity .
	 * 
	 * @param v
	 *            the v
	 */
	private void loadContent(View v) {
		list = (ListView) v.findViewById(R.id.listView1);
		info = new ArrayList<DataDeals>();

		info.add(new DataDeals(R.drawable.daily_deal_pic1,
				getString(R.string.blue_mountains),
				getString(R.string.usa), "150", "100", "45"));

		MboxCaller.makeMboxCall("country-deals",
				"Default Message", Collections.<String, Object>emptyMap(),
				new Target.TargetCallback<String>() {

					@Override
					public void call(final String content) {
						getActivity().runOnUiThread(new Runnable() {
							@Override
							public void run() {
								if (content.equals("us")) {

									Log.d("US is calling!----", content);

									info.add(new DataDeals(R.drawable.daily_deal_pic1,
											getString(R.string.niagra),
											getString(R.string.usa), "150", "100", "45"));

									info.add(new DataDeals(R.drawable.daily_deal_pic2,
											getString(R.string.niagra),
											getString(R.string.usa), "150", "100", "45"));


								} else if (content.equals("uk")) {

									Log.d("UK is calling----", content);

									info.add(new DataDeals(R.drawable.london_eye,
											getString(R.string.londoneye),
											getString(R.string.uk), "150", "100", "1000"));

									info.add(new DataDeals(R.drawable.london_eye,
											getString(R.string.londoneye),
											getString(R.string.uk), "150", "100", "45"));


								} else if (content.equals("aus")) {

									Log.d("Australia is calling--", content);

									info.add(new DataDeals(R.drawable.opera_house,
											getString(R.string.opera),
											getString(R.string.australia), "100", "75", "145"));

									info.add(new DataDeals(R.drawable.opera_house,
											getString(R.string.reef),
											getString(R.string.australia), "100", "75", "145"));


								}
							}
						});
					}
				});


		info.add(new DataDeals(R.drawable.opera_house,
				getString(R.string.opera),
				getString(R.string.australia), "100", "75", "145"));

		MboxCaller.makeMboxConfirm("purchased-deal", "order", "120.00", null, null, null);

		adapter1 = new DealItemAdapter(getActivity(), info);
		adapter1.setUpdatedData(info);
		adapter1.notifyDataSetChanged();


		list.setAdapter(adapter1);

		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				launchActivity(position, info);
			}
		});

	}

	/**
	 * Launch activity.
	 * 
	 * @param position
	 *            the position
	 * @param info
	 *            the info
	 */
	private void launchActivity(final int position, List<DataDeals> info) {
		startActivity(new Intent(getActivity().getApplicationContext(),
				BuyScreen.class)
				.putExtra("title", info.get(position).getTxt1()));
	}

	/**
	 * The Class DealItemAdapter.
	 */
	private class DealItemAdapter extends BaseAdapter {
		
		/** The context. */
		private Context context;
		
//		/** The list. */
//		private List<DataDeals> list;
		
		/** The inflater. */
		private LayoutInflater inflater;

		private List<DataDeals> list = null;


		/**
		 * Instantiates a new deal item adapter.
		 *
		 * @param context the context
		 * @param list the list
		 */
		public DealItemAdapter(Context context, List<DataDeals> list) {
			this.context = context;
			this.list = list;
		}

		public void setUpdatedData(List<DataDeals> newData){
			this.list = newData;
		}


		/*
		 * (non-Javadoc)
		 * 
		 * @see android.widget.Adapter#getCount()
		 */
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.widget.Adapter#getItem(int)
		 */
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.widget.Adapter#getItemId(int)
		 */
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see android.widget.Adapter#getView(int, android.view.View,
		 * android.view.ViewGroup)
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				inflater = (LayoutInflater) context
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(R.layout.daily_adpter, null);
			}
			LinearLayout mainImage = (LinearLayout) convertView
					.findViewById(R.id.mainImage);
			TextView txt1 = (TextView) convertView.findViewById(R.id.txt1);
			TextView txt2 = (TextView) convertView.findViewById(R.id.txt2);
			TextView tv1 = (TextView) convertView.findViewById(R.id.tv1);
			TextView tv2 = (TextView) convertView.findViewById(R.id.tv2);
			TextView tv4 = (TextView) convertView.findViewById(R.id.tv4);

			final DataDeals dInfo = list.get(position);
			mainImage.setBackgroundResource(dInfo.getBgMain());
			txt1.setText(dInfo.getTxt1());
			txt2.setText(dInfo.getTxt2());

			tv1.setText("$" + dInfo.getTv1());
			tv1.setPaintFlags(tv1.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

			tv2.setText("$" + dInfo.getTv2());
			tv4.setText(dInfo.getTv4());
			return convertView;
		}

	}

}
