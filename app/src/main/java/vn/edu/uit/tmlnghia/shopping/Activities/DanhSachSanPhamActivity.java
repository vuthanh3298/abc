package vn.edu.uit.tmlnghia.shopping.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import vn.edu.uit.tmlnghia.shopping.R;
import vn.edu.uit.tmlnghia.shopping.adapters.DanhSachSanPhamAdapter;
import vn.edu.uit.tmlnghia.shopping.models.SanPham;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DanhSachSanPhamActivity extends AppCompatActivity {

    RecyclerView recyclerViewDSSP;
    DanhSachSanPhamAdapter adapterDSSP;
    ArrayList<SanPham> sanPhams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_sach_san_pham);
        loadData();
        initControls();

    }

    private void loadData() {
//        ArrayList<Integer> hinhs = new ArrayList<Integer>();
//        hinhs.add(R.drawable.balo_tui_xach);
//        hinhs.add(R.drawable.banh_keo);
//        hinhs.add(R.drawable.bep_gas_bep_dien);
//        hinhs.add(R.drawable.bia_ruou_nuoc_ngot);
//        hinhs.add(R.drawable.chuot_gamming);
//        hinhs.add(R.drawable.do_choi);
////
        sanPhams = new ArrayList<>();
//        sanPhams.add(new SanPham(hinhs,"sản phẩm abc","đây là sản phẩm abc", 100000, 120000, 20));
//        sanPhams.add(new SanPham(hinhs,"sản phẩm abc","đây là sản phẩm abc", 100000, 120000, 20));
//        sanPhams.add(new SanPham(hinhs,"sản phẩm abc","đây là sản phẩm abc", 100000, 120000, 20));
//        sanPhams.add(new SanPham(hinhs,"sản phẩm abc","đây là sản phẩm abc", 100000, 120000, 20));
//        sanPhams.add(new SanPham(hinhs,"sản phẩm abc","đây là sản phẩm abc", 100000, 120000, 20));
//        sanPhams.add(new SanPham(hinhs,"sản phẩm abc","đây là sản phẩm abc", 100000, 120000, 20));
//        sanPhams.add(new SanPham(hinhs,"sản phẩm abc","đây là sản phẩm abc", 100000, 120000, 20));
//        sanPhams.add(new SanPham(hinhs,"sản phẩm abc","đây là sản phẩm abc", 100000, 120000, 20));
//        sanPhams.add(new SanPham(hinhs,"sản phẩm abc","đây là sản phẩm abc", 100000, 120000, 20));
//        sanPhams.add(new SanPham(hinhs,"sản phẩm abc","đây là sản phẩm abc", 100000, 120000, 20));
//        sanPhams.add(new SanPham(hinhs,"sản phẩm abc","đây là sản phẩm abc", 100000, 120000, 20));
//        sanPhams.add(new SanPham(hinhs,"sản phẩm abc","đây là sản phẩm abc", 100000, 120000, 20));
        LoadSanPhamTask task = new LoadSanPhamTask();
        task.execute("dt");
    }

    private void initControls() {
        recyclerViewDSSP = findViewById(R.id.recyclerViewDSSP);
        adapterDSSP = new DanhSachSanPhamAdapter(DanhSachSanPhamActivity.this, sanPhams);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerViewDSSP.setLayoutManager(layoutManager);
        recyclerViewDSSP.setAdapter(adapterDSSP);
    }

    class LoadSanPhamTask extends AsyncTask<String, Void, ArrayList<SanPham>>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ArrayList<SanPham> sanPhams) {
            super.onPostExecute(sanPhams);
            if(sanPhams != null){
                DanhSachSanPhamActivity.this.sanPhams.clear();
                DanhSachSanPhamActivity.this.sanPhams.addAll(sanPhams);
                adapterDSSP.notifyDataSetChanged();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<SanPham> doInBackground(String... strings) {
            ArrayList<SanPham> sanPhams = new ArrayList<>();
            try{
                URL url = new URL("http://192.168.1.110/webservices/api/sanpham");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

                InputStreamReader isr = new InputStreamReader(connection.getInputStream(), "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                StringBuilder builder = new StringBuilder();
                String line = null;
                while((line = br.readLine()) != null){
                    builder.append(line);
                }
                JSONArray jsonArray = new JSONArray(builder.toString());
                for(int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String masp = jsonObject.getString("maSP");
                    String ten = jsonObject.getString("tenSP");
                    String mota = jsonObject.getString("moTa");
                    double gia = jsonObject.getDouble("gia");
                    double giaCu = jsonObject.getDouble("giaCu");
                    double giamGia = jsonObject.getDouble("tiLeGiamGia");
                    String hinh = jsonObject.getString("hinh");
                    SanPham sp = new SanPham();
                    sp.setMaSanPham(masp);
                    sp.setTenSanPham(ten);
                    sp.setMoTa(mota);
                    sp.setGia(gia);
                    sp.setGiaCu(giaCu);
                    sp.setGiamGia(giamGia);
                    sp.setHinh(hinh);
                    sanPhams.add(sp);
                }
                br.close();
                return sanPhams;
            }catch (Exception ex){
                Log.e("Loi: ", ex.toString());
            }
            return null;
        }
    }
}
