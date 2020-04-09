package com.example.appprueba.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.appprueba.Personal;

@Database(entities = {Personal.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instancia;
    public static synchronized AppDatabase getInstance(Context context) {
        if (instancia == null){
            instancia = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "personaldb")
                    .allowMainThreadQueries()
                    .build();
        }
        return instancia;
    }

    public abstract PersonalDao personalDao();
}