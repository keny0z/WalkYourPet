package com.kevin.walkyourpet.persistencia.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.kevin.walkyourpet.entities.Paseador;

import java.util.List;

@Dao
public interface PaseadorDAO {
    @Insert
    void create(Paseador paseador);

    @Query("SELECT * FROM paseador")
    LiveData<List<Paseador>> findAll();
}
