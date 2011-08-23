package com.yeah.base;

import android.view.View;

public abstract class ViewProvider 
{
	public ViewProvider()
	{
		m_opts = null;
		m_optionView = 0;
	}
	
	public ViewConsumer installConsumer(ViewConsumer consumer)
	{
		ViewConsumer oldConsumer = m_consumer;
		
		refresh();
		
		return oldConsumer;
	}
	
	public ViewConsumer uninstallConsumer()
	{
		m_optionView = 0;
		return installConsumer(null);
	}
	
	public void refresh()
	{
		if(null != m_consumer)
		{
			int length = m_consumer.getSize();
			
			if(length > 0)
			{
			    m_opts = new int[length];
			}
			else
			{
				m_opts = null;
			}
		}
	}
	
	public void setOptionView(int optionView)
	{
		if(optionView != m_optionView)
		{
			m_optionView = optionView;
			if(null != m_consumer)
			{
				m_consumer.updateView();
			}
		}
	}
	
	public View setupView(int pos, View convertView, DataItem item)
	{
		return setupViewEx(pos, convertView, item, m_optionView);
	}
	
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
	
	protected int[] m_opts;
	
	private int m_optionView;
	private ViewConsumer m_consumer;
}
