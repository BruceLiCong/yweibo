package com.yeah.ui;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.yeah.R;
import com.yeah.base.DataItem;
import com.yeah.base.Database;
import com.yeah.base.ViewCache;
import com.yeah.base.ViewProvider;
import com.yeah.toolkit.Toolkit;

public class ViewProviderStatusList extends ViewProvider 
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
			DataItem userItem = yeahDatabase.getAuthor(item);
			
			//ImageView weiboFace = (ImageView)convertView.findViewById(R.id.img_face);
	    	
	    	LinearLayout weiboContext = (LinearLayout)convertView.findViewById(R.id.layout_context);
	    	TextView weiboContent = (TextView)weiboContext.findViewById(R.id.text_content);
	    	
	    	LinearLayout weiboInfoLayout = (LinearLayout)weiboContext.findViewById(R.id.layout_info);
	    	
	    	Button weiboComment = (Button)weiboInfoLayout.findViewById(R.id.button_comment);
	    	
	    	weiboComment.setText("comment");
	    	
	    	weiboComment.setOnClickListener(new Button.OnClickListener()
	        {
	            public void onClick( View v )
	            {
	            	//Context context = getApplicationContext(); 
	            	CharSequence text = "Hello toast!"; 
	            	int duration = Toast.LENGTH_SHORT; 
	            	 
	            	Toast toast = Toast.makeText(v.getContext(), text, duration); 
	            	toast.show();
	            	
	            	Button weiboComment = (Button)v;
	            	
	            	weiboComment.setText("beClicked");	            	
	            }
	        });
	    	//weiboFace.setImageBitmap(yeahDatabase.getProfileBitmap(userId));
	    	weiboContent.setText(yeahDatabase.getScreenName(userItem) + " : " + yeahDatabase.getContext(item) + "\n");

		}

		return convertView;
	}
	
	protected int getResource()
	{
		return R.layout.weibolistitem;
	}
}
