package com.kaitoshan.listingapputs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MenuHuruf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_huruf);
        EditText txtInp1 = findViewById(R.id.txtInp1);
        EditText txtInp2 = findViewById(R.id.txtInp2);
        EditText txtOut = findViewById(R.id.txtInputan2);
        Button btnKrm = findViewById(R.id.btnKirim2);

        String msk = getIntent().getStringExtra("inputan");

        btnKrm.setOnClickListener(view -> {
            if (txtInp1.length() == 0) {
                txtInp1.setError("Kolom harus diisi!");
            } if (txtInp2.length() == 0) {
                txtInp2.setError("Kolom harus diisi!");
            }
            String inp1 = txtInp1.getText().toString();
            String inp2 = txtInp2.getText().toString();

            txtOut.setText(msk.replace(inp1, inp2));
        });
    }
}