package com.yeah.interlayer;

public abstract class Browser 
{
	public void addOption(int opt)
	{
		m_option = m_option | opt;
	}
	
	public void removeOption(int opt)
	{
		m_option = m_option & (~opt);
	}
	
	public void setOption(int opt)
	{
		m_option = opt;
	}
	
	
	public int getOption()
	{
		return m_option;
	}
	public int getPage()
	{
		return m_page;
	}
	public long[] getIds()
	{
		return m_ids;
	}
	private long m_ids[];
	private int m_page;
	private int m_option;
	
}
