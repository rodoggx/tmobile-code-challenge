package com.example.rodoggx.codechallenge.data.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CacheData.class}, version = 1)
public abstract class CacheDatabase extends RoomDatabase {

    private static CacheDatabase instance = null;

    public abstract CacheDAO getCacheDao();

    public static CacheDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                    CacheDatabase.class,
                    "cache.db")
                    .build();
        }
        return instance;
    }
}
