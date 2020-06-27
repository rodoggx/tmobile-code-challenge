package com.example.rodoggx.codechallenge.data.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "cache")
public class CacheData {

    @PrimaryKey(autoGenerate = true)
    int primaryKey;

    public String getjSonString() {
        return jSonString;
    }

    public String getDate() {
        return date;
    }

    @ColumnInfo(name = "jsonString")
    String jSonString;

    @ColumnInfo(name = "date")
    String date;

    public CacheData(String jSonString, String date) {
        this.jSonString = jSonString;
        this.date = date;
    }
}
