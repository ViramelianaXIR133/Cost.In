package id.sch.smktelkom_mlg.project2.xirpl11517192933.costin;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class UangFragment extends Fragment {

    Database SQLITEHELPER;
    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;
    SQLiteListAdapter ListAdapter;

    ArrayList<String> uang_ArrayList = new ArrayList<String>();
    ArrayList<String> catatan_ArrayList = new ArrayList<String>();
    ListView LISTVIEW;
    public UangFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.uang_layout, container, false);
        LISTVIEW = (ListView) v.findViewById(R.id.listView1);

        SQLITEHELPER = new Database(getActivity());
//        ArrayList <String> listtransaksi = new ArrayList<>();
//        ArrayAdapter<String> adapter;
//        adapter = ArrayAdapter.createFromResource(getActivity(), android.R.layout.simple_spinner_item, listtransaksi);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onResume() {

        ShowSQLiteDBdata();

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        SQLITEDATABASE = SQLITEHELPER.getWritableDatabase();

        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM tb_transaksi", null);

        uang_ArrayList.clear();
        catatan_ArrayList.clear();

        if (cursor.moveToFirst()) {
            do {
                uang_ArrayList.add(cursor.getString(cursor.getColumnIndex(Database.COL2)));

                catatan_ArrayList.add(cursor.getString(cursor.getColumnIndex(Database.COL4)));

            } while (cursor.moveToNext());
        }

        ListAdapter = new SQLiteListAdapter(
                getActivity(), uang_ArrayList, catatan_ArrayList


        );


        LISTVIEW.setAdapter(ListAdapter);

        cursor.close();
    }

}

