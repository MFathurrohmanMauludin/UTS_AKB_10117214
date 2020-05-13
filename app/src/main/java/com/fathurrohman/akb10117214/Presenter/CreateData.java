/*
 * M Fathurrohman Mauludin - 10117214
 */

package com.fathurrohman.akb10117214.Presenter;

import android.content.Context;
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

public class CreateData extends AppCompatActivity {
    DataHelper dbcenter;
    Button btn1, btn2;
    EditText nim, nama, kelas, telepon, email, sosmed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        dbcenter = new DataHelper(this);

        nim = findViewById(R.id.editText1);
        nama = findViewById(R.id.editText2);
        kelas = findViewById(R.id.editText3);
        telepon = findViewById(R.id.editText4);
        email = findViewById(R.id.editText5);
        sosmed = findViewById(R.id.editText6);

        btn1 = findViewById(R.id.btn_edit1);
        btn2 = findViewById(R.id.btn_edit2);

        nim.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbcenter.getWritableDatabase();
                db.execSQL("INSERT INTO teman (nim, nama, kelas, telepon, email, sosmed) values ('" +
                        nim.getText().toString() + "','" +
                        nama.getText().toString() + "','" +
                        kelas.getText().toString() + "','" +
                        telepon.getText().toString() + "','" +
                        email.getText().toString() + "','" +
                        sosmed.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
                ActivityDaftar.fd.RefreshList();
                finish();
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
