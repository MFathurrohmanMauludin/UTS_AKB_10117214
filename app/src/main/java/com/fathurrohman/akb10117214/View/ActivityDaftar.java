
/*
 * M Fathurrohman Mauludin - 10117214
 */

package com.fathurrohman.akb10117214.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.fathurrohman.akb10117214.Model.DataHelper;
import com.fathurrohman.akb10117214.Presenter.CreateData;
import com.fathurrohman.akb10117214.Presenter.ReadData;
import com.fathurrohman.akb10117214.Presenter.UpdateData;
import com.fathurrohman.akb10117214.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

// Senin 11 Mei 2020, 10117214, M Fathurrohman Mauludin, IF7

public class ActivityDaftar extends AppCompatActivity {

    String[] daftar;
    DataHelper dbcenter;
    protected Cursor cursor;
    ListView listView01;
    public static ActivityDaftar fd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDaftar.this, CreateData.class);
                startActivity(intent);
            }
        });


        fd = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }


    public void RefreshList() {
        dbcenter = new DataHelper(this);
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM teman ORDER BY nama", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1);
        }

        listView01 = findViewById(R.id.listTeman);
        listView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        listView01.setSelected(true);
        listView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = {"Lihat Teman", "Update Teman", "Hapus Teman"};
                AlertDialog.Builder builder = new AlertDialog.Builder(ActivityDaftar.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item) {
                            case 0:
                                Intent i = new Intent(getApplicationContext(), ReadData.class);
                                i.putExtra("nama", selection);
                                startActivity(i);
                                break;
                            case 1:
                                Intent intent = new Intent(getApplicationContext(), UpdateData.class);
                                intent.putExtra("nama", selection);
                                startActivity(intent);
                                break;
                            case 2:
                                SQLiteDatabase db = dbcenter.getWritableDatabase();
                                db.execSQL("DELETE FROM teman WHERE nama='" + selection + "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter) listView01.getAdapter()).notifyDataSetInvalidated();

        //Menampilkan Toolbar
    }

}
