package com.example.rodoggx.codechallenge.data.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CacheDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCacheInfo(CacheData cacheData);

    @Query("SELECT * from cache")
    List<CacheData> getAllCache();
}
