package com.itesm.parcial2.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="product_id")
    @NonNull
    public int productId;
    @ColumnInfo(name="name")
    public String name;

    @ColumnInfo(name="description")
    public String description;

    @ColumnInfo(name="price")
    public float price;
}
