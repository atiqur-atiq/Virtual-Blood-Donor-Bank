package com.example.atiqurrahman.virtualbloodbank;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by AtiqurRahman on 4/14/2017.
 */

public class MySingel {
    private static  MySingel mIsntance;
    private RequestQueue requestQueue;
    private static Context mctx;

    private MySingel(Context context){
        mctx=context;
        requestQueue=getRequestQueue();
    }

    public RequestQueue getRequestQueue(){
        if (requestQueue==null)
        {
            requestQueue= Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized  MySingel getIsntance(Context context){
        if (mIsntance==null){
            mIsntance=new MySingel(context);
        }
        return mIsntance;
    }
    public<T> void  addToRequestQueue(Request<T> request){
        requestQueue.add(request);
    }

}
