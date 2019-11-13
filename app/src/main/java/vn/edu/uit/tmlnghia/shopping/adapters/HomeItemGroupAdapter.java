package vn.edu.uit.tmlnghia.shopping.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.uit.tmlnghia.shopping.R;
import vn.edu.uit.tmlnghia.shopping.models.HomeItemGroup;

public class HomeItemGroupAdapter extends RecyclerView.Adapter<HomeItemGroupAdapter.MyViewHolder>{
    private Context context;
    private List<HomeItemGroup> data;

    public HomeItemGroupAdapter(Context context, List<HomeItemGroup> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public HomeItemGroupAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.home_fragment_item_group_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.title.setText(data.get(position).getTitle());
        holder.image.setImageResource(data.get(position).getImage());

//        TODO tạo sự kiện nhấn cho nhóm sản phẩm dưới thanh search
//        Chuyển đến màn hình danh sách các mặt hàng
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, data.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView image;
        CardView cardView;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.home_item_group_textview);
            image = (ImageView) itemView.findViewById(R.id.home_fragment_item_group_item_imageview);
            cardView = (CardView)itemView.findViewById(R.id.home_fragment_item_group_item_container_cardview_id);
        }
    }
}
