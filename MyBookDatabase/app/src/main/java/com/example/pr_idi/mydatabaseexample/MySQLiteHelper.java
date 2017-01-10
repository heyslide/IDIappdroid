package com.example.pr_idi.mydatabaseexample;

/**
 * MySQLiteHelper
 * Created by pr_idi on 10/11/16.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_BOOKS = "books";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_YEAR = "year";
    public static final String COLUMN_PUBLISHER= "publisher";
    public static final String COLUMN_CATEGORY= "category";
    public static final String COLUMN_PERSONAL_EVALUATION = "personal_evaluation";


    private static final String DATABASE_NAME = "books.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table " + TABLE_BOOKS + "( "
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_TITLE + " text not null, "
            + COLUMN_AUTHOR + " text not null, "
            + COLUMN_YEAR + " integer, "
            + COLUMN_PUBLISHER + " text not null, "
            + COLUMN_CATEGORY + " text not null, "
            + COLUMN_PERSONAL_EVALUATION + " text"
            + ");";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private ContentValues createValues(String title, String author, String publisher, Integer year, String category, String rating) {

        ContentValues values = new ContentValues();

        // Add data: Note that this method only provides title and author
        // Must modify the method to add the full data
        values.put(MySQLiteHelper.COLUMN_TITLE, title);
        values.put(MySQLiteHelper.COLUMN_AUTHOR, author);
        values.put(MySQLiteHelper.COLUMN_PUBLISHER, publisher);
        values.put(MySQLiteHelper.COLUMN_YEAR, year);
        values.put(MySQLiteHelper.COLUMN_CATEGORY, category);
        values.put(MySQLiteHelper.COLUMN_PERSONAL_EVALUATION, rating);
        return values;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL(DATABASE_CREATE);
        ContentValues values = createValues("Harry Potter and the Deathly Hallows", "J. K. Rowling", "Bloomsbury", 2007, "Fantasy", "Very good");
        database.insert(TABLE_BOOKS, null, values);
        values = createValues("Harry Potter and the Order of the Phoenix", "J. K. Rowling", "Bloomsbury", 2003, "Fantasy", "Good");
        database.insert(TABLE_BOOKS, null, values);
        values = createValues("Hard-Boiled Wonderland and the End of the World", "Haruki Murakami", "Kodansha International", 1991, "Other", "Very bad");
        database.insert(TABLE_BOOKS, null, values);
        values = createValues("Shadow divers", "Robert Kurson", "Random House", 2004, "Non-fiction", "Bad");
        database.insert(TABLE_BOOKS, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
        onCreate(db);
    }

}