package com.kevin.walkyourpet.persistencia.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.kevin.walkyourpet.entities.Paseador;

@Dao
public interface PaseadorDAO {
    @Insert
    void create(Paseador paseador);
}
