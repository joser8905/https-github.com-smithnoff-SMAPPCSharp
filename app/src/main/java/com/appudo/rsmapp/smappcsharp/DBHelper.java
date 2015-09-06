package com.appudo.rsmapp.smappcsharp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by RSMAPP on 30/08/2015.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final int version=1;
    private static final String db_name="examen";




    public DBHelper(Context context) {
        super(context, db_name  , null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Manejador.crear_tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
