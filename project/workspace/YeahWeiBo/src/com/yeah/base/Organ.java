package com.yeah.base;

import android.content.Context;

public abstract class Organ implements Neuron
{
    public Organ(Context context)
	{
		m_context = context;
	}
    
    public Robot JointRobot(Robot robot)
    {
    	Robot oldRobot = m_robot;
    	
    	m_robot = robot;
    	
    	return oldRobot;
    }
    
    public Robot DisjointRobot(Robot robot)
    {
    	return JointRobot(null);
    }
    
    protected Robot m_robot;
    protected Context m_context;
}
