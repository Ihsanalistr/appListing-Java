package com.kaitoshan.listingapputs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    Bundle pack = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txtMsk1 = findViewById(R.id.txtInputan);
        Button btnKrm = findViewById(R.id.btnKirim);

        btnKrm.setOnClickListener(view -> {
            if (txtMsk1.length() == 0) {
                txtMsk1.setError("Kolom harus diisi!");
            }
            pack.putString("inputan", txtMsk1.getText().toString());
        });
    }

    // Awal Fungsi Menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String huruf = "Huruf";
        String kalimat = "Kalimat";

        switch (selectedMode) {
            case R.id.mnHu:
                Intent pindah1 = new Intent(this, MenuHuruf.class);
                Toast.makeText(this, "Anda memilih mode huruf", Toast.LENGTH_SHORT).show();
                pack.putString("choosen", huruf);
                pindah1.putExtras(pack);
                startActivity(pindah1);
                break;
            case R.id.mnKal:
                Intent pindah2 = new Intent(this, MenuKal.class);
                Toast.makeText(this, "Anda memilih mode kalimat", Toast.LENGTH_SHORT).show();
                pack.putString("choosen", kalimat);
                pindah2.putExtras(pack);
                startActivity(pindah2);
                break;
        }
    }

        // Akhir Fungsi Menu
}