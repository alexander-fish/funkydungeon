package com.mmfb.funky_dungeon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewUser extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.mmfb.funky_dungeon.funkydungeonsharedprefs";
    private EditText str;
    private EditText dex;
    private EditText con;
    private EditText intel;
    private EditText wis;
    private EditText cha;
    private EditText prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        setContentView(R.layout.activity_new_user);
    }

    public void launchRoller(View view) {
        str = findViewById(R.id.strValue);
        dex = findViewById(R.id.dexValue);
        con = findViewById(R.id.conValue);
        intel = findViewById(R.id.intValue);
        wis = findViewById(R.id.wisValue);
        cha = findViewById(R.id.chaValue);
        prof = findViewById(R.id.profValue);
        Intent intent = new Intent(this, RollSheet.class);
        SharedPreferences.Editor preferenceEditor=mPreferences.edit();
        preferenceEditor.putInt("strength", Integer.parseInt(str.getText().toString()));
        preferenceEditor.putInt("dexterity", Integer.parseInt(dex.getText().toString()));
        preferenceEditor.putInt("constitution", Integer.parseInt(con.getText().toString()));
        preferenceEditor.putInt("intelligence", Integer.parseInt(intel.getText().toString()));
        preferenceEditor.putInt("wisdom", Integer.parseInt(wis.getText().toString()));
        preferenceEditor.putInt("charisma", Integer.parseInt(cha.getText().toString()));
        preferenceEditor.putInt("proficiency", Integer.parseInt(prof.getText().toString()));
        preferenceEditor.apply();
        startActivity(intent);
    }

    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences.Editor preferenceEditor = mPreferences.edit();
        preferenceEditor.putInt("strength", Integer.parseInt(str.getText().toString()));
        preferenceEditor.putInt("dexterity", Integer.parseInt(dex.getText().toString()));
        preferenceEditor.putInt("constitution", Integer.parseInt(con.getText().toString()));
        preferenceEditor.putInt("intelligence", Integer.parseInt(intel.getText().toString()));
        preferenceEditor.putInt("wisdom", Integer.parseInt(wis.getText().toString()));
        preferenceEditor.putInt("charisma", Integer.parseInt(cha.getText().toString()));
        preferenceEditor.putInt("proficiency", Integer.parseInt(prof.getText().toString()));
        preferenceEditor.apply();
    }
}
