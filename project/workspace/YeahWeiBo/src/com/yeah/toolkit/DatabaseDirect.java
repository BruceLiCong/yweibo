package com.yeah.toolkit;

import java.util.Date;
import java.util.HashMap;

import android.util.Log;

import com.yeah.base.DataItem;
import com.yeah.base.DataRequester;
import com.yeah.base.Database;

public class DatabaseDirect implements Database
{
	public DatabaseDirect()
	{
		m_contexts = new HashMap<Long, String>();
	    m_uids = new HashMap<Long, Long>();
	    m_screenNames = new HashMap<Long, String>();
	    
		long uid = addUser("linyi");
	    addStatus("test by linyi hello" ,uid);
	    addStatus("test by linyi 1" ,uid);
	    addStatus("test by linyi 2" ,uid);
	    addStatus("test by linyi 3" ,uid);
	    addStatus("test by linyi 4" ,uid);
	    uid = addUser("licong");
	    addStatus("test by licong hello" ,uid);
	    addStatus("test by licong 1" ,uid);
	    addStatus("test by licong 2" ,uid);
	    addStatus("test by licong 3" ,uid);
	    addStatus("test by licong 4" ,uid);
		uid = addUser("jiangchao");
		addStatus("test by jiangchao hello" ,uid);
	    addStatus("test by jiangchao 1" ,uid);
	    addStatus("test by jiangchao 2" ,uid);
	    addStatus("test by jiangchao 3" ,uid);
	    addStatus("test by jiangchao 4" ,uid);
		uid = addUser("lili");
		addStatus("test by lili hello" ,uid);
	    addStatus("test by lili 1" ,uid);
	    addStatus("test by lili 2" ,uid);
	    addStatus("test by lili 3" ,uid);
	    addStatus("test by lili 4" ,uid);
		uid = addUser("wangwenze");
		addStatus("test by wangwenze hello" ,uid);
	    addStatus("test by wangwenze 1" ,uid);
	    addStatus("test by wangwenze 2" ,uid);
	    addStatus("test by wangwenze 3" ,uid);
	    addStatus("test by wangwenze 4" ,uid);
		uid = addUser("tanwei");
		addStatus("test by tanwei hello" ,uid);
	    addStatus("test by tanwei 1" ,uid);
	    addStatus("test by tanwei 2" ,uid);
	    addStatus("test by tanwei 3" ,uid);
	    addStatus("test by tanwei 4" ,uid);
	    uid = addUser("jinwei");
		addStatus("test by jinwei hello" ,uid);
	    addStatus("test by jinwei 1" ,uid);
	    addStatus("test by jinwei 2" ,uid);
	    addStatus("test by jinwei 3" ,uid);
	    addStatus("test by jinwei 4" ,uid);
	}
	
	public long addUser(String name)
	{
		Log.d("init", "adduser");
		m_screenNames.put(Long.valueOf(m_screenNames.size()), name);
		return Long.valueOf(m_screenNames.size()) - 1;
	}
	
	public long addStatus(String context, long uid)
	{
		m_contexts.put(Long.valueOf(m_contexts.size()), context);
		m_uids.put(Long.valueOf(m_uids.size()), uid);
		return Long.valueOf(m_uids.size()) - 1;
	}

	public void getStatuses(DataRequester requester, long[] uids, int page,
			int opt)
	{
		DataItem[] items = new DataItem[m_uids.size()];
		
		for(int i = 0; i < items.length; i ++ )
		{
			items[i] = new DataItem(i, null);
		}

		requester.update(items, 0, 1);

	}

	public void getFriends(DataRequester requester, long[] uids, int page,
			int opt) 
	{
        DataItem[] items = new DataItem[m_screenNames.size()];
		
		for(int i = 0; i < items.length; i ++ )
		{
			items[i] = new DataItem(i, null);
		}

		requester.update(items, 0, 1);

	}

	public void getClasses(DataRequester requester, long[] uids, int page,
			int opt) {
		// TODO Auto-generated method stub

	}

	public void getComments(DataRequester requester, long[] sids, int page,
			int opt) {
		// TODO Auto-generated method stub

	}

	public DataItem getAuthor(DataItem item) {
		// TODO Auto-generated method stub
		return new DataItem(m_uids.get(Long.valueOf(item.m_id)), null);
	}

	public String getContext(DataItem item) {
		// TODO Auto-generated method stub
		return m_contexts.get(Long.valueOf(item.m_id));
	}

	public String getMediaThumbnail(DataItem item) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMediaBmiddle(DataItem item) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMediaOriginal(DataItem item) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getTransmitId(DataItem item) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Date getCreateDate(DataItem item) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTransmitCount(DataItem item) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getMediaProfile(DataItem item) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getLastStatusId(DataItem item) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getScreenName(DataItem item) {
		// TODO Auto-generated method stub
		return m_screenNames.get(Long.valueOf(item.m_id));
	}
	
	HashMap<Long, String> m_contexts;
    HashMap<Long, Long> m_uids;
    
    HashMap<Long, String> m_screenNames;

}
