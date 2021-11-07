package com.kevin.walkyourpet.persistencia.dao;



import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.kevin.walkyourpet.entities.Usuario;

@Dao
public interface UsuarioDAO {
    @Insert
    void create(Usuario usuario);

    /*
    @Query("SELECT * FROM usuario")
    LiveData<List<Usuario>> findAll();
*/
    @Query("SELECT * FROM usuario where usuario =:usuario")
    Usuario findByUsuario(String usuario);

    @Query("SELECT * FROM usuario where celular =:celular")
    Usuario findByCelular(String celular);

}
