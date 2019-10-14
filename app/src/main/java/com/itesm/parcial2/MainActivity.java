package com.itesm.parcial2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.itesm.parcial2.database.CatalogueDatabase;
import com.itesm.parcial2.database.DatabaseReceiver;
import com.itesm.parcial2.database.DatabaseTask;
import com.itesm.parcial2.database.Product;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DatabaseReceiver {
    public static String MESSAGE = "com.itesm.parcial2.MainActivity";
    ProductViewModel products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        products = ViewModelProviders.of(this).get(ProductViewModel.class);

        products.getProducts(getApplicationContext()).observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {

            }
        });
    }

    public void getAll(List<Product> products) {
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup table = findViewById(R.id.catalogueList);
        table.removeAllViews();
        for(Product item : products){
            Log.d("Hello", "Products Name Here: " + item.name);
            View row = inflater.inflate(R.layout.row_layout, table, false);
            TextView vw = row.findViewById(R.id.productName);
            vw.setText(item.name);
            table.addView(row);
        }
    }

    public void doAction(View view) {
        DatabaseTask task = new DatabaseTask(this, this);
        Product p = new Product();

        p.name = "%" + ((EditText)findViewById(R.id.searchText)).getText()+"%";
        task.execute(p);
        /*Product t = new Product();
        t.name = "Producto 1";
        t.price = 10.0f;
        //db.productDAO().insertProduct(t);
        Product t2 = new Product();
        t2.name = "Producto 2";
        t2.price = 22.0f;
        //db.productDAO().insertProduct(t);
        Product t3 = new Product();
        t3.name = "Producto 3";
        t3.price = 33.0f;

        db.productDAO().insertProduct(t, t2, t3);*/

        //List<Product> products = db.productDAO().getAll();


        /*Log.d("Customizado", "Click en do action");
        TextView v = findViewById(R.id.editText);
        TextView vt = findViewById(R.id.viewTitle);
        vt.setText(v.getText());

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("var_1", "" + v.getText());
        startActivity(intent);*/

    }

    public void Presioname(View v) {
        Log.d("boton", "Me presionaste");
    }


}
