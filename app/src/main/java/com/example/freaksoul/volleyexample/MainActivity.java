package com.example.freaksoul.volleyexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.util.*;

public class MainActivity extends AppCompatActivity {
    private static final String TAG= MainActivity.class.getName();
Button btn;
    TextView textView;
    RequestQueue requestQueue;
    StringRequest stringRequest;
    //String server_url="https://team4success.000webhostapp.com/connectDatabase.php";
    String server_url="https://team4success.000webhostapp.com/connectDatabase.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        btn = (Button) findViewById(R.id.buttonResponse);
        textView = (TextView)findViewById(R.id.textView);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

        public void Click(View v) {
            sendRequestAndPrintResponse();
        }

    private void sendRequestAndPrintResponse() {
   requestQueue = Volley.newRequestQueue(this);
        stringRequest =  new StringRequest(Request.Method.POST,server_url,new Response.Listener<String>(){

            @Override
            public void onResponse(String response) {
Log.i(TAG,"response: "+ response.toString());
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
Log.i(TAG,"ERROR: "+error.toString());
            }
        });
        requestQueue.add(stringRequest);

    }
}
