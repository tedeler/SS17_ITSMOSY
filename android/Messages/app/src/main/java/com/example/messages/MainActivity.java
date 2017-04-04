package com.example.messages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.message.MESSAGE";
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.edit_message);

        Button button = (Button) findViewById(R.id.button_send);

        ListView listView = (ListView)findViewById(R.id.list_todo);
        final ArrayList<String> todoList = new ArrayList<String>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoList);
        listView.setAdapter(arrayAdapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // hide keyboard
                ((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(textView.getWindowToken(), 0);

                String message = textView.getText().toString();
                textView.setText("");
                todoList.add(message);
                arrayAdapter.notifyDataSetChanged();

                // send message to other activity
                Intent intent = new Intent(MainActivity.this, MessageActivity.class);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);

            }
        });
    }
}
