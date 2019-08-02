package bd.com.hasan.app.dailyexpense;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME ="Expense.db";
    public static String TABLE_NAME ="Expense";
    public static String COL_ID ="Id";
    public static String COL_EXPENSETYPE ="Expense Type";
    public static String COL_Amount ="Amount";
    public static String COL_DATE ="Date";
    public static String COL_TIME ="Time";
    public static int VERSION =1;
    public static String CREATE_TABLE = "create table "+TABLE_NAME+"(Id integer primary key, ExpenseType Text,Amount Text, Date Text, Time Text)";

    public DatabaseHelper(@Nullable Context context) {
        super(context, TABLE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public long insertData(String expenseType,String amount, String date, String time){
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EXPENSETYPE,expenseType);
        contentValues.put(COL_Amount,amount);
        contentValues.put(COL_DATE,date);
        contentValues.put(COL_TIME,time);
        SQLiteDatabase sqLiteDatabase =getWritableDatabase();
        long id = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
        return id;

    }

    public Cursor showData(){
        String showAll ="Select * From "+TABLE_NAME;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery(showAll,null);
        return cursor;
    }

}
