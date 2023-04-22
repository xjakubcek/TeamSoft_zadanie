package com.example.linemizadanie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

public class ProductsListScreen extends AppCompatActivity {

    ListView simpleListView;
    public String[] productNames = {"asdad"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_screen);

        //productNames = new String[LoadNamesTask.itemsCount];
        /*for (int i = 0; i < LoadNamesTask.itemsCount; i++) {
            productNames[i] =  LoadNamesTask.productName[i];
            System.out.println("Names " +  LoadNamesTask.productName[i]);
        }*/
        //LoadNamesTask loadProductNames = new LoadNamesTask();
        final ListView simpleListView = (ListView) findViewById(R.id.simpleListView);

        arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.list_view_activity, R.id.textView, productNames);
        simpleListView.setAdapter(arrayAdapter);

        simpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProductDetailScreen.index = (int) id;
                Intent intent = new Intent(ProductsListScreen.this, ProductDetailScreen.class);
                startActivity(intent);
            }
        });
    }
}