package id.sch.smktelkom_mlg.project2.xirpl11517192933.costin;

/**
 * Created by gerald junha on 27/03/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SQLiteListAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> uang;
    ArrayList<String> catatan;

    public SQLiteListAdapter(
            Context context2,
            ArrayList<String> uang,
            ArrayList<String> catatan
    )

    {

        this.context = context2;
        this.uang = uang;
        this.catatan = catatan;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return uang.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(int position, View child, ViewGroup parent) {

        Holder holder;

        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.layout_detail, null);

            holder = new Holder();

            holder.textviewuanga = (TextView) child.findViewById(R.id.textViewJenis);
            holder.textviewcatatana = (TextView) child.findViewById(R.id.textViewCatatan);


            child.setTag(holder);

        } else {

            holder = (Holder) child.getTag();
        }
        holder.textviewuanga.setText(uang.get(position));
        holder.textviewcatatana.setText(catatan.get(position));

        return child;
    }

    public class Holder {
        TextView textviewuanga;
        TextView textviewcatatana;
    }

}