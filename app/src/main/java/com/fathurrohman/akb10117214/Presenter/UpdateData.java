/*
 * M Fathurrohman Mauludin - 10117214
 */

package com.fathurrohman.akb10117214.Presenter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fathurrohman.akb10117214.Model.DataHelper;
import com.fathurrohman.akb10117214.R;
import com.fathurrohman.akb10117214.View.ActivityDaftar;

// Minggu 10 Mei 2020, 10117214, M Fathurrohman Mauludin, IF7

public class UpdateData extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbcenter;
    Button btn1, btn2;
    EditText nim, nama, kelas, telepon, email, sosmed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        dbcenter = new DataHelper(this);

        nim = findViewById(R.id.updateText1);
        nama = findViewById(R.id.updateText2);
        kelas = findViewById(R.id.updateText3);
        telepon = findViewById(R.id.updateText4);
        email = findViewById(R.id.updateText5);
        sosmed = findViewById(R.id.updateText6);

        nim.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM teman WHERE nama='"+getIntent().getStringExtra("nama") +"';", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0){
            cursor.moveToPosition(0);
            nim.setText(cursor.getString(0));
            nama.setText(cursor.getString(1));
            kelas.setText(cursor.getString(2));
            telepon.setText(cursor.getString(3));
            email.setText(cursor.getString(4));
            sosmed.setText(cursor.getString(5));
        }

        btn1 = findViewById(R.id.btn_update1);
        btn2 = findViewById(R.id.btn_update2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbcenter.getWritableDatabase();
                db.execSQL("UPDATE teman SET nama='"+ nama.getText().toString() +
                        "', kelas='"+ kelas.getText().toString() +
                        "', telepon='"+ telepon.getText().toString() +
                        "', email='"+ email.getText().toString() +
                        "', sosmed='"+ sosmed.getText().toString() +
                        "' WHERE nim='" + nim.getText().toString()+"';");
                Toast.makeText(getApplicationContext(), "Update", Toast.LENGTH_SHORT).show();
                ActivityDaftar.fd.RefreshList();
                finish();

                // pangggil method di fragmentDaftar
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
