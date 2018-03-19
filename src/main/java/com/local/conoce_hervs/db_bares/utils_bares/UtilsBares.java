package com.local.conoce_hervs.db_bares.utils_bares;

//ENCAPSULA EL ACCESO A LA BASE DE DATOS
//CONTIENE TODOS LOS METODOS QUE HACEN REFERENCA A LA BASE DE DATOS


/*import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.local.conoce_hervs.db_bares.Bar;
import com.local.conoce_hervs.db_bares.DatabaseBares;
import com.local.conoce_hervs.db_bares.constantes_bares.ConstantesBares;

public class UtilsBares {

    private SQLiteDatabase db = null;
    private DatabaseBares dbBares = null;
    Context context;

    //constructor

    public UtilsBares (Context context){

        this.context = context;
        this.dbBares = dbBares;
        dbBares = new DatabaseBares(context);
        db = dbBares.getWritableDatabase();

    }

    //metodo para cerrar la base de datos

    public void Close(){

        dbBares.close();
    }


    //metodo para insertar el bar

    public long insertarBar(Bar bar){

        ContentValues initialValues = new ContentValues();

        initialValues.put("nombre", bar.getNombre());
        initialValues.put("descripcion", bar.getDescripcion());
        initialValues.put("localizacion", bar.getLocalizacion());
        initialValues.put("link", bar.getLink());
        initialValues.put("foto", bar.getFoto());

        return db.insert(ConstantesBares.BARES_TABLA,null,initialValues);

    }

    //metodo para recuperar Bares de tipo Cursor

    public Cursor recuperarBares(){
        return db.query (ConstantesBares.BARES_TABLA,
                new String[]{ ConstantesBares.CAMPO_BAR_ID,
                ConstantesBares.CAMPO_BAR_NOMBRE,
                ConstantesBares.CAMPO_BAR_DESCRIPCION,
                ConstantesBares.CAMPO_BAR_LOCALIZACION,
                ConstantesBares.CAMPO_BAR_LINK,
                ConstantesBares.CAMPO_BAR_FOTO },null,null,null,null,null);


    }







}*/
