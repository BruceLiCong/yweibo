package com.yeah.base;

import java.util.LinkedList;
import java.util.List;

import android.content.Context;

public abstract class Robot implements Neuron
{
	public Robot(Context context)
	{
		m_context = context;
		m_organ = new LinkedList<Organ>();
	}
	
	public void nervousImpulse(Impulse impulse) 
	{
		// TODO Auto-generated method stub
		for(int i = 0; i < m_organ.size(); i++)
		{
			m_organ.get(i).nervousImpulse(impulse);
		}
		
	}
	
	protected void attachNeuron(Organ organ)
	{
		if((null != organ) && ((-1) == m_organ.indexOf(organ)))
		{
			organ.JointRobot(this);
			m_organ.add(organ);
		}
	}
	
	protected void detachNeuron(Organ organ)
	{
		if((null != organ))
		{
			if(m_organ.remove(organ))
			{
				organ.DisjointRobot(this);
			}
		}
	}
	
	protected List<Organ> m_organ;
	protected Context m_context;
}
