package com.yeah.toolkit;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.drawable.Drawable;

import com.yeah.base.MediaFactory;

public class MediaFactoryDirect implements MediaFactory 
{

	public Drawable getDrawableByURL(URL url, int priority) 
	{
		InputStream i = null;
        try 
        {
            i = (InputStream) url.getContent();
        } 
        catch (MalformedURLException e1)
        {
            e1.printStackTrace();
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
		return Drawable.createFromStream(i, "src");

	}

}
