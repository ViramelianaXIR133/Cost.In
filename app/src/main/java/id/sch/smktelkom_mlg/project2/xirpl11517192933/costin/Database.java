package id.sch.smktelkom_mlg.project2.xirpl11517192933.costin;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import static id.sch.smktelkom_mlg.project2.xirpl11517192933.costin.Database.isitabel.TOT2;
import static id.sch.smktelkom_mlg.project2.xirpl11517192933.costin.Database.isitabel.TOT3;


/**
 * Created by Vira Meliana on 3/21/2017.
 */

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "db_costin";
    public static final String TABLE_NAME = "tb_transaksi";
    public static final String TABLE_NAME_TOTAL = "tb_total";
    public static final String COL1 = "id_transaksi";
    public static final String COL2 = "jml_uang";
    public static final String COL3 = "kategori";
    public static final String COL4 = "keterangan";
    private static final int DATABASE_VERSION = 1;
    //public static final String COL5 = "tanggal";
//    public static final String TOT1 = "id_total";
//    public static final String TOT2 = "jml_total";
//    public static final String TOT3 = "kategoritotal";
    private Context context;
    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        //SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (id_transaksi INTEGER PRIMARY KEY AUTOINCREMENT, jml_uang INTEGER , kategori TEXT , keterangan TEXT)");
        db.getVersion();
        db.execSQL("create table " + TABLE_NAME_TOTAL + " (id_total INTEGER PRIMARY KEY AUTOINCREMENT, jml_total INTEGER , kategoritotal TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        onCreate(db);

//        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME_TOTAL);
//        onCreate(db);
    }

    public boolean insertData(String jml_uang, String kategori, String keterangan) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, jml_uang);
        contentValues.put(COL3, kategori);
        contentValues.put(COL4, keterangan);
        //contentValues.put(COL5, tanggal);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

//    public boolean insertData(int jml_uang, String kategori, String keterangan, String tanggal) {
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL2,jml_uang);
//        contentValues.put(COL3,kategori);
//        contentValues.put(COL4,keterangan);
//        contentValues.put(COL5,tanggal);
//        long result = db.insert(TABLE_NAME,null,contentValues);
//        if(result == -1)
//            return false;
//        else
//            return true;
//    }

    public boolean insertTotal(String jml_total, String kategoritotal) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TOT2, jml_total);
        contentValues.put(TOT3, kategoritotal);

        long result = db.insert(isitabel.TABLE_NAME_TOTAL, null, contentValues);
        return result != -1;
    }

    public static abstract class isitabel implements BaseColumns {
        public static final String TOT1 = "id_total";
        public static final String TOT2 = "jml_total";
        public static final String TOT3 = "kategoritotal";
        public static final String DATABASE_NAME = "db_costin";
        public static final String TABLE_NAME_TOTAL = "tb_total";

    }
}
