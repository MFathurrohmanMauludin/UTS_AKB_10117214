/*
 * M Fathurrohman Mauludin - 10117214
 */

package com.fathurrohman.akb10117214.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// Minggu 10 Mei 2020, 10117214, M Fathurrohman Mauludin, IF7

public class DataHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "daftarteman.db";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE teman(nim text primary key not null, nama text not null, kelas text not null, telepon text null, email text null, sosmed text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg, int arg1, int arg2) {

    }


}
