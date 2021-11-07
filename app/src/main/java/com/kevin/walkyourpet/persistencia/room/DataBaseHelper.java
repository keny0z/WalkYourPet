package com.kevin.walkyourpet.persistencia.room;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.kevin.walkyourpet.entities.ConvertersMascota;
import com.kevin.walkyourpet.entities.Usuario;
import com.kevin.walkyourpet.persistencia.dao.UsuarioDAO;


@Database(entities = {
        Usuario.class}
         , version = DataBaseHelper.VERSION_BASE_DATOS, exportSchema = false)
@TypeConverters({ConvertersMascota.class})
public abstract  class DataBaseHelper extends RoomDatabase {

    public static final int VERSION_BASE_DATOS = 1;
    public static final String NOMBRE_BASE_DATOS = "WalkYourPetDB";
    private static DataBaseHelper intance;

    /**
     * Se usa para las transacciones INSERT, UPDATE y DELETE
     * @param context
     * @return
     */
    public static DataBaseHelper getSimpleDB(Context context){
        if(intance == null){
            intance = Room.databaseBuilder(context, DataBaseHelper.class,NOMBRE_BASE_DATOS).build();
        }
        return intance;
    }

    /**
     * SELECT
     * @param context
     * @return
     */
    public static DataBaseHelper getDBMainThread(Context context){
        if(intance == null){
            intance = Room.databaseBuilder(context, DataBaseHelper.class,NOMBRE_BASE_DATOS).allowMainThreadQueries().build();
        }
        return intance;
    }


    public abstract UsuarioDAO getUsuarioDAO();




}
