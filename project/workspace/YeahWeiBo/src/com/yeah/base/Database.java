package com.yeah.base;

import java.util.Date;

public interface Database 
{
    public void getStatuses(DataRequester requester, long[] uids, int page, int opt);
    public void getFriends(DataRequester requester, long[] uids, int page, int opt);
    public void getClasses(DataRequester requester, long[] uids, int page, int opt);
    public void getComments(DataRequester requester, long[] sids, int page, int opt);
    
    ///////////////////////////////////////
    
    public DataItem getAuthor(DataItem item);
	public String getContext(DataItem item);
	public String getMediaThumbnail(DataItem item);
	public String getMediaBmiddle(DataItem item);
	public String getMediaOriginal(DataItem item);
	public long getTransmitId(DataItem item);
	public Date getCreateDate(DataItem item);
	public int getTransmitCount(DataItem item);
	
	
	public String getMediaProfile(DataItem item);
	public long getLastStatusId(DataItem item);
	public String getScreenName(DataItem item);
}
