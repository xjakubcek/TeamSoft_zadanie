package com.example.linemizadanie;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailScreen extends AppCompatActivity {

    public static String name;
    ImageView image;
    TextView productName;
    TextView productCode;
    TextView category;
    TextView baseUnit;
    TextView weightBrutto;
    TextView weightNetto;
    TextView weightUnit;
    TextView level;
    TextView description;
    TextView urlWwww;
    TextView buyPrice;
    TextView sellPrice;

    public static int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail_screen);
        productName = findViewById(R.id.name);
        productCode = findViewById(R.id.productCode);
        category = findViewById(R.id.category);
        baseUnit = findViewById(R.id.baseUnit);
        weightBrutto = findViewById(R.id.weightBrutto);
        weightNetto = findViewById(R.id.weightNetto);
        weightUnit = findViewById(R.id.weightUnit);
        level = findViewById(R.id.productLevel);
        description = findViewById(R.id.description);
        urlWwww = findViewById(R.id.urlWww);
        buyPrice = findViewById(R.id.buy);
        sellPrice = findViewById(R.id.sell);
        image = findViewById(R.id.urlImg);

        productName.setText(LoadNamesTask.productName[index]);
        productCode.setText(LoadNamesTask.productCode[index]);
        category.setText(LoadNamesTask.productCategory[index]);
        baseUnit.setText(LoadNamesTask.productBaseUnit[index]);
        weightBrutto.setText(LoadNamesTask.productWeightbrutto[index]);
        weightNetto.setText(LoadNamesTask.productWeightNetto[index]);
        weightUnit.setText(LoadNamesTask.productWeightUnit[index]);
        level.setText(LoadNamesTask.productLotLevel[index]);
        description.setText(LoadNamesTask.productDescription[index]);
        urlWwww.setText(LoadNamesTask.productUrlWww[index]);
        buyPrice.setText(LoadNamesTask.productPricesBuyBase[index] + "" + LoadNamesTask.productPricesBuyCurrency[index] + "\n" +"TAX :" + LoadNamesTask.productPricesBuyTax[index]);
        sellPrice.setText(LoadNamesTask.productPricesBuyBase[index] + "" + LoadNamesTask.productPricesSellCurrency[index] + "\n" +"TAX :" +  LoadNamesTask.productPricesSellTax [index]);

        //image.setImageURI(LoadNamesTask.productUrlImg[index]);

    }
}
