package com.yeah;

import weibo4andriod.Weibo;
import weibo4andriod.http.AccessToken;
import weibo4andriod.http.RequestToken;

public class YeahOAuthConstant 
{
	private YeahOAuthConstant(){};
	
	public static synchronized YeahOAuthConstant getInstance()
	{
		if(m_oauth_instance == null)
		{
			m_oauth_instance= new YeahOAuthConstant();
		}
		return m_oauth_instance;
	}
	public Weibo getWeibo()
	{
		if(m_weibo == null)
		{
			m_weibo = new Weibo();
		}
		return m_weibo;
	}
	
	public AccessToken getAccessToken() 
	{
		return m_accessToken;
	}
	public void setAccessToken(AccessToken accessToken) 
	{
		this.m_accessToken = accessToken;
		this.m_token = accessToken.getToken();
		this.m_tokenSecret = accessToken.getTokenSecret();
	}
	public RequestToken getRequestToken() 
	{
		return m_requestToken;
	}
	public void setRequestToken(RequestToken requestToken) 
	{
		this.m_requestToken = requestToken;
	}
	public String getToken() 
	{
		return m_token;
	}
	public void setToken(String token) 
	{
		this.m_token = token;
	}
	public String getTokenSecret() 
	{
		return m_tokenSecret;
	}
	public void setTokenSecret(String tokenSecret) 
	{
		this.m_tokenSecret = tokenSecret;
	}
	
	private static Weibo m_weibo = null;
	private static YeahOAuthConstant m_oauth_instance = null;
	private RequestToken m_requestToken;
	private AccessToken m_accessToken;
	private String m_token;
	private String m_tokenSecret;
}
