package com.example.myfirstapp;

import android.content.Intent;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private static final Logger LOGGER = Logger.getLogger(MainActivity.class.getName());

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Called when the user taps the send button
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        makeJsonfromString(message);
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

    public void makeJsonfromString(String message){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name",message);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}