package com.example.androidninjaworkspace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.androidninjaworkspace.Adapter.RvRowAdapter;
import com.example.androidninjaworkspace.models.data;
import com.example.androidninjaworkspace.models.models;
import com.example.androidninjaworkspace.rest.RestClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {


    private ArrayList<models> dataList;
    RecyclerView recyclerView;
    RvRowAdapter adapter;
    Context context;
    RequestQueue requestQueue;
    Button btnLoadMore;
    int index = 1;
    String url = "https://reqres.in/api/users?per_page=6&page=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rvMAin);
        btnLoadMore = findViewById(R.id.btnLoadMore);
       requestQueue = Volley.newRequestQueue(this);
        context = this;
        dataList = new ArrayList<>();






        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url+"1", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    dataList.clear();
                    JSONArray cards = response.getJSONArray("data");

                    index = 2;
                    for (int i = 0; i < cards.length(); i++) {

                        JSONObject token = cards.getJSONObject(i);

                             int id =   token.getInt("id");
                              String brand   = token.getString("email");
                                String firstName   = token.getString("first_name");
                                String lastName =   token.getString("last_name");
                                String avtar  = token.getString("avatar");

                                dataList.add(new models(id,brand,firstName,lastName,avtar));



                    }
                    adapter = new RvRowAdapter(context,dataList);
                    recyclerView.setAdapter(adapter);

                } catch ( JSONException e) {

                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });



        requestQueue.add(jsonObjectRequest);


        btnLoadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoadMore( 2);
            }
        });


   }

    private void LoadMore(int page) {

        if (index <= 2) {


            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url + page, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray cards = response.getJSONArray("data");
                        index++;
                        for (int i = 0; i < cards.length(); i++) {
                            JSONObject token = cards.getJSONObject(i);

                            int id = token.getInt("id");
                            String brand = token.getString("email");
                            String firstName = token.getString("first_name");
                            String lastName = token.getString("last_name");
                            String avtar = token.getString("avatar");

                            dataList.add(new models(id, brand, firstName, lastName, avtar));


                        }
                        adapter = new RvRowAdapter(context, dataList);
                        recyclerView.setAdapter(adapter);


                        adapter.notifyDataSetChanged();

                    } catch (JSONException e) {

                        e.printStackTrace();
                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {


                }
            });


            requestQueue.add(jsonObjectRequest);


        }
    }




}