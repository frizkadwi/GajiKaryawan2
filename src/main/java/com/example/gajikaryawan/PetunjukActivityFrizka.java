package com.example.gajikaryawan;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class PetunjukActivityVeronica extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk_frizka);
        findViewById(R.id.btnKembali).setOnClickListener(v -> finish());
    }
}