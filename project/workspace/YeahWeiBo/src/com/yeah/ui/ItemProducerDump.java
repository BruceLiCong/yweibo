package com.yeah.ui;

import com.yeah.base.DataItem;
import com.yeah.base.ItemProducer;

public class ItemProducerDump extends ItemProducer
{
	protected void getItemsEx(long[] clues, int page, int option)
	{
		DataItem[] items = null;
		int pageCount = 0;
		
		if((null != clues) && (0 != clues.length))
		{
			items = new DataItem[clues.length];
			
			for(int i = 0; i < clues.length; i++)
			{
				items[i] = new DataItem(clues[i], null);
			}
			pageCount = 1;
		}
		
		update(items, 0, pageCount);
	}
}
