package com.example.gajikaryawan;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivityDeswithanur extends AppCompatActivity {

    ImageButton btnGaji, btnPetunjuk, btnTentang, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frizka);

        btnGaji = findViewById(R.id.btnGaji);
        btnPetunjuk = findViewById(R.id.btnPetunjuk);
        btnTentang = findViewById(R.id.btnTentang);
        btnExit = findViewById(R.id.btnExit);

        btnGaji.setOnClickListener(v ->
                startActivity(new Intent(this, GajiActivityFrizka.class)));

        btnPetunjuk.setOnClickListener(v ->
                startActivity(new Intent(this,PetunjukActivityFrizka.class)));

        btnTentang.setOnClickListener(v ->
                startActivity(new Intent(this, TentangActivityFrizka.class)));

        btnExit.setOnClickListener(v -> finishAffinity());
    }
}