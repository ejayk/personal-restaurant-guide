package ca.gbc.comp3074.personalrestaurantguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String database_name="Entries.db";
    public static final String table_name="Restaurants_table";
    public static final String column_id="Id";
    public static final String column_name="name";
    public static final String column_address="address";
    public static final String column_phone="phone";
    public static final String column_description="description";
    public static final String column_rating="rating";
    public static final String column_tags="tags";
    public DatabaseHelper(@Nullable Context context){
        super(context,database_name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table " + table_name +" (Id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT , address TEXT," +
                "phone TEXT,description TEXT,rating TEXT,tags TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i,int i1){
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+table_name);
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String name,String address,String phone,String description,String rating,String tags){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(column_name,name);
        cv.put(column_address,address);
        cv.put(column_phone,phone);
        cv.put(column_description,description);
        cv.put(column_rating,rating);
        cv.put(column_tags,tags);
        Long result=db.insert(table_name,null,cv);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }


    public Cursor showData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from "+table_name,null);
        return cursor;
    }

    public Integer delete(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(table_name,"Id = ?",new String[] {id});
    }


}
