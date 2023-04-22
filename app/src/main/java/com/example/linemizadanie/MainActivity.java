package com.example.linemizadanie;

import androidx.appcompat.app.AppCompatActivity;
import com.pranavpandey.android.dynamic.toasts.DynamicToast;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class MainActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnClick = (Button) findViewById(R.id.loadGoodsBtn);

        btnClick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                new LoadNamesTask().execute();
                Intent intent = new Intent(MainActivity.this, ProductsListScreen.class);
                startActivity(intent);
            }
        });

    }
}
