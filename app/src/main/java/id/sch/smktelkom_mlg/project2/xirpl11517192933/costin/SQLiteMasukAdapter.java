package id.sch.smktelkom_mlg.project2.xirpl11517192933.costin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Smktelkom on 4/1/2017.
 */

public class SQLiteMasukAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> totuang;

    public SQLiteMasukAdapter(
            Context context2,
            ArrayList<String> uang
    )

    {
        this.context = context2;
        this.totuang = uang;
    }


    @Override
    public int getCount() {
        return totuang.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View child, ViewGroup parent) {
        Holder holder;

        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.layout_pemasukan, null);

            holder = new Holder();

            holder.textviewuangb = (TextView) child.findViewById(R.id.textViewJmlRp);

            child.setTag(holder);

        } else {

            holder = (Holder) child.getTag();
        }
        holder.textviewuangb.setText(totuang.get(position));

        return child;
    }

    public class Holder {
        TextView textviewuangb;
    }
}
