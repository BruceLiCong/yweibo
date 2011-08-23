package com.yeah.base;

import java.util.LinkedList;
import java.util.List;

public abstract class ItemProducer implements DataRequester
{
	public ItemProducer()
	{
		m_consumers = new LinkedList<ItemConsumer>();
		m_consumers.clear();
		m_countPage = 0;
        m_curPage = 0;
        m_clues = null;
        m_optionData = 0;
        m_items = null;
	}
	
	public void addConsumer(ItemConsumer consumer)
	{
        if(null != consumer)
        {
        	if(0 == m_consumers.size())
    		{
    			getItems();
    		}
    		m_consumers.add(consumer);
        }
		
	}
	
	public void removeConsumer(ItemConsumer consumer)
	{
		if(null != consumer)
        {
			m_consumers.remove(consumer);
        }
		
		if(0 == m_consumers.size())
		{
			m_countPage = 0;
	        m_curPage = 0;
	        m_clues = null;
	        m_optionData = 0;
	        m_items = null;
		}
	}
	
	public int getCount()
	{
        int count = 0;
    	
    	if(null != m_items)
    	{
			count = m_items.length;
    	}
    	
        return count; 
	}
	
	public void getItems()
	{
		getItemsEx(m_clues, m_curPage, m_optionData);
	}
	
	public void update(DataItem[] items, int page, int pageCount)
	{
		m_countPage = pageCount;
        m_curPage = page;
        m_items = items;
        
        for(int i = 0; i < m_consumers.size(); i ++)
		{
			m_consumers.get(i).updateData();
		}
	}
	
	public void setOptionData(int optionData)
	{
		if(optionData != m_optionData)
		{
			m_optionData = optionData;
			
			getItems();
		}
	}
	
	public boolean setCurPages(int page)
    {
    	if(page < m_countPage)
    	{
    		m_curPage = page;
    		getItems();
        	return true;
    	}
    	return false;
    }
	
	public int getCurPage() 
    {   
        // TODO Auto-generated method stub 
        return m_curPage;     
    }
	
	public int getPageCount() 
    {   
        // TODO Auto-generated method stub 
        return m_countPage;     
    }  
	
	public void setClues(long[] clues)
	{
		if(clues != m_clues)
		{
			m_clues = clues;
			
			getItems();
		}
	}
	
	public DataItem getItem(int pos)
	{
		if((m_items != null) && (pos < m_items.length))
		{
			return m_items[pos];
		}
		return null;
	}
	
	protected void getItemsEx(long[] clues, int page, int option)
	{
		update(null, 0, 0);
	}
	
	private long[] m_clues;
	
	private int m_optionData;
    
	private int m_curPage;
	private int m_countPage;
	
	private DataItem[] m_items;
    
	private List<ItemConsumer> m_consumers;
}
