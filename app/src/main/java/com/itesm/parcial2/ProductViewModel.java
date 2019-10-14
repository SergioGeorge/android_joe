package com.itesm.parcial2;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.itesm.parcial2.database.CatalogueDatabase;
import com.itesm.parcial2.database.Product;

import java.util.List;

public class ProductViewModel extends ViewModel {
    private MutableLiveData<List<Product>> products;

    private CatalogueDatabase db;

    public ProductViewModel() {
        super();
    }

    public MutableLiveData<List<Product>> getProducts(Context context) {
        if(products == null) {
            products = new MutableLiveData<>();
            CatalogueDatabase db = Room.databaseBuilder(context, CatalogueDatabase.class, "Catalogue DB").build();

            List<Product> myProducts = db.productDAO().getAll();

            products.setValue(myProducts);
        }

        return products;
    }
}
