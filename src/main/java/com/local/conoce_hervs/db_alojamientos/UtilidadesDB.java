package com.local.conoce_hervs.db_alojamientos;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 19/03/2018.
 */

public class UtilidadesDB {

    //Atributos
    private SQLiteDatabase db=null;
    private DBAlojamientos dbhelper=null;
    //Contexto
    Context context;


    public UtilidadesDB(Context contexto){
        this.context=contexto;

        //crea una instancia del helper
        dbhelper=new DBAlojamientos(context);

        //crea un objeto SQLiteDatabase para operar
        //contra la base de datos
        db=dbhelper.getWritableDatabase();
    }
    public void close(){
        dbhelper.close();
    }

    public Cursor listarAlojamiento() {
        return db.query("Alojamientos", new String[]{"Id", "Nombre", "Descripcion", "Localizacion"}, null, null, null, null, null);
    }

}
