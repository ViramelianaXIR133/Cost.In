package id.sch.smktelkom_mlg.project2.xirpl11517192933.costin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Smktelkom on 4/1/2017.
 */

public class Database2 extends SQLiteOpenHelper {

    public static final String TOT1 = "id_total";
    public static final String TOT2 = "jml_total";
    public static final String TOT3 = "kategoritotal";
    public static final String DATABASE_NAME = "db_costintotal";
    public static final String TABLE_NAME_TOTAL = "tb_total";
    public static final int DATABASE_VERSION = 1;

    private Context context;

    public Database2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        //SQLiteDatabase db = this.getWritableDatabase();

    }

    public boolean insertTotal(String jml_total, String kategoritotal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TOT2, jml_total);
        contentValues.put(TOT3, kategoritotal);

        long result = db.insert(TABLE_NAME_TOTAL, null, contentValues);
        return result != -1;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.getVersion();
        db.execSQL("create table " + TABLE_NAME_TOTAL + " (id_total INTEGER PRIMARY KEY AUTOINCREMENT, jml_total INTEGER , kategoritotal TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME_TOTAL);
        onCreate(db);
    }

    public Cursor getSomeTotalData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select kategori from " + TABLE_NAME_TOTAL, null);
        return res;
    }
}
