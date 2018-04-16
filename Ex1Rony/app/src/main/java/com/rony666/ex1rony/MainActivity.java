package com.rony666.ex1rony;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView sentMessagesView = findViewById(R.id.listView);

        final ArrayList<String> messages = new ArrayList<>();
        final ArrayAdapter<String> messageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, messages);
        sentMessagesView.setAdapter(messageAdapter);


        Button sendButton = findViewById(R.id.send);
        sendButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TextInputLayout userBox = findViewById(R.id.userBox);
                TextInputLayout messageBox = findViewById(R.id.messageBox);

                if (userBox.getEditText() == null || messageBox.getEditText() == null) {
                    Log.w(TAG, "Edit text produced a null value.");
                    return;
                }

                String username = userBox.getEditText().getText().toString();
                String message = messageBox.getEditText().getText().toString();

                String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
                String tmp = message + "\nSent By: " + username + " at " + currentDateTimeString;


                messages.add(0, tmp);
                messageAdapter.notifyDataSetChanged();
            }
        });
    }
}
