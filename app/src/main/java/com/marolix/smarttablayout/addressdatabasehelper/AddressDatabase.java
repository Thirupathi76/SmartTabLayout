package com.marolix.smarttablayout.addressdatabasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by techniche-v1 on 14/10/16.
 */

public class AddressDatabase extends SQLiteOpenHelper {
    /*private long id;
    private String streetAddress;
    private String city;
    private String doorName;
    private String ApartmentName;
    private String pincode*/

    private static final String DATABASENAME = "delivery.db";
    private static final int DATABASE_VERSION = 1;

    private static final String ADDRESS_TABLE_NAME = "delivery_address_tab";
    private static final String KEY_FIELD_ID = "id";
    private static final String KEY_FIELD_STREET = "streetAddress";
    private static final String KEY_FIELD_CITY = "city";
    private static final String KEY_FIELD_DOOR = "doorName";
    private static final String KEY_FIELD_APARTMENT = "apartmentName";
    private static final String KEY_FIELD_PINCODE = "pincode";

    private Context context;

    public AddressDatabase(Context context) {
        super(context, DATABASENAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ADDRESS_TAB = "CREATE TABLE " + ADDRESS_TABLE_NAME + "("
                + KEY_FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_FIELD_DOOR + " TEXT , "
                + KEY_FIELD_APARTMENT + " TEXT, "
                + KEY_FIELD_STREET + " TEXT NOT NULL, "
                + KEY_FIELD_CITY + " TEXT NOT NULL, "
                + KEY_FIELD_PINCODE + " TEXT NOT NULL"
                +")";
        db.execSQL(CREATE_ADDRESS_TAB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_ADDRESS_TABLE = " DROP TABLE IF EXISTS " + ADDRESS_TABLE_NAME ;
        db.execSQL(DROP_ADDRESS_TABLE);
        onCreate(db);
    }

    public long insertAddress(DeliveryAddressModel addressModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_FIELD_DOOR,addressModel.getDoorName());
        values.put(KEY_FIELD_APARTMENT,addressModel.getApartmentName());
        values.put(KEY_FIELD_STREET,addressModel.getStreetAddress());
        values.put(KEY_FIELD_CITY,addressModel.getCity());
        values.put(KEY_FIELD_PINCODE,addressModel.getPincode());
        long id = db.insert(ADDRESS_TABLE_NAME, null, values);
        db.close();
        return id;
    }

    public void signOut() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + ADDRESS_TABLE_NAME);
        db.close();
    }

    public List<DeliveryAddressModel> getAllAddress(){
        SQLiteDatabase db = this.getWritableDatabase();
        List<DeliveryAddressModel> listOfAddresses = new ArrayList<DeliveryAddressModel>();
        String selectQuery = "SELECT * FROM " + ADDRESS_TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()){
            do{
                DeliveryAddressModel delAddress = new DeliveryAddressModel();
                delAddress.setId(cursor.getInt(0));
                delAddress.setDoorName(cursor.getString(1));
                delAddress.setApartmentName(cursor.getString(2));
                delAddress.setStreetAddress(cursor.getString(3));
                delAddress.setCity(cursor.getString(4));
                delAddress.setPincode(cursor.getString(5));
                listOfAddresses.add(delAddress);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listOfAddresses;
    }


    public List<DeliveryAddressModel> getAddress(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        List<DeliveryAddressModel> listOfAddresses = new ArrayList<DeliveryAddressModel>();
        String selectQuery = "SELECT * FROM " + ADDRESS_TABLE_NAME + " WHERE " + KEY_FIELD_ID + " = " + id;
        Cursor cursor = db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()){
            do{
                DeliveryAddressModel delAddress = new DeliveryAddressModel();
                delAddress.setId(cursor.getInt(0));
                delAddress.setDoorName(cursor.getString(1));
                delAddress.setApartmentName(cursor.getString(2));
                delAddress.setStreetAddress(cursor.getString(3));
                delAddress.setCity(cursor.getString(4));
                delAddress.setPincode(cursor.getString(5));
                listOfAddresses.add(delAddress);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listOfAddresses;
    }
}
