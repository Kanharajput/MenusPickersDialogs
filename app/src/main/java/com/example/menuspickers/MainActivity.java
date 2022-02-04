package com.example.menuspickers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private TextView txtv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // setting up the toolbar
        // don't use setSupportActionBar as it not workng
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        toolbar.setTitle("Trying Menu");
        toolbar.inflateMenu(R.menu.main_menu);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_setting:
                        showToast("settings are not available");
                        return true;

                    case R.id.action_favorite:
                        showToast("added to favorite");
                        return true;                               // if handled then return true

                    default:
                        return false;
                }
            }
        });

        // referencing the textview
        txtv = findViewById(R.id.textView);

        // register the view to the context menu
        registerForContextMenu(txtv);


    }

    @Override        // to create context menu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_edit :
                            showToast("Edit karenga hosiyar");
                            return true;

            case R.id.action_share :
                            showToast("kisko bhejega bata");
                            return true;

            case R.id.action_delete:
                            showToast("delete! soch le");
                            return true;

            default: showToast("kaha click ker ra");
                return false;
        }
    }

    public void showToast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}