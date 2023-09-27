package com.kaitoshan.listingapputs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MenuKal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_kal);

        TextView lblHslGF = findViewById(R.id.lblHslGF);
        EditText txtInp = findViewById(R.id.txtInp);
        TextView lblHsl = findViewById(R.id.lblHsl);
        Button btnKrm = findViewById(R.id.btnKirim3);

        String msk = getIntent().getStringExtra("inputan");
        String[] potongan = msk.split("\\s");

        List<String> kata = Arrays.asList(potongan);
        Collections.shuffle(kata);
        kata.toArray();

        for (int i = 0; i < potongan.length; i++) {
            lblHslGF.append("Kata-" + (i+1) + ": " + potongan[i] + "\n");
        }

        btnKrm.setOnClickListener(view -> {
            if (txtInp.length() == 0){
                txtInp.setError("Kolom harus diisi!");
            }
            String[] urut = txtInp.getText().toString().split(",");
            int[] temp = new int[urut.length];
            for (int j = 0; j < urut.length; j++) {
                temp[j] = Integer.parseInt(urut[j]);
            }
            for (int k = 0; k < urut.length; k++) {
                lblHsl.append(potongan[temp[k] - 1] + " ");
            }
        });
    }
}