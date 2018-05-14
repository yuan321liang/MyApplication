package com.example.ylyl.myapplication;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest{
    private static final String LOGIN_REQUEST_URL = "https://fjupost.000webhostapp.com/Login.php";
    private Map<String, String> params;

    public LoginRequest(int ldap, String password, Response.Listener<String> listener ){
        super(Request.Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>( );
        params.put("ldap",ldap + "");
        params.put("password",password);
        Log.e("LoginRequest","4");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
