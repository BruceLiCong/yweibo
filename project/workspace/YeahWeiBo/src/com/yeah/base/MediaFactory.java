package com.yeah.base;

import java.net.URL;

import android.graphics.drawable.Drawable;

public interface MediaFactory 
{
	public Drawable getDrawableByURL(URL url, int priority);
}
