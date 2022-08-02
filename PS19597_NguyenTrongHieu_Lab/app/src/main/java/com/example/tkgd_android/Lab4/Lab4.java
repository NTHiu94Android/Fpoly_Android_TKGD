package com.example.tkgd_android.Lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tkgd_android.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Lab4 extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView navigationView;
    ListView lvLab4;
    String Array[] = {"CNTT", "TKDH", "LTMB", "TKW"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);
        toolbar = findViewById(R.id.tbLab4);
        navigationView = findViewById(R.id.btNavMenuLab4);
        lvLab4 = findViewById(R.id.lvLab4);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Lab4.this, android.R.layout.simple_list_item_1, Array);
        lvLab4.setAdapter(adapter);
        registerForContextMenu(lvLab4);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Lab4.super.onBackPressed();
            }
        });

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Lab4HomeMenu:
                        Toast.makeText(getApplicationContext(), "HomeNav", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Lab4FavMenu:
                        Toast.makeText(getApplicationContext(), "FavoriteNav", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.Lab4AccMenu:
                        Toast.makeText(getApplicationContext(), "AccountNav", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lab4_option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Lab4Add:
                Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Lab4Delete:
                Toast.makeText(getApplicationContext(), "Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.Lab4Search:
                Toast.makeText(getApplicationContext(), "Search", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.lab4_context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        switch (item.getItemId()){
            case R.id.itemXoaContextMenuLab4:
                Toast.makeText(getApplicationContext(), "Xóa "+ Array[index], Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemSuaContextMenuLab4:
                Toast.makeText(getApplicationContext(), "Sửa "+ Array[index], Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }
}