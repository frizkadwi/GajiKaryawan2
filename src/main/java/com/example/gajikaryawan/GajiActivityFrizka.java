package com.example.gajikaryawan;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class GajiActivityVeronica extends AppCompatActivity {

    private EditText etGajiPokok, etTunjanganJabatan, etJumlahHariKerja;
    private EditText etTunjanganMakan, etTunjanganTransportasi, etGajiKotor, etGajiBersih;
    private Button btnHitung, btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaji_frizka);

        etGajiPokok = findViewById(R.id.etGajiPokok);
        etTunjanganJabatan = findViewById(R.id.etTunjanganJabatan);
        etJumlahHariKerja = findViewById(R.id.etJumlahHariKerja);
        etTunjanganMakan = findViewById(R.id.etTunjanganMakan);
        etTunjanganTransportasi = findViewById(R.id.etTunjanganTransportasi);
        etGajiKotor = findViewById(R.id.etGajiKotor);
        etGajiBersih = findViewById(R.id.etGajiBersih);

        btnHitung = findViewById(R.id.btnHitung);
        btnKembali = findViewById(R.id.btnKembali);

        btnHitung.setOnClickListener(v -> hitungGaji());
        btnKembali.setOnClickListener(v -> finish());
    }

    private void hitungGaji() {
        String strGajiPokok = etGajiPokok.getText().toString().trim();
        String strTunjanganJabatan = etTunjanganJabatan.getText().toString().trim();
        String strHariKerja = etJumlahHariKerja.getText().toString().trim();

        if (strGajiPokok.isEmpty() || strTunjanganJabatan.isEmpty() || strHariKerja.isEmpty()) {
            Toast.makeText(this, "Harap isi semua inputan!", Toast.LENGTH_SHORT).show();
            return;
        }

        double gajiPokok = Double.parseDouble(strGajiPokok);
        double tunjanganJabatan = Double.parseDouble(strTunjanganJabatan);
        int hariKerja = Integer.parseInt(strHariKerja);

        // Rumus Perhitungan Soal Ujian[cite: 2]
        double tunjanganMakan = hariKerja * 10000;         // Tunjangan makan = hari kerja x Rp10.000[cite: 2]
        double tunjanganTransport = hariKerja * 5000;      // Tunjangan transportasi = hari kerja x Rp5.000[cite: 2]
        double gajiKotor = gajiPokok + tunjanganJabatan + tunjanganMakan + tunjanganTransport; //[cite: 2]
        double pajak = 0.10 * gajiKotor;                   // Pajak 10% dari gaji kotor[cite: 2]
        double gajiBersih = gajiKotor - pajak;             // Gaji bersih = gaji kotor dikurang pajak[cite: 2]

        // Menampilkan hasil ke layar
        etTunjanganMakan.setText(String.format("Rp %.0f", tunjanganMakan));
        etTunjanganTransportasi.setText(String.format("Rp %.0f", tunjanganTransport));
        etGajiKotor.setText(String.format("Rp %.0f", gajiKotor));
        etGajiBersih.setText(String.format("Rp %.0f", gajiBersih));
    }
}