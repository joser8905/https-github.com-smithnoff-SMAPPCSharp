package com.appudo.rsmapp.smappcsharp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Random;

/**
 * Created by RSMAPP on 30/08/2015.
 */
public class Manejador{
public static final String tabla="Cuestionario";
public static final String _ID="_id";
public static final String  pregunta="Pregunta";
public static final String respuesta1="Respuesta_1";
public static final String respuesta2="Respuesta_2";
public static final String respuesta3="Respuesta_3";
public static final String nivel="Nivel";
public static final String correcta="Correcta";
private DBHelper helper;
private SQLiteDatabase db;
public static final String crear_tabla="create table "+tabla+" ("+_ID+" integer primary key autoincrement,"+pregunta+" text not null,"+respuesta1+
        " text,"+respuesta2+" text,"+respuesta3+" text,"+nivel+" integer,"+correcta+" text);";

Cursor c;
        public Manejador(Context context)
        {
            helper = new DBHelper(context);
            db = helper.getWritableDatabase();


        }
        private ContentValues generarContentValues(String p, String r1,String r2,String r3,int n, String c ) {
            ContentValues valores = new ContentValues();
            valores.put(pregunta,p);
            valores.put(respuesta1,r1);
            valores.put(respuesta2,r2);
            valores.put(respuesta3,r3);
            valores.put(nivel,n);
            valores.put(correcta,c);


            return valores;
        }
        public void insertar(String p, String r1,String r2,String r3,int n, String c) {
            //bd.insert(TABLA, NullColumnHack, ContentValues);
            db.insert(tabla, null, generarContentValues(p, r1, r2, r3, n, c));

        }
public String px="",ra="",rb="",rc="";
        public void leer()
        {    String[] valores_recuperar = {_ID,pregunta , respuesta1, respuesta2,respuesta3,nivel,correcta};
            c = db.query(tabla, valores_recuperar, _ID,
                    null, null, null, null, null);
            Random r=new Random();
            int sig=r.nextInt(2);
            if(c != null) {
                c.moveToPosition(sig);
                px=c.getString(1);
                ra=c.getString(2);
                rb=c.getString(3);
                rc=c.getString(4);


            }
        }
    public void borrar()
    {db.delete(tabla,null,null);

    }

}
