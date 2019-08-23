package com.example.week2homework2zoo.model.datasource.local.database;

public class AnimalDatabaseContract {

    //create the table and get ready to populate it
    public static final String DATABASE_NAME = "animals_db";
    public static final String TABLE_NAME = "animals_table";

    public static final int DATABASE_VERSION = 1;

    //the class memebers
    public static final String COL_NAME = "name";
    public static final String COL_CATEGORY = "category";
    public static final String COL_DIETTYPE = "diettype";
    public static final String COL_AVATAR = "avatar";
    public static final String COL_DESCRIPTION = "description";
    public static final String COL_WIKI = "wiki";

    public static final String COL_CRY = "cry";
    public static final String COL_PROFILEPIC = "profilepic";
    public static final String COL_ID = "id";

    //Create Table Query
    public static final String QUERY_CREATE_TABLE =
            String.format("CREATE TABLE %s(%s TEXT, %s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT,%s TEXT, %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)",
                    TABLE_NAME,COL_NAME,COL_CATEGORY, COL_DIETTYPE, COL_AVATAR, COL_DESCRIPTION, COL_WIKI, COL_CRY, COL_PROFILEPIC, COL_ID);

    //Select All Query
    public static final String QUERY_SELECT_ALL = String.format("SELECT * FROM %s", TABLE_NAME);

    //SELECT by ID
    public static String QUERY_SELECT_BY_ID(String id){
        return String.format("SELECT * FROM %s WHERE %s = \'%s\'", TABLE_NAME, COL_ID, id);
    }

    //Drop Table Query
    public static final String DROP_TABLE = String.format("DROP TABLE %s", TABLE_NAME);
}
