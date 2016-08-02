package com.dailydeals.ui;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.dailydeals.R;
import com.dailydeals.custom.CustomFragment;
import com.dailydeals.model.ItemMyPurchase;

// TODO: Auto-generated Javadoc
/**
 * The Class MyPurchases.
 */
public class MyPurchases extends CustomFragment{

	/** List view for purchase Items. */
	private ListView myPurchase;
	
	/** The list contains data for purchase items. */
	private ArrayList<ItemMyPurchase> list;
	
	/** The Adapter for ListView. */
	private MyPurchaseAdapter adapter;
	
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.mypurchase, null);
		myPurchase = (ListView)v.findViewById(R.id.list_my_purchase);
		loadContents();
		setHasOptionsMenu(true);
		
		return v;
	}
	
	/**
	 * Load contents.
	 */
	private void loadContents()
	{
		list = new ArrayList<ItemMyPurchase>();
		list.add(new ItemMyPurchase(R.drawable.icon_mypurchase1, getString(R.string.blue_mountains), "02.04.2014", "45", getString(R.string.redeemed)));
		list.add(new ItemMyPurchase(R.drawable.icon_mypurchase2, getString(R.string.Shangri_La), "01.03.2014", "45", getString(R.string.expired)));
		list.add(new ItemMyPurchase(R.drawable.icon_mypurchase3, getString(R.string.blue_mountains), "02.04.2014", "45", getString(R.string.redeemed)));
		list.add(new ItemMyPurchase(R.drawable.icon_mypurchase4, getString(R.string.Shangri_La), "01.03.2014", "45", getString(R.string.expired)));
		list.add(new ItemMyPurchase(R.drawable.icon_mypurchase5, getString(R.string.blue_mountains), "02.04.2014", "45", getString(R.string.redeemed)));
		list.add(new ItemMyPurchase(R.drawable.icon_mypurchase6, getString(R.string.Shangri_La), "01.03.2014", "45", getString(R.string.expired)));
		list.add(new ItemMyPurchase(R.drawable.icon_mypurchase7, getString(R.string.blue_mountains), "02.04.2014", "45", getString(R.string.redeemed)));
		
		adapter = new MyPurchaseAdapter(getActivity(), list);
		myPurchase.setAdapter(adapter);
	}
	
	/**
	 * The Class MyPurchaseAdapter is a adapter for listview to load 
	 * items.
	 */
	private class MyPurchaseAdapter extends BaseAdapter
	{
		
		/** The context. */
		private Context context;
		
		/** The list. */
		private ArrayList<ItemMyPurchase> list;
		
		/** The inflater. */
		private LayoutInflater inflater;
		
		/**
		 * Instantiates a new my purchase adapter.
		 *
		 * @param c the c
		 * @param mList the m list
		 */
		public MyPurchaseAdapter(Context c , ArrayList<ItemMyPurchase> mList)
		{
			context = c;
			list = mList;
		}
		
		/* (non-Javadoc)
		 * @see android.widget.Adapter#getCount()
		 */
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		/* (non-Javadoc)
		 * @see android.widget.Adapter#getItem(int)
		 */
		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		/* (non-Javadoc)
		 * @see android.widget.Adapter#getItemId(int)
		 */
		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		/* (non-Javadoc)
		 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
		
			if(convertView == null)
			{
				inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflater.inflate(R.layout.mypuchase_item, null);
			}
			
			ImageView itemImg = (ImageView)convertView.findViewById(R.id.item_img);
			TextView itemName = (TextView)convertView.findViewById(R.id.tv1);
			TextView itemDate = (TextView)convertView.findViewById(R.id.tv2);
			TextView itemPrice = (TextView)convertView.findViewById(R.id.tv3);
			TextView itemStatus = (TextView)convertView.findViewById(R.id.tv4);
			
			final ItemMyPurchase info = list.get(position);
			itemImg.setImageResource(info.getItemImage());
			itemName.setText(info.getItemName());
			itemDate.setText(info.getItemDate());
			itemPrice.setText("$"+info.getItemPrice());
			itemStatus.setText(info.getItemStatus());
			return convertView;
		}
	
	}
	}
