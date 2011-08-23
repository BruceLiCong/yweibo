package com.yeah.toolkit;

import com.yeah.base.Certificate;
import com.yeah.base.Database;
import com.yeah.base.MediaFactory;

import android.content.Context;

public class Toolkit
{
	public static synchronized void initialize(Context context) 
	{
		if (context == null) 
		{
			throw new IllegalArgumentException("Param Activity is null.");
		}
		
		if (s_instance != null)
		{
			Toolkit.destroy();
		}
		s_context = context;
		s_instance = new Toolkit();
	}
	
	public static boolean isInitialized()
	{
		return s_context != null;
	}
	
	private static void destroy() 
	{
		// TODO Auto-generated method stub
		if (s_instance != null)
		{
			s_instance.release();
		}
		s_instance = null;
		s_context = null;
	}
	
	private void release() 
	{
		// TODO Auto-generated method stub
		
	}
	
	public static Toolkit getInstance() 
	{
		if (s_instance == null) 
		{
			throw new IllegalArgumentException("Parameter s_instance is null.");
		}
		return s_instance;
	}
	
	public Database getDatabase()
	{
		return m_database;
	}
	
	public MediaFactory getMediaFactory()
	{
		return m_media_factory;
	}
	
	public Certificate getCertificate()
	{
		return m_certificate;
	}
	
	private Toolkit()
    {
    	m_certificate = new CertificateDirect();
    	m_media_factory = new MediaFactoryDirect();
    	m_database = new DatabaseDirect();
    };
	
	private static Context s_context;
	private static Toolkit s_instance;
	
	private Database m_database;
	private MediaFactory m_media_factory;
	private Certificate m_certificate;

}
