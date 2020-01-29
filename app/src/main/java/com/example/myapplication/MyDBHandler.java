package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABSE_NAME="salary.db";
    public static final String TABLE_CALCULATOR="UsersOfCalculator";
    public static final String COLOUMN_ID="_id";
    public static final String COLOUMN_NAME="name";
    public static final String COLOUMN_TAXP="taxp";
    public static final String COLOUMN_EPFP="epfp";
    public static final String COLOUMN_TAX="tax";
    public static final String COLOUMN_EPF="epf";
    public static final String COLOUMN_NETSAL="net";

    public MyDBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABSE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_CALCULATOR + "(" +

                COLOUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                COLOUMN_NAME + " TEXT, " +

                COLOUMN_TAXP + " TEXT, " +

                COLOUMN_EPFP + " TEXT, " +

                COLOUMN_TAX + " TEXT, " +

                COLOUMN_EPF + " TEXT, " +

                COLOUMN_NETSAL + " TEXT " +

                ");";

        db.execSQL(query);

    }

   @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+TABLE_CALCULATOR);

        onCreate(db);

    }

    public void add(UsersOfCalculator u)
    {
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLOUMN_NAME, u.get_name());
        SQLiteDatabase db= getWritableDatabase();
        db.insert(TABLE_CALCULATOR,null,contentValues);
        db.close();

    }
}
