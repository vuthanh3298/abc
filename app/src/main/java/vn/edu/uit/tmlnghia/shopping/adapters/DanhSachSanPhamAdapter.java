package vn.edu.uit.tmlnghia.shopping.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import vn.edu.uit.tmlnghia.shopping.R;
import vn.edu.uit.tmlnghia.shopping.models.SanPham;
import vn.edu.uit.tmlnghia.shopping.Activities.ChiTietSanPhamActivity;

public class DanhSachSanPhamAdapter extends RecyclerView.Adapter<DanhSachSanPhamAdapter.MyViewHolder> {

    private Context context;
    private List<SanPham> data;

    public DanhSachSanPhamAdapter(Context context, List<SanPham> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.danh_sach_san_pham_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        final SanPham sp = data.get(position);

        DecimalFormat dcf = new DecimalFormat("###,###,###");

        holder.txtTenSanPham.setText(sp.getTenSanPham());
        holder.txtGiaSanPham.setText(dcf.format(sp.getGia()) + "đ");
        holder.txtGiaCu.setText(dcf.format(sp.getGiaCu()) + "đ");
        holder.txtGiaCu.setPaintFlags(holder.txtGiaCu.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.txtGiamGia.setText("- " + sp.getGiamGia() + "%");

        byte[] imageBytes = Base64.decode(sp.getHinh(), Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        holder.img.setImageBitmap(decodedImage);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ChiTietSanPhamActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

       TextView txtTenSanPham, txtGiaSanPham, txtGiaCu, txtGiamGia;
       ImageView img;
       CardView cardView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTenSanPham = itemView.findViewById(R.id.txtItemTenSanPham);
            txtGiaSanPham = itemView.findViewById(R.id.txtItemGiaSanPham);
            txtGiaCu = itemView.findViewById(R.id.txtItemGiaCu);
            txtGiamGia = itemView.findViewById(R.id.txtItemGiamGia);
            cardView = itemView.findViewById(R.id.cardview_danhsachsanpham);
            img = itemView.findViewById(R.id.imgItemSanPham);
        }
    }
}
