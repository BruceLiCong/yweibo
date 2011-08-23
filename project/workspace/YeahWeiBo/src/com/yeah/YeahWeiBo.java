package com.yeah;

import com.yeah.toolkit.Toolkit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class YeahWeiBo extends Activity 
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolkit.initialize(this);
        Log.d("YeahWeiBo", "before YeahToolkit");
        Toolkit.getInstance().getCertificate().setup();
        Log.d("YeahWeiBo", "after YeahToolkit");
    	Button beginOuathBtn = (Button) findViewById(R.id.button_login);
    	

    	beginOuathBtn.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick( View v )
            {
	    		startActivity(new Intent(Intent.ACTION_VIEW, Toolkit.getInstance().getCertificate().getUri()));
            }
        });
    }
}