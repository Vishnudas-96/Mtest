package com.test.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "hotelmanager";
    private static final String TABLE_CONTACTS = "hotels";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_mobile = "mobile";
    private static final String KEY_website = "website";
    private static final String KEY_address_1 = "address_1";

    public DatabaseHandler(MainActivity mainActivity) {
        super(mainActivity,DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DatabaseHandler(MainActivity2 mainActivity2) {
        super(mainActivity2,DATABASE_NAME, null, DATABASE_VERSION);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_mobile + " TEXT," + KEY_website + " TEXT," +KEY_address_1 +" TEXT " + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }


    public void insertDetails(List<Latlong> latlongList) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cValues = new ContentValues();

        for(int i = 0; i < latlongList.size(); i++) {
            cValues.put(KEY_ID, latlongList.get(i).getId());
            cValues.put(KEY_NAME, latlongList.get(i).getName());
            cValues.put(KEY_address_1, latlongList.get(i).getAddress1());
            cValues.put(KEY_mobile, latlongList.get(i).getMobile());
            cValues.put(KEY_website, latlongList.get(i).getWebsite());
            db.insert(TABLE_CONTACTS,null, cValues);

        }
        db.close();

    }
    ArrayList<Latlong> listContacts() {
        String sql = "select * from " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CONTACTS, null);
        ArrayList<Latlong> storedContacts = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String phno = cursor.getString(2);
                String website = cursor.getString(3);
                String adrs = cursor.getString(4);
                storedContacts.add(new Latlong(id,name, phno, website, adrs));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return storedContacts;
    }


    public List<Latlong> readData(String id1) {

        String sql = "select * from " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.rawQuery( "select * from hotels where id="+id1+"", null );

        ArrayList<Latlong> latlongArrayList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                int id = Integer.parseInt(cursor.getString(0));
                String name = cursor.getString(1);
                String phno = cursor.getString(2);
                String website = cursor.getString(3);
                String adrs = cursor.getString(4);
                latlongArrayList.add(new Latlong(id,name, phno, website, adrs));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return latlongArrayList;
    }
}
