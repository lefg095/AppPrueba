package com.example.appprueba.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.appprueba.Personal;
import java.util.List;

@Dao
public interface PersonalDao {
    @Query("SELECT * FROM personal")
    List<Personal> getAllPersonal();

    @Insert
    void inserAll(Personal... personals);

    @Query("SELECT * FROM personal WHERE nombre_personal = :nombre AND telefono_personal= :telefono")
    int loadUser(String nombre, long telefono);
}
