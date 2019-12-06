package vn.edu.uit.tmlnghia.shopping.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.tmlnghia.shopping.R;
import vn.edu.uit.tmlnghia.shopping.adapters.ShoppingCartItemDetailAdapter;
import vn.edu.uit.tmlnghia.shopping.models.SanPham;
import vn.edu.uit.tmlnghia.shopping.models.ShoppingCartItemDetail;
import vn.edu.uit.tmlnghia.shopping.until.UserPresent;
import vn.edu.uit.tmlnghia.shopping.until.Webserviecs;

public class ShoppingCartActivity extends AppCompatActivity {

    List<ShoppingCartItemDetail> shoppingCartItemList;
    TextView oderButton;
    TextView oldPrice;
    TextView discount;
    TextView totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        oldPrice = this.findViewById(R.id.old_price);
        discount = this.findViewById(R.id.discount);
        totalPrice = this.findViewById(R.id.total_price);

//        TODO Thiết lập thanh action bar, thay đổi chức năng nút close
        getSupportActionBar().setTitle(R.string.shopping_cart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close_action);

        loadMaSanPhams loadMaTask = new loadMaSanPhams();
        loadMaTask.execute("?" + UserPresent.user_id);

//        Danh sách các mặt hàng trong giỏ hàng
        shoppingCartItemList = new ArrayList<>();
        shoppingCartItemList.add(new ShoppingCartItemDetail("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", "Tiki Trading", R.drawable.dien_thoai, 3990000, 1));
        shoppingCartItemList.add(new ShoppingCartItemDetail("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", "Tiki Trading", R.drawable.dien_thoai, 3990000, 5));
        shoppingCartItemList.add(new ShoppingCartItemDetail("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", "Tiki Trading", R.drawable.dien_thoai, 3990000, 2));
        shoppingCartItemList.add(new ShoppingCartItemDetail("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", "Tiki Trading", R.drawable.dien_thoai, 3990000, 1));
        shoppingCartItemList.add(new ShoppingCartItemDetail("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", "Tiki Trading", R.drawable.dien_thoai, 3990000, 3));
        shoppingCartItemList.add(new ShoppingCartItemDetail("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", "Tiki Trading", R.drawable.dien_thoai, 3990000, 2));
        shoppingCartItemList.add(new ShoppingCartItemDetail("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", "Tiki Trading", R.drawable.dien_thoai, 3990000, 3));
        shoppingCartItemList.add(new ShoppingCartItemDetail("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", "Tiki Trading", R.drawable.dien_thoai, 3990000, 1));
        shoppingCartItemList.add(new ShoppingCartItemDetail("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", "Tiki Trading", R.drawable.dien_thoai, 3990000, 2));

        RecyclerView itemListRecyclerView = this.findViewById(R.id.item_list);

        ShoppingCartItemDetailAdapter shoppingCartItemDetailAdapter = new ShoppingCartItemDetailAdapter(this, shoppingCartItemList);

        LinearLayoutManager itemListLayoutManager = new LinearLayoutManager(this);

        itemListRecyclerView.setLayoutManager(itemListLayoutManager);

        itemListRecyclerView.setAdapter(shoppingCartItemDetailAdapter);


//        TODO tạo sự kiện nhấn cho nút TIẾN HÀNH ĐẶT HÀNG
//        Chuyển đến màn hình thông tin đặt hàng
        oderButton = this.findViewById(R.id.oder_button);
        oderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Chuyển đến màn hình đặt hàng", Toast.LENGTH_SHORT).show();
            }
        });

    }

    class loadMaSanPhams extends AsyncTask<String, Void, ArrayList<String>>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //gọi task xử lý lấy danh sách sản phẩm
        }

        @Override
        protected void onPostExecute(ArrayList<String> strings) {
            super.onPostExecute(strings);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<String> doInBackground(String... strings) {
            ArrayList<String> maSanPhams = new ArrayList<>();
            try{
                //JSONArray jsonArray = Webserviecs.getJsonArray("sanpham?madm=" + strings[0]);
                JSONArray jsonArray = Webserviecs.getJsonArray("api/donhangs" + strings[0]);
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String masp = jsonObject.getString("sanpham_id");
                    maSanPhams.add(masp);
                }
                return maSanPhams;
            }catch (Exception ex){
                Log.e("Loi: ", ex.toString());
            }
            return null;
        }
    }

   //class loadSanPhams extends AsyncTask<String, Void, >
}
