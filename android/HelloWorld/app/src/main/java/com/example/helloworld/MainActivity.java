package com.example.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.edit_message);
        Button button = (Button)findViewById(R.id.button_send);

        ListView listView = (ListView)findViewById(R.id.list_todo);
        final ArrayList<String>todoList = new ArrayList<String>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, todoList);
        listView.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // hide keyboard
                ((InputMethodManager)getSystemService(INPUT_METHOD_SERVICE))
                        .hideSoftInputFromWindow(editText.getWindowToken(), 0);

                String message = editText.getText().toString();
                editText.setText("");
//                Toast toast = Toast.makeText(MainActivity.this,
//                        "Message: " + message, Toast.LENGTH_LONG);
//                toast.show();

                todoList.add(message);
                arrayAdapter.notifyDataSetChanged();
            }
        });

    }
}