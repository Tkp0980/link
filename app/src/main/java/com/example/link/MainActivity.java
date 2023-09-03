package com.example.link;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String[] menuItems = {"Message", "Map", "Image"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menuItems);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0: // Message
                    Intent messageIntent = new Intent(MainActivity.this, MessageActivity.class);
                    startActivity(messageIntent);
                    break;
                case 1: // Map
                    Intent mapIntent = new Intent(MainActivity.this, MapActivity.class);
                    startActivity(mapIntent);
                    break;
                case 2: // Image
                    Intent imageIntent = new Intent(MainActivity.this, ImageActivity.class);
                    startActivity(imageIntent);
                    break;
            }
        });



    }
}
