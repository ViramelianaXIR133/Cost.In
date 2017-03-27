package id.sch.smktelkom_mlg.project2.xirpl11517192933.costin.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project2.xirpl11517192933.costin.R;
import id.sch.smktelkom_mlg.project2.xirpl11517192933.costin.model.Detail;

/**
 * Created by Smktelkom on 3/26/2017.
 */

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {

    ArrayList<Detail> detailList;

    public DetailAdapter(ArrayList<Detail> detailList) {
        this.detailList = detailList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_detail, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Detail detail = detailList.get(position);
        holder.tvJenis.setText(detail.jenis);
        holder.tvCatatan.setText(detail.catatan);
        holder.ivFoto.setImageDrawable(detail.foto);

    }

    @Override
    public int getItemCount() {
        if (detailList != null)
            return detailList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivFoto;
        TextView tvJenis;
        TextView tvCatatan;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJenis = (TextView) itemView.findViewById(R.id.textViewJenis);
            tvCatatan = (TextView) itemView.findViewById(R.id.textViewCatatan);
        }
    }
}
