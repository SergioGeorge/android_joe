package com.itesm.parcial2.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class}, version = 1)
public abstract class CatalogueDatabase extends RoomDatabase {
    //Un Dao paor cada tabla que tengas
    public abstract ProductDAO productDAO();

}
