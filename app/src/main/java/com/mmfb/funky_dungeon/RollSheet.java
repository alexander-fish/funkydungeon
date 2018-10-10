package com.mmfb.funky_dungeon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RollSheet extends AppCompatActivity {
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.mmfb.funky_dungeon.funkydungeonsharedprefs";
    TextView str;
    TextView dex;
    TextView con;
    TextView intel;
    TextView wis;
    TextView cha;
    TextView prof;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        setContentView(R.layout.activity_roll_sheet);
        str = findViewById(R.id.str2Value);
        dex = findViewById(R.id.dex2Value);
        con = findViewById(R.id.con2Value);
        intel = findViewById(R.id.int2Value);
        wis = findViewById(R.id.wis2Value);
        cha = findViewById(R.id.cha2Value);
        prof = findViewById(R.id.prof2Value);
        if (savedInstanceState != null) {
            str.setText(mPreferences.getInt("strength", 1));
            dex.setText(mPreferences.getInt("dexterity", 1));
            con.setText(mPreferences.getInt("constitution", 1));
            intel.setText(mPreferences.getInt("intelligence", 1));
            wis.setText(mPreferences.getInt("wisdom", 1));
            cha.setText(mPreferences.getInt("charisma", 1));
            prof.setText(mPreferences.getInt("proficiency", 1));
        }
    }

    public void launchEditor(View view) {
        Intent intent = new Intent(this, NewUser.class);
        startActivity(intent);
    }
}
