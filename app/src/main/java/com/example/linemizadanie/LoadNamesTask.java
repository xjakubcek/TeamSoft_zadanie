package com.example.linemizadanie;

import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoadNamesTask extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "LoadNamesTask";
    private static final String API_KEY_HEADER = "TS-Apikey";
    private static final String API_KEY_VALUE = "BA47B061219C5B4B2F3B973B783E2F421E3EE3D232E06DC8C4294A21721DF2BC";
    private static final String ENDPOINT_URL = "https://api.linemi.house/v1/products/";
    public  static  String[] productName = {};
    public  static  String[] productCode = {};
    public  static  int[] productIsAcive = {};
    public  static  int[] productCategory = {};
    public  static  String[] productBaseUnit = {};

    public  static  int[] productWeightbrutto = {};
    public  static  int[] productWeightNetto = {};
    public  static  String[] productWeightUnit = {};
    public  static  int[] productLotLevel= {};
    public  static  String[] productDescription = {};
    public  static  String[] productUrlWww = {};
    public  static  String[] productUrlImg = {};

    public  static  int[] productPricesBuyBase = {};
    public  static  String[]  productPricesBuyCurrency = {};
    public  static  int[] productPricesBuyTax = {};

    public  static  int[] productPricesSellBase = {};
    public  static  String[]  productPricesSellCurrency = {};
    public  static  int[] productPricesSellTax = {};


    private Exception mException;

    public static int itemsCount = 0;
    public int numOfProducts = 0;

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL(ENDPOINT_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty(API_KEY_HEADER, API_KEY_VALUE);
            connection.connect();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException("Unexpected HTTP response code: " + connection.getResponseCode());
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();

            JSONObject obj = new JSONObject(stringBuilder.toString());
            JSONObject commonBasic = obj.getJSONObject("common");
            itemsCount = Integer.parseInt(commonBasic.getString("items_count"));
            System.out.println("Pocet nacitanych produktov : " + itemsCount); //.getJSONObject("common").getInt("items_count")

            JSONArray arr = obj.getJSONArray("list");
            numOfProducts = arr.length();
            //System.out.println("arr length " + numOfProdutcs);

            for (int i = 0; i < /*arr.length()*/5; i++) {
                JSONObject jsonObject = arr.getJSONObject(i);
                productName[i] = arr.getJSONObject(i).getString("name");
                productCode[i]  = arr.getJSONObject(i).getString("product_code");
                productIsAcive[i] = arr.getJSONObject(i).getInt("active");
                productCategory[i] = arr.getJSONObject(i).getInt("category");
                productBaseUnit [i] = arr.getJSONObject(i).getString("base_unit");
                productWeightbrutto[i] = arr.getJSONObject(i).getInt("weight_brutto");
                productWeightNetto[i] = arr.getJSONObject(i).getInt("weight_netto");
                productWeightUnit[i] = arr.getJSONObject(i).getString("weight_unit");
                productLotLevel[i] = arr.getJSONObject(i).getInt("lot_level");
                productDescription[i] = arr.getJSONObject(i).getString("description");
                productUrlWww[i] = arr.getJSONObject(i).getString("url_www");
                productUrlImg[i] = arr.getJSONObject(i).getString("url_img");
                productPricesBuyBase[i] = arr.getJSONObject(i).getJSONObject("buy").getInt("base");
                productPricesBuyCurrency[i] = arr.getJSONObject(i).getJSONObject("buy").getString("currency");
                productPricesBuyTax[i] = arr.getJSONObject(i).getJSONObject("buy").getInt("tax_rate");
                productPricesSellBase[i] = arr.getJSONObject(i).getJSONObject("sell").getInt("base");
                productPricesSellCurrency[i] = arr.getJSONObject(i).getJSONObject("sell").getString("currency");
                productPricesSellTax [i] = arr.getJSONObject(i).getJSONObject("sell").getInt("tax_rate");

                /*System.out.println("Names " + productName[i]);
                System.out.println("productCode " + productCode[i]);
                System.out.println("productIsAcive " + productIsAcive[i]);
                System.out.println("productCategory " + productCategory[i]);
                System.out.println("productBaseUnit " + productBaseUnit[i]);
                System.out.println("productWeightbrutto " + productWeightbrutto [i]);
                System.out.println("productWeightNetto " + productWeightNetto [i]);
                System.out.println("productWeightUnit " + productweightUnit [i]);
                System.out.println("productLotLevel " + productLotLevel [i]);
                System.out.println("productDescription " + productDescription [i]);
                System.out.println("productUrlWww " + productUrlWww [i]);
                System.out.println("productUrlImg " + productUrlImg [i]);

                System.out.println("productPricesBuyBase " + productPricesBuyBase [i]);
                System.out.println("productPricesBuyCurrency " + productPricesBuyCurrency [i]);
                System.out.println("productPricesBuyTax " + productPricesBuyTax [i]);

                System.out.println("productPricesSellBase " + productPricesSellBase [i]);
                System.out.println("productPricesSellCurrency " + productPricesSellCurrency [i]);
                System.out.println("productPricesSellTax " + productPricesSellTax [i]);*/
            }
        } catch (IOException | JSONException e) {
            mException = e;
            Log.e(TAG, "Error while loading names", e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (mException != null) {
            // handle exception
        } else {
            // do something with mNames array
        }
    }

    public static String[] getItemNames() {
        return productName;
    }
}
