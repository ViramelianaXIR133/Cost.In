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
public class MasukFragment extends Fragment {

    Database2 SQLITEHELPER;
    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;
    SQLiteMasukAdapter ListAdapter;

    ArrayList<String> uang_ArrayList = new ArrayList<String>();
    ListView LISTVIEW;

    public MasukFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_masuk, container, false);
        LISTVIEW = (ListView) v.findViewById(R.id.listView4);

        SQLITEHELPER = new Database2(getActivity());

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onResume() {

        ShowSQLITEDBData();

        super.onResume();
    }

    private void ShowSQLITEDBData() {
        SQLITEDATABASE = SQLITEHELPER.getWritableDatabase();
        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM tb_total", null);

        uang_ArrayList.clear();

        if (cursor.moveToFirst()) {
            do {
                uang_ArrayList.add(cursor.getString(cursor.getColumnIndex(Database2.TOT2)));
            } while (cursor.moveToNext());

        }

        ListAdapter = new SQLiteMasukAdapter(
                getActivity(), uang_ArrayList
        );

        LISTVIEW.setAdapter(ListAdapter);
        cursor.close();

    }

}
