package com.example.week2homework2zoo.model.datasource.local.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.week2homework2zoo.Animal;

import java.util.ArrayList;

public class AnimalDatabaseHelper extends SQLiteOpenHelper {


    public AnimalDatabaseHelper(Context context) {
        super(context, AnimalDatabaseContract.DATABASE_NAME, null, AnimalDatabaseContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(AnimalDatabaseContract.QUERY_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {
        sqLiteDatabase.execSQL(AnimalDatabaseContract.DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    //Select All Method
    public ArrayList<Animal> getAllAnimals(){
        ArrayList<Animal> returnAnimalList = new ArrayList<>();
        SQLiteDatabase readableDatabase = this.getReadableDatabase();

        Cursor cursor = readableDatabase.rawQuery(AnimalDatabaseContract.QUERY_SELECT_ALL, null);

        if(cursor.moveToFirst()) {
            do {
                Animal currentAnimal = new Animal();
                currentAnimal.setName(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_NAME)));
                currentAnimal.setCategory(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_CATEGORY)));
                currentAnimal.setDiettype(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_DIETTYPE)));
                currentAnimal.setAvatar(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_AVATAR)));
                currentAnimal.setDescription(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_DESCRIPTION)));
                currentAnimal.setWiki(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_WIKI)));
                currentAnimal.setId(String.valueOf(cursor.getInt(cursor.getColumnIndex(AnimalDatabaseContract.COL_ID))));
                currentAnimal.setCry(cursor.getInt(cursor.getColumnIndex(AnimalDatabaseContract.COL_CRY)));
                currentAnimal.setProfilepic(cursor.getInt(cursor.getColumnIndex(AnimalDatabaseContract.COL_PROFILEPIC)));

            } while (cursor.moveToNext());
        }
        return returnAnimalList;
    }

    //Get Animal by it's id
    public Animal getAnimalbyId(String id){
        Animal currentAnimal = new Animal();
        SQLiteDatabase readableDatabase = this.getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery(AnimalDatabaseContract.QUERY_SELECT_BY_ID(id), null);

        if(cursor.moveToFirst()){
            currentAnimal.setName(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_NAME)));
            currentAnimal.setCategory(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_CATEGORY)));
            currentAnimal.setDiettype(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_DIETTYPE)));
            currentAnimal.setAvatar(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_AVATAR)));
            currentAnimal.setDescription(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_DESCRIPTION)));
            currentAnimal.setWiki(cursor.getString(cursor.getColumnIndex(AnimalDatabaseContract.COL_WIKI)));
            currentAnimal.setId(String.valueOf(cursor.getInt(cursor.getColumnIndex(AnimalDatabaseContract.COL_ID))));
            currentAnimal.setCry(cursor.getInt(cursor.getColumnIndex(AnimalDatabaseContract.COL_CRY)));
            currentAnimal.setProfilepic(cursor.getInt(cursor.getColumnIndex(AnimalDatabaseContract.COL_PROFILEPIC)));
        }

        return currentAnimal;
    }

    public void insertAnimalIntoDB(Animal animalToSave){
        SQLiteDatabase writableDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(AnimalDatabaseContract.COL_NAME, animalToSave.getName());
        contentValues.put(AnimalDatabaseContract.COL_CATEGORY, animalToSave.getCategory());
        contentValues.put(AnimalDatabaseContract.COL_DIETTYPE, animalToSave.getDiettype());
        contentValues.put(AnimalDatabaseContract.COL_AVATAR, animalToSave.getAvatar());
        contentValues.put(AnimalDatabaseContract.COL_DESCRIPTION, animalToSave.getDescription());
        contentValues.put(AnimalDatabaseContract.COL_WIKI, animalToSave.getWiki());
        contentValues.put(AnimalDatabaseContract.COL_ID, animalToSave.getId());
        contentValues.put(AnimalDatabaseContract.COL_CRY, animalToSave.getCry());
        contentValues.put(AnimalDatabaseContract.COL_PROFILEPIC, animalToSave.getProfilepic());

        writableDatabase.insert(AnimalDatabaseContract.TABLE_NAME, null, contentValues);
    }

    public void updateAnimalinDB(String id, Animal animalToSave){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(AnimalDatabaseContract.COL_NAME, animalToSave.getName());
        contentValues.put(AnimalDatabaseContract.COL_CATEGORY, animalToSave.getCategory());
        contentValues.put(AnimalDatabaseContract.COL_DIETTYPE, animalToSave.getDiettype());
        contentValues.put(AnimalDatabaseContract.COL_AVATAR, animalToSave.getAvatar());
        contentValues.put(AnimalDatabaseContract.COL_DESCRIPTION, animalToSave.getDescription());
        contentValues.put(AnimalDatabaseContract.COL_WIKI, animalToSave.getWiki());
        contentValues.put(AnimalDatabaseContract.COL_ID, animalToSave.getId());
        contentValues.put(AnimalDatabaseContract.COL_CRY, animalToSave.getCry());
        contentValues.put(AnimalDatabaseContract.COL_PROFILEPIC, animalToSave.getProfilepic());

        sqLiteDatabase.update(AnimalDatabaseContract.TABLE_NAME, contentValues, "ID = ?", new String[]{id});
    }

    //Delete A record
    public void deletePhoneInDB(String id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(AnimalDatabaseContract.TABLE_NAME, "ID = ?", new String[]{id});
    }
}
