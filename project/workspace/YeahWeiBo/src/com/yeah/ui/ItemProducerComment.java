package com.yeah.ui;

import com.yeah.base.Database;
import com.yeah.base.ItemProducer;
import com.yeah.toolkit.Toolkit;

public class ItemProducerComment extends ItemProducer 
{

	protected void getItemsEx(long[] clues, int page, int option)
	{
		Database database = Toolkit.getInstance().getDatabase();
    	if(null != database)
    	{
    		database.getComments(this, clues, page, option);
    	}
	}


}
