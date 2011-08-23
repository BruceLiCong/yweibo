package com.yeah.base;

import android.view.View;

public class ViewCache 
{
	private View m_base;
	private View[] m_views;
	private int[] m_ids;
	
	ViewCache(View base, int[] ids)
	{
		m_base = base;
		m_ids = ids;
		if(ids != null)
		{
			m_views = new View[ids.length];
		}
		else
		{
			m_views = null;
		}
	}
	
	public View getViewByIndex(int index)
	{
		if((null != m_views) && (index < m_views.length))
		{
		    if (m_views[index] == null)
		    {   
			    m_views[index] = m_base.findViewById(m_ids[index]);   
            }   
            return m_views[index];
		}
		return null;
	}
	
	public View getBaseView()
	{
		return m_base;
	}
}
