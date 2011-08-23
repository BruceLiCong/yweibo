package com.yeah.toolkit;

import java.util.Date;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.yeah.base.DataItem;
import com.yeah.base.DataRequester;
import com.yeah.base.Database;

public class DatabaseService  extends Service 
{

	@Override
	public IBinder onBind(Intent intent) 
	{
		// TODO Auto-generated method stub
		return m_databaseBinder;
	}

    public class DatabaseBinder extends Binder implements Database
    {

		public void getStatuses(DataRequester requester, long[] uids, int page,
				int opt) {
			// TODO Auto-generated method stub
			
		}

		public void getFriends(DataRequester requester, long[] uids, int page,
				int opt) {
			// TODO Auto-generated method stub
			
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
			return null;
		}

		public String getContext(DataItem item) {
			// TODO Auto-generated method stub
			return null;
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
			return null;
		}

    }
    
    private DatabaseBinder m_databaseBinder = new DatabaseBinder();

}
