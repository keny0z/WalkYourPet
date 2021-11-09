package com.kevin.walkyourpet.persistencia.dao;



import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.kevin.walkyourpet.entities.Mascota;
import com.kevin.walkyourpet.entities.Usuario;

import java.util.List;

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

    /*
    @Query("UPDATE usuario SET mascotas =:nuevas_mascotas WHERE id =:usuario_id")
    void actualizarMascotas(List<Mascota> nuevas_mascotas, Integer usuario_id);
    */
    @Update
    void update(Usuario usuario);
}
