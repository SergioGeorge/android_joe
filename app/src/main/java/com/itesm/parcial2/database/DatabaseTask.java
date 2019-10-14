package com.itesm.parcial2.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import com.itesm.parcial2.MainActivity;

import java.util.List;

public class DatabaseTask extends AsyncTask<Product, Void, List<Product>> {
    private Context context;
    private CatalogueDatabase db;
    private DatabaseReceiver receiver;

    public  DatabaseTask(Context context, DatabaseReceiver receiver) {
        this.receiver = receiver;
        this.context = context;
        this.db = Room.databaseBuilder(this.context, CatalogueDatabase.class, "Catalogue Database").build();
    }

    @Override
    protected List<Product> doInBackground(Product... params) {
        if(params[0].name.equals(""))
            return db.productDAO().getAll();

        return db.productDAO().search(params[0].name);
    }

    @Override
    protected void onPostExecute(List<Product> result) {
        receiver.getAll(result);
    }

}
