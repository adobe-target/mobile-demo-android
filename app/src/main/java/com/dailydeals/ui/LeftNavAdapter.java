package com.dailydeals.ui;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dailydeals.R;
import com.dailydeals.model.Data;

// TODO: Auto-generated Javadoc
/**
 * The Adapter class for the ListView displayed in the left navigation drawer.
 */
public class LeftNavAdapter extends BaseAdapter
{

	/** The items. */
	private ArrayList<Data> items;

	/** The context. */
	private Context context;

	/**
	 * Instantiates a new left nav adapter.
	 *
	 * @param context the context
	 * @param items the items
	 */
	public LeftNavAdapter(Context context, ArrayList<Data> items)
	{
		this.context = context;
		this.items = items;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount()
	{
		return items.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Data getItem(int arg0)
	{
		return items.get(arg0);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position)
	{
		return position;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if (convertView == null)
			convertView = LayoutInflater.from(context).inflate(
					R.layout.left_nav_item, null);
		TextView lbl = (TextView) convertView;
		final Data info = items.get(position);
		lbl.setText(info.getTitle());
		if(info.getSel()!= null)
		{
			lbl.setCompoundDrawablesWithIntrinsicBounds(info.getImageSelected(), 0, 0, 0);
			lbl.setTextColor(Color.WHITE);
			lbl.setBackgroundColor(Color.parseColor("#727A84"));
		}
		else
		{
			lbl.setCompoundDrawablesWithIntrinsicBounds(info.getImage(), 0, 0, 0);
			lbl.setBackgroundResource(0);
			lbl.setTextColor(Color.GRAY);
		}
		return convertView;
	}

}

