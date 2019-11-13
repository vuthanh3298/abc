package vn.edu.uit.tmlnghia.shopping.Activities;

import androidx.appcompat.app.AppCompatActivity;

import vn.edu.uit.tmlnghia.shopping.R;

import android.os.Bundle;

public class ChiTietSanPhamActivity extends AppCompatActivity{

//    TextView txtTenSanPham, txtGiaSanPham, txtGiaCu, txtGiamGia, txtMoTa;
//    Spinner spinner;
//    Button btnChonSanPham;
//    ImageView imgSanPham;
//    RecyclerView recyclerViewHinhSanPhams;
//
//    SanPham sp;
//
//    ArrayList<Integer> hinhs;
//
//    RecyclerViewClickListener clickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_san_pham);

//        getData();
//        initControls();
//        loadDataToView();
    }

//    private void loadDataToView() {
//        txtTenSanPham.setText(sp.getTenSanPham());
//        DecimalFormat dcf = new DecimalFormat("###,###,###");
//        txtGiaSanPham.setText(dcf.format(sp.getGia()) + "đ");
//        txtGiaCu.setText(dcf.format(sp.getGiaCu()) + "đ");
//        txtGiaCu.setPaintFlags(txtGiaCu.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
//        txtGiamGia.setText("- " + sp.getGiamGia() + "%");
//        txtMoTa.setText(sp.getMoTa());
//        imgSanPham.setImageResource(R.drawable.balo_tui_xach);
//    }
//
//    private void getData() {
//        hinhs = new ArrayList<Integer>();
//        hinhs.add(R.drawable.balo_tui_xach);
//        hinhs.add(R.drawable.banh_keo);
//        hinhs.add(R.drawable.bep_gas_bep_dien);
//        hinhs.add(R.drawable.bia_ruou_nuoc_ngot);
//        hinhs.add(R.drawable.chuot_gamming);
//        hinhs.add(R.drawable.do_choi);
//        sp = new SanPham("sanphamabc","sản phẩm abc dafjaldf qjeorjdlacl xmasdljk jfdlaskj oieqj kjlkajx","đây là sản phẩm abc adks;alkoqk ;ldk;alk;zl  adjfjas qwjefljadj ax lajlkfjqj d lajflkajx ljdlaj fdj fqojfda j adjjfqkl fdaj djalkj qda lk fa dfalj aljf jqj fda ", 100000, 120000, 20);
//    }
//
//    private void initControls() {
//        txtTenSanPham = findViewById(R.id.txtTenSanPham);
//        txtGiaSanPham = findViewById(R.id.txtGiaSanPham);
//        txtGiaCu = findViewById(R.id.txtGiaCu);
//        txtGiamGia = findViewById(R.id.txtGiamGia);
//        txtMoTa = findViewById(R.id.txtMotaSanPham);
//        btnChonSanPham = findViewById(R.id.btnChonMuaSanPham);
//        imgSanPham = findViewById(R.id.imgSanPham);
//        spinner = findViewById(R.id.spinerSoLuongSanPham);
//        Integer[] soLuong = new Integer[]{1,2,3,4,5,6,7,8,9,10};
//        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,soLuong);
//        spinner.setAdapter(adapter);
//
//        clickListener = new RecyclerViewClickListener() {
//            @Override
//            public void recyclerViewListClicked(int position) {
//                imgSanPham.setImageResource(hinhs.get(position));
//            }
//        };
//
//        recyclerViewHinhSanPhams = findViewById(R.id.recyclerImgSanPhams);
//        DanhSachHinhItemAdapter adapterItem = new DanhSachHinhItemAdapter(getApplicationContext(), hinhs,clickListener);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//
//        recyclerViewHinhSanPhams.setLayoutManager(layoutManager);
//        recyclerViewHinhSanPhams.setAdapter(adapterItem);
//
//    }
}
