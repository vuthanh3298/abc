package vn.edu.uit.tmlnghia.shopping.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import vn.edu.uit.tmlnghia.shopping.R;
import vn.edu.uit.tmlnghia.shopping.Activities.RecyclerViewClickListener;

public class DanhSachHinhItemAdapter extends RecyclerView.Adapter<DanhSachHinhItemAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<Integer> data;
    private RecyclerViewClickListener itemListener;

    public DanhSachHinhItemAdapter(Context context, ArrayList<Integer> data) {
        this.context = context;
        this.data = data;
    }

    public DanhSachHinhItemAdapter(Context context, ArrayList<Integer> data, RecyclerViewClickListener itemListener) {
        this.context = context;
        this.data = data;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public DanhSachHinhItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        view = mInflater.inflate(R.layout.danh_sach_hinh_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.image.setImageResource(data.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemListener.recyclerViewListClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.imgDanhSachHinhItem);
            cardView = (CardView)itemView.findViewById(R.id.cardviewDanhSachHinhItem);
        }
    }
}