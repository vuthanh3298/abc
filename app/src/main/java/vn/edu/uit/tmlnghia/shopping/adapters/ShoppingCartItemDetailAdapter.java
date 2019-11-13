package vn.edu.uit.tmlnghia.shopping.adapters;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StrikethroughSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.edu.uit.tmlnghia.shopping.R;
import vn.edu.uit.tmlnghia.shopping.models.HomeDeal;
import vn.edu.uit.tmlnghia.shopping.models.ShoppingCartItemDetail;

public class ShoppingCartItemDetailAdapter extends RecyclerView.Adapter<ShoppingCartItemDetailAdapter.MyViewHolder> {

    private Context context;
    private List<ShoppingCartItemDetail> data;


    public ShoppingCartItemDetailAdapter(Context context, List<ShoppingCartItemDetail> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(context);
        view = mInflater.inflate(R.layout.shopping_cart_item_detail, parent, false);

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

        String price = getPrice(data.get(position).getPrice(), 0) + " vnd";
        String seller = "Cung cấp bởi " + data.get(position).getSeller();

//        Gán các giá trị cho holder
        holder.name.setText(data.get(position).getName());
        holder.image.setImageResource(data.get(position).getImage());
        holder.price.setText(price);
        holder.seller.setText(seller);

//        TODO Tạo sự kiện nhấn cho sản phẩm trong giỏ hàng (Nhấn vào hình hoặc tiêu đề)
//        Chuyển đến màn hình chi tiết mặt hàng

//        Khi bấm vào hình ảnh mặt hàng
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, data.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
//        Khi nhấn vào tiêu đề sản phẩm
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, data.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

//        TODO Tạo sự kiện nhấn cho nút delete
//        Xóa mặt hàng trong danh sách
        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Xóa sản phẩm", Toast.LENGTH_SHORT).show();
            }
        });

//        TODO Tạo sự kiện nhấn cho nút Thêm và Bớt mặt hàng trong giỏ hàng
//        holder.decreaseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Số lượng giảm đi 1", Toast.LENGTH_SHORT).show();
//            }
//        });
//        holder.increaseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Số lượng tăng lên 1", Toast.LENGTH_SHORT).show();
//            }
//        });



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        ImageView image;
        TextView price;
        TextView seller;
        Button deleteButton;
//        TextView decreaseButton;
//        TextView increaseButton;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.item_detail_name);
            image = itemView.findViewById(R.id.item_image);
            price = itemView.findViewById(R.id.item_detail_new_price);
            seller = itemView.findViewById(R.id.item_detail_seller);
            deleteButton = itemView.findViewById(R.id.delete_button);
//            decreaseButton = itemView.findViewById(R.id.decrease_button);
//            increaseButton = itemView.findViewById(R.id.increase_button);

        }
    }
}
