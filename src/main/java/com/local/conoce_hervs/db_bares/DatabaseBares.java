package com.local.conoce_hervs.db_bares;


import android.app.Fragment;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.local.conoce_hervs.MainActivity;
import com.local.conoce_hervs.fragments.Restauracion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

public class DatabaseBares extends SQLiteOpenHelper {

    /*
    * Hemos guardado la base de datos restaurantes en la carpeta assests dentro de main,
    * con los datos de los restaurantes.
    */

    private static String DB_BARES_PATH = "/data/data/com.local.conoce_hervs/databases/";
    //aquí es donde va a guardarse la base de datos en nuestra app

    private static String DB_BARES_NAME = "db_bares";

    private static SQLiteDatabase basedatosBares;

    private static DatabaseBares dbBarInstancia = null;
    //instancia de databasebares, a la que mas tarde llamaremos en la activity

    private static final int DATA_BARES_VERSION = 1;


//TODO: CONSTRUCTOR CON PARAMETRO CONTEXTO(ENCONTRAR FORMA DE QUE NO TENGA PARAMETRO. PERO EN SUPER ENTRE EL CONTEXTO SIN DAR ERROR)

    public DatabaseBares(Context context){

        super(context, DB_BARES_NAME, null, DATA_BARES_VERSION);

        try{

            createDBbares(context);
            openDBbares();

        } catch (IOException e){

            e.printStackTrace();
        }

    }


    public static DatabaseBares instance(Context context){

        if (dbBarInstancia == null) {

            dbBarInstancia = new DatabaseBares(context);
        }

        return dbBarInstancia;
    }


    private void createDBbares(Context context) throws IOException{

        Boolean dbExist = checkDatabaseBares();
        SQLiteDatabase db_Read = null;

        if (dbExist){
            //la base de datos ya existe
        } else {
            db_Read = this.getReadableDatabase();
            db_Read.close();

            try {
                copyDBbares(context);


            } catch (IOException e){

                throw new Error("Error copiando base de datos");
            }
        }


    }


    public boolean checkDatabaseBares(){

        File dbBaresFile = new File(DB_BARES_PATH + DB_BARES_NAME);

        return dbBaresFile.exists();
    }

    public void copyDBbares(Context context) throws IOException {

        //abrimos la base de datos que esta en la carpeta assests
        InputStream myInputBares = context.getAssets().open(DB_BARES_NAME);

        String outFileDBbaresName = DB_BARES_PATH+DB_BARES_NAME;

        OutputStream myDBbaresOutput = new FileOutputStream(outFileDBbaresName);

        byte[] bufferBares = new byte[1024];
        int lengthBares = myInputBares.read(bufferBares);

        while (lengthBares>0){

            myDBbaresOutput.write(bufferBares,0,lengthBares);

        }

        myDBbaresOutput.flush();
        myDBbaresOutput.close();
        myInputBares.close();
    }

    public void openDBbares() throws android.database.SQLException {

        // abrimos la database
        String myPathBares = DB_BARES_PATH  + DB_BARES_NAME;
        basedatosBares = SQLiteDatabase.openDatabase(myPathBares, null, SQLiteDatabase.OPEN_READWRITE);

    }

    public static Cursor select(String query) throws SQLiteException {

        return basedatosBares.rawQuery(query, null);
    }

    @Override
    public synchronized void close() {

        if (basedatosBares != null)
            basedatosBares.close();

        super.close();
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}