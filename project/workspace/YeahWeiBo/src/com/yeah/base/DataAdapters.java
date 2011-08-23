package com.yeah.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class DataAdapters  extends BaseAdapter implements ItemConsumer, ViewConsumer
{
	public DataAdapters(Context context) 
    {
		m_context = context;
		m_producer = null;
		m_provider = null;
    }
	
	public ItemProducer attachProducer(ItemProducer producer)
	{
		ItemProducer oldProducer = m_producer;
		
		if(null != oldProducer)
		{
			oldProducer.removeConsumer(this);
		}
		
		m_producer = producer;
		
		if(null != m_producer)
		{
			m_producer.addConsumer(this);
		}
		
		if(null != m_provider)
		{
			m_provider.refresh();
		}
		
		return oldProducer;
	}
	
	public ItemProducer detachProducer()
	{
		return attachProducer(null);
	}
	
	public ViewProvider attachProvider(ViewProvider provider)
	{
		ViewProvider oldProvider = m_provider;
		
		m_provider = provider;
		
		if(null != m_provider)
		{
			m_provider.installConsumer(this);
			
			updateView();
		}
		
		return oldProvider;
	}
	
	public ViewProvider detachProvider()
	{
		ViewProvider oldProvider = m_provider;
		
		if(null != oldProvider)
		{
			oldProvider.uninstallConsumer();
		}
		
		m_provider = null;
		
		updateView();
		
		return oldProvider;
	}
	
	
	public int getSize()
    {
		// TODO Auto-generated method stub
		return getCount();
	}
	
	public void updateData() 
	{
		// TODO Auto-generated method stub
		if(null != m_provider)
		{
			m_provider.refresh();
		}
		updateView();
	}
	
    public void updateView()
    {
    	notifyDataSetChanged();
    }

    public Object getItem(int position) 
    {   
        // TODO Auto-generated method stub   
          return position;      
    }   

    public long getItemId(int position) 
    {   
        // TODO Auto-generated method stub   
        return position;      

    }   
    
    public int getCount() 
    {   
        // TODO Auto-generated method stub 
    	int count = 0;
    	
    	if(null != m_producer)
    	{
			count = m_producer.getCount();
    	}
    	
        return count;     
    }   

    public View getView(int position, View convertView, ViewGroup parent) 
    {
    	View newView = convertView;
    	
    	if((null != m_producer) 
    			&& (0 < m_producer.getCount())
    			&& (null != m_provider))
	    {
    		if(null == convertView)
    		{
    			convertView = LayoutInflater.from(m_context).inflate(m_provider.getResource(), null);
    			ViewCache viewCache = m_provider.createCache(convertView);
    			convertView.setTag(viewCache);
    		}
    		
    		newView = m_provider.setupView(position, convertView, m_producer.getItem(position));
	    }

    	return newView;
    }
    
    public void setOptionView(int optionView)
	{
		if(null != m_provider)
		{
			m_provider.setOptionView(optionView);
		}
	}
    
    public void setOptionData(int optionData)
	{
		if(null != m_producer)
		{
			m_producer.setOptionData(optionData);
		}
	}
	
	public void setCurPages(int page)
    {
		if(null != m_producer)
		{
			m_producer.setCurPages(page);
		}
    }
	
	public void setClues(long[] clues)
	{
		if(null != m_producer)
		{
			m_producer.setClues(clues);
		}
	}
	
	public int getCurPage() 
    {   
        // TODO Auto-generated method stub
		if(null == m_producer)
		{
			return 0;
		}
        return m_producer.getCurPage();     
    }
	
	public int getPageCount() 
    {   
		if(null == m_producer)
		{
			return 0;
		}
        return m_producer.getPageCount();     
    }  
    
    ItemProducer m_producer;
    ViewProvider m_provider;
    
    Context m_context;
}
