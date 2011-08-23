package com.yeah;

import com.yeah.base.DataAdapters;
import com.yeah.toolkit.Toolkit;
import com.yeah.ui.ItemProducerStatus;
import com.yeah.ui.ItemProducerUser;
import com.yeah.ui.ViewProviderStatusList;
import com.yeah.ui.ViewProviderUserList;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.GestureDetector.OnGestureListener;
import android.widget.ListView;
import android.widget.ViewFlipper;
public class YeahMainActivity extends Activity implements OnGestureListener
{
	public static final int m_aStatus = 0x00000000;
	public static final int m_aUser = 0x00000001;
	public static final int m_aMax = 0x00000002;
	
    private ServiceConnection m_serviceConnection = new ServiceConnection()
	{
	    public void onServiceConnected(ComponentName name, IBinder service) 
	    {
        	//m_databaseBinder = (Database) service;
	    }
	    
	    public void onServiceDisconnected(ComponentName name) 
	    {
        	//m_databaseBinder = null;
	    }
	};
    
        //private Database m_databaseBinder;
	
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weibolist);
		
		this.bindService(new Intent("com.yeah.toolkit.DatabaseService"), this.m_serviceConnection, BIND_AUTO_CREATE);
		
		m_GestureDetector = new GestureDetector((android.view.GestureDetector.OnGestureListener) this);	

		
		Toolkit.getInstance().getCertificate().setUri(this.getIntent().getData());
	    
		m_flipper = (ViewFlipper)findViewById(R.id.flipper_list);
		ListView list_weibo = (ListView) m_flipper.findViewById(R.id.listview_weibo);
		ListView list_friends = (ListView) m_flipper.findViewById(R.id.listview_friends);
		
		m_adapters = new DataAdapters[m_aMax];
		
		m_adapters[m_aStatus] = new DataAdapters(this);
		m_adapters[m_aStatus].attachProducer(new ItemProducerStatus());
		m_adapters[m_aStatus].attachProvider(new ViewProviderStatusList());
		list_weibo.setAdapter(m_adapters[m_aStatus]);
		
		m_adapters[m_aUser] = new DataAdapters(this);
		m_adapters[m_aUser].attachProducer(new ItemProducerUser());
		m_adapters[m_aUser].attachProvider(new ViewProviderUserList());
		list_friends.setAdapter(m_adapters[m_aUser]);
		
		n_curAdapter = m_aStatus;
	}
	
	
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3)
	{
		float dy = (arg0.getY() > arg1.getY()) ?  (arg0.getY() - arg1.getY()) : (arg1.getY() - arg0.getY());
		if(arg0.getX() > (arg1.getX() + dy))
        {
			switchSubject(true);
	    }
		else if(arg0.getX() < (arg1.getX() - dy))
		{
			switchSubject(false);
		}
		else 
		{
			return false;
		}
		return true; 
	}

	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean dispatchTouchEvent(MotionEvent event)
	{
		if(!m_GestureDetector.onTouchEvent(event))
		{
			return super.dispatchTouchEvent(event);
		}
		return super.dispatchTouchEvent(event);
	}
	
	public void switchSubject(boolean next)
	{
		if(next)
		{
			m_flipper.showNext();
			
			n_curAdapter = (n_curAdapter + 1) % m_aMax;
		}
		else
		{
			m_flipper.setInAnimation(getApplicationContext(), R.anim.push_right_in);
			m_flipper.setOutAnimation(getApplicationContext(), R.anim.push_right_out);
			m_flipper.showPrevious();
			m_flipper.setInAnimation(getApplicationContext(), R.anim.push_left_in);
			m_flipper.setOutAnimation(getApplicationContext(), R.anim.push_left_out);
			
			n_curAdapter = (n_curAdapter + m_aMax - 1) % m_aMax;
		}
	}

	
	private GestureDetector m_GestureDetector;

	private ViewFlipper m_flipper;
	private DataAdapters[] m_adapters;
	//private List<Long> m_recentlyAuthor;
	//private List<Long> m_recentlyFriend;
	//private List<Long> m_recentlyStatus;
	private int n_curAdapter;

}
