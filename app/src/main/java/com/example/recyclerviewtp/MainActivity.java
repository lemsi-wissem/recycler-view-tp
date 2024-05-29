package com.example.recyclerviewtp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        List<String> dataSet = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            dataSet.add("Item " + i);
        }

        MyAdapter adapter = new MyAdapter(dataSet);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view -> {
            dataSet.add(dataSet.size(), "New Item");
            adapter.notifyItemInserted(dataSet.size());
            recyclerView.scrollToPosition(dataSet.size() - 1);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.contact) {
            Toast.makeText(this, "Contact", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.AboutUs) {
            Toast.makeText(this, "About us", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.profile) {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}