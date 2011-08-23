package com.yeah.ui;

import android.view.View;

import com.yeah.base.DataItem;
import com.yeah.base.ViewCache;
import com.yeah.base.ViewProvider;

public class ViewProviderCommentList extends ViewProvider  
{
	protected ViewCache createCache(View base)
	{
		return null;
	}
	
	protected View setupViewEx(int pos, View convertView, DataItem item, int opt)
	{
		return convertView;
	}
	
	protected int getResource()
	{
		return 0;
	}
}
