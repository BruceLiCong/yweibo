package com.yeah.base;

public class Impulse 
{
	public Impulse(Neuron from, ImpulseType type, Object obj)
	{
		m_from = from;
		m_type = type;
		m_obj = obj;
	}
	
	public Neuron getNeuron()
	{
		return m_from;
	}
	
	public ImpulseType getType()
	{
		return m_type;
	}
	
	public Object getImpulse()
	{
		return m_obj;
	}
	
    public Neuron m_from;
    public ImpulseType m_type;
    public Object m_obj;
}
