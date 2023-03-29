package com.m0x1n.Xiaoai_chat;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {

    private EditText queryEditText;
    private Button getButton;
    private EditText resultEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        queryEditText = findViewById(R.id.editText);
        getButton = findViewById(R.id.button);
        resultEditText = findViewById(R.id.resultText);

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View hellov) {
                String query = queryEditText.getText().toString();
                String url = "http://v.api.aa1.cn/api/api-xiaoai/talk.php?msg=" + query + "&type=text";

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                resultEditText.setText(response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        resultEditText.setText("Error: " + error.getMessage());
                    }
                });

                queue.add(stringRequest);
            }
        });
    }
}
