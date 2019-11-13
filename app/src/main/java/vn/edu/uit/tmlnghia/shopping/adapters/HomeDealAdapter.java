package vn.edu.uit.tmlnghia.shopping.adapters;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
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
import vn.edu.uit.tmlnghia.shopping.models.HomeDeal;

public class HomeDealAdapter extends RecyclerView.Adapter<HomeDealAdapter.MyViewHolder> {

    private Context context;
    private List<HomeDeal> data;


    public HomeDealAdapter(Context context, List<HomeDeal> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.home_fragment_deal_item, parent, false);

        return new MyViewHolder(view);
    }


    //    Xuất số tiền từ int thành chuỗi String có dấu chấm
    private String getPrice(int num, int count) {
        count++;
        if (num == 0)
            return "";
        if (count < 3)
            return getPrice(num / 10, count) + num % 10;
        return getPrice(num / 10, 0) + "." + num % 10;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        String newPrice = getPrice(data.get(position).getNewPrice(), 0) + " đ";
        SpannableString oldPrice = new SpannableString(getPrice(data.get(position).getOldPrice(), 0) + " vnd");
//        Tính số phần trăm được giảm giá và chuyển về String
        String discountPercent = "-" + (int) (100 - ((float) data.get(position).getNewPrice() / (float) data.get(position).getOldPrice()) * 100) + "%";

//        Tạo gạch ngang cho giá cũ
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        oldPrice.setSpan(strikethroughSpan, 0, oldPrice.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

//        Gán các giá trị cho holder
        holder.title.setText(data.get(position).getTitle());
        holder.image.setImageResource(data.get(position).getImage());
        holder.newPrice.setText(newPrice);
        holder.oldPrice.setText(oldPrice);
        holder.discountPercent.setText(discountPercent);

//        TODO Tạo sự kiện nhấn cho sản phẩm
//        Chuyển đến màn hình chi tiết mặt hàng
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
        TextView newPrice;
        TextView oldPrice;
        TextView discountPercent;
        CardView cardView;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.home_deal_item_title_id);
            image = itemView.findViewById(R.id.home_deal_item_image_id);
            newPrice = itemView.findViewById(R.id.home_deal_item_new_price_id);
            oldPrice = itemView.findViewById(R.id.home_deal_item_old_price_id);
            discountPercent = itemView.findViewById(R.id.home_deal_item_discount_percent_id);
            cardView = itemView.findViewById(R.id.home_deal_item_card_view_id);

        }
    }
}
