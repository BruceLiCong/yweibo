package com.yeah.ui;

import android.view.View;
import android.widget.TextView;

import com.yeah.R;
import com.yeah.base.DataItem;
import com.yeah.base.Database;
import com.yeah.base.ViewCache;
import com.yeah.base.ViewProvider;
import com.yeah.toolkit.Toolkit;

public class ViewProviderUserList extends ViewProvider  
{
	protected ViewCache createCache(View base)
	{
		return null;
	}
	
	protected View setupViewEx(int pos, View convertView, DataItem item, int opt)
	{
        Database yeahDatabase = Toolkit.getInstance().getDatabase();
		
		if((null != yeahDatabase) && (null != convertView))
		{			
			//ImageView weiboFace = (ImageView)convertView.findViewById(R.id.img_face);
	    	
	    	TextView weiboName = (TextView)convertView.findViewById(R.id.text_name);
	    	
	    	weiboName.setText(yeahDatabase.getScreenName(item));

		}

		return convertView;
	}
	
	protected int getResource()
	{
		return R.layout.userlistitem;
	}
}
