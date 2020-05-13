/*
 * M Fathurrohman Mauludin - 10117214
 */

package com.fathurrohman.akb10117214.Presenter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fathurrohman.akb10117214.Model.DataHelper;
import com.fathurrohman.akb10117214.R;

// Minggu 10 Mei 2020, 10117214, M Fathurrohman Mauludin, IF7

public class ReadData extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbcenter;
    Button btn1;
    TextView nim, nama, kelas, telepon, email, sosmed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        dbcenter = new DataHelper(this);
        nim = findViewById(R.id.textView1);
        nama = findViewById(R.id.textView2);
        kelas = findViewById(R.id.textView3);
        telepon = findViewById(R.id.textView4);
        email = findViewById(R.id.textView5);
        sosmed = findViewById(R.id.textView6);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM teman WHERE nama='" + getIntent().getStringExtra("nama") + "';", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0){
            cursor.moveToPosition(0);
            nim.setText("NIM: " + cursor.getString(0));
            nama.setText("Nama: " + cursor.getString(1));
            kelas.setText("Kelas: " + cursor.getString(2));
            telepon.setText("Telepon: " +cursor.getString(3));
            email.setText("Email: " + cursor.getString(4));
            sosmed.setText("Sosial Media: \n" + cursor.getString(5));
        }

        btn1 = findViewById(R.id.btn_lihat);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
