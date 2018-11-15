package com.marolix.smarttablayout.apphelper;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.marolix.smarttablayout.addressdatabasehelper.DeliveryAddressModel;
import com.marolix.smarttablayout.model.Product;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by techniche-android on 24/11/16.
 */

public class StringJsonConverter {

    public static String listToString(Context context, List<Product> products) {

        List<Product> finalProduct = new ArrayList<>();
        /*if(products.size()>1){
            finalProduct.add(products.get(0));
            products.remove(0);
        }*/
        for(Product product : products){
            Log.e("product=",product.getId());
            boolean needToUpdate = false;
            int index = -1;
            for(Product finProduct : finalProduct){
                Log.e("finProduct=",finProduct.getId());
                int count = 1;
                if(finProduct.getId().equals(product.getId())){
                    needToUpdate = true;

                }
                index++;
            }
            if(needToUpdate){
                Log.e("needToUpdate=",""+index);
                finalProduct.set(index,product);
            }else{
                finalProduct.add(product);
            }
        }
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(finalProduct);
        return  jsonFavorites;
    }

    public static List<Product> stringToList(Context context, String fileContent) {
          /*  List<Product> favorites = new ArrayList();
            Gson gson = new Gson();
            Product[] favoriteItems = gson.fromJson(fileContent,Product[].class);
            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList(favorites);*/


        Type listType = new TypeToken<List<Product>>() {
        }.getType();
        List<Product> productBeen = (List<Product>) new Gson().fromJson(fileContent, listType);

        return productBeen;
    }

    public static String setDeliveryAddress(Context context, DeliveryAddressModel products) {
        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(products);
        Log.e("jsonFavorites",jsonFavorites);
        return  jsonFavorites;
    }

    public static DeliveryAddressModel getDeliveryAddress(Context context,String deliveryAddress){
        DeliveryAddressModel delAddress = new DeliveryAddressModel();
        Gson gson = new Gson();
        delAddress = gson.fromJson(deliveryAddress,DeliveryAddressModel.class);
        return delAddress;
    }
}