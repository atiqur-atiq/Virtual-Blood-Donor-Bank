package com.example.atiqurrahman.virtualbloodbank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText name,blood,cell,location;
    Button submit;
    RequestQueue requestQueue;
    String insertURL="http://iamatiqur.tk/blood/insert.php";
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
         name=(EditText)findViewById(R.id.name);
        blood=(EditText)findViewById(R.id.blood);
        cell=(EditText)findViewById(R.id.cell);
        location=(EditText)findViewById(R.id.location);
        submit=(Button)findViewById(R.id.submit);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request=new StringRequest(Request.Method.POST, insertURL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected  Map<String,String>getParams()throws AuthFailureError{
                        Map<String,String>parametetrs=new HashMap<String, String>();
                        parametetrs.put("name",name.getText().toString());
                        parametetrs.put("cell",cell.getText().toString());
                        parametetrs.put("location",location.getText().toString());
                        parametetrs.put("blood",blood.getText().toString());
                        return parametetrs;
                    }
                };
                requestQueue.add(request);

                Intent i= new Intent(Register.this,MainActivity.class);
                startActivity(i);
            }
        });

    }
}
