package com.itesm.parcial2.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDAO {
    @Insert
    public long[] insertProduct(Product... products);

    @Update
    public void updateProduct(Product... products);

    @Delete
    public void deleteProduct(Product... products);

    @Query("SELECT * FROM product")//'product' es el nombre de la clase en el paquete database
    public List<Product> getAll();

    @Query("SELECT * FROM product WHERE name LIKE :searchName")//'product' es el nombre de la clase en el paquete database
    public List<Product> search(String searchName);
}
