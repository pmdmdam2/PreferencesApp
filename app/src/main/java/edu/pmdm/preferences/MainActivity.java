package edu.pmdm.preferences;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int PREFERENCES_ACTION=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPreferences();
    }

    private void getPreferences(){
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(this);
        Boolean bounce= preferences.getBoolean("rebote",false);
        String usuario = preferences.getString("usuario","Sin usuario");
        String velocidad = preferences.getString("velocidad","");
        TextView textView = findViewById(R.id.tvUsuario);
        textView.setText("Usuario:" + usuario);
        textView = findViewById(R.id.tvRebote);
        textView.setText("Rebote:" + (bounce?"Con rebote":"Sin rebote"));
        textView = findViewById(R.id.tvVelocidad);
        textView.setText("Velocidad:" + velocidad);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
         super.onOptionsItemSelected(item);
         switch(item.getItemId()){
             case R.id.imPreferences:
                 Intent preferences = new Intent(MainActivity.this,PreferencesActivity.class);
                 startActivityForResult(preferences,PREFERENCES_ACTION);
                 break;
         }
         return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PREFERENCES_ACTION){
            if(resultCode== Activity.RESULT_OK){
                getPreferences();
            }
        }
    }
}