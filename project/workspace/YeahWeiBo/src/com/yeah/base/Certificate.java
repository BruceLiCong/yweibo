package com.yeah.base;

import android.net.Uri;

public interface Certificate 
{
	public void setup();
    public Uri getUri();
    public void setUri(Uri uri);
}
