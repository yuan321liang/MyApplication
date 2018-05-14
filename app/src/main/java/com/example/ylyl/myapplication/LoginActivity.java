package com.example.ylyl.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AlertDialogLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.app.AlertDialog;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etName = (EditText) findViewById(R.id.etName);
        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
        final Button etbutton = (Button) findViewById(R.id.button);
        final TextView etText = (TextView) findViewById(R.id.etText);

        etbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Login","clicked");
                final int ldap = Integer.parseInt(etName.getText( ).toString( ));
                final String password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response){
                        try{
                            Log.e("Login","try");
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success){
                                Log.e("Login","1");
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                                LoginActivity.this.startActivity(intent);
                            }else{
                                Log.e("Login","2");
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };
                Log.e("Login","3");
                LoginRequest loginRequest = new LoginRequest(ldap, password,responseListener);
            }
        });
    }
}
