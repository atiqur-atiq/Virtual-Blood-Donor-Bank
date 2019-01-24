package com.example.atiqurrahman.virtualbloodbank;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by AtiqurRahman on 4/14/2017.
 */

public class BackgroundTask {

    Context context;
    ArrayList<contact> arrayList=new ArrayList<>();
    String json_url="http://iamatiqur.tk/blood/shoooo.php";
    public BackgroundTask(Context context){
        this.context=context;
    }
    public ArrayList<contact> getList(){

        JsonArrayRequest jsonArrayRequest =new JsonArrayRequest(Request.Method.POST,json_url,null,new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int count=0;
                        while(count<response.length()){
                            try{
                            JSONObject jsonObject= response.getJSONObject(count);
                               contact contac=new contact(jsonObject.getString("name"),jsonObject.getString("blood"),jsonObject.getString("cell"),jsonObject.getString("location"));
                                arrayList.add(contac);
                                count++;

                        }catch (JSONException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context,"Error....",Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
    });
        MySingel.getIsntance(context).addToRequestQueue(jsonArrayRequest);
        return arrayList;
    }
}
