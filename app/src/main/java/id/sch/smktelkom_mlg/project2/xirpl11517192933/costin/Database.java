package id.sch.smktelkom_mlg.project2.xirpl11517192933.costin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vira Meliana on 3/21/2017.
 */

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "db_costin";
    public static final String TABLE_NAME = "tb_transaksi";
    public static final String COL1 = "id_transaksi";
    public static final String COL2 = "jml_uang";
    public static final String COL3 = "kategori";
    public static final String COL4 = "keterangan";
    public static final String COL5 = "tanggal";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (id_transaksi INTEGER PRIMARY KEY AUTOINCREMENT, jml_uang INTEGER, kategori TEXT, keterangan TEXT, tanggal DATE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        onCreate(db);
    }
}
