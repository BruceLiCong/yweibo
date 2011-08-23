package com.yeah.toolkit;

import weibo4andriod.Weibo;
import weibo4andriod.WeiboException;
import weibo4andriod.http.AccessToken;
import weibo4andriod.http.RequestToken;
import android.net.Uri;

import com.yeah.YeahOAuthConstant;
import com.yeah.base.Certificate;

public class CertificateOAuth implements Certificate
{

	public void setup() 
	{
		System.setProperty("weibo4j.oauth.consumerKey", Weibo.CONSUMER_KEY);
    	System.setProperty("weibo4j.oauth.consumerSecret", Weibo.CONSUMER_SECRET);
		// TODO Auto-generated method stub
	}

	public Uri getUri() 
	{
		Weibo weibo = YeahOAuthConstant.getInstance().getWeibo();
		Uri uri = null;
    	RequestToken requestToken;
    	
		try 
		{
			requestToken = weibo.getOAuthRequestToken("yeah://WeiBoListViewActivity");
			uri = Uri.parse(requestToken.getAuthenticationURL()+ "&from=xweibo");
			YeahOAuthConstant.getInstance().setRequestToken(requestToken);
		} 
		catch (WeiboException e) 
		{
			e.printStackTrace();
		}
		
		return uri;
	}

	public void setUri(Uri uri) 
	{
		// TODO Auto-generated method stub
		try 
		{
			RequestToken requestToken = YeahOAuthConstant.getInstance().getRequestToken();
			AccessToken accessToken=requestToken.getAccessToken(uri.getQueryParameter("oauth_verifier"));
			YeahOAuthConstant.getInstance().setAccessToken(accessToken);
		} 
		catch (WeiboException e) 
		{
			e.printStackTrace();
		}
	}
}
