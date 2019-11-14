package vn.edu.uit.tmlnghia.shopping.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.uit.tmlnghia.shopping.R;
import vn.edu.uit.tmlnghia.shopping.adapters.HomeAdvertisementAdapter;
import vn.edu.uit.tmlnghia.shopping.adapters.HomeDealAdapter;
import vn.edu.uit.tmlnghia.shopping.adapters.HomeItemGroupAdapter;
import vn.edu.uit.tmlnghia.shopping.models.HomeAdvertisement;
import vn.edu.uit.tmlnghia.shopping.models.HomeDeal;
import vn.edu.uit.tmlnghia.shopping.models.HomeItemGroup;

public class HomeFragment extends Fragment {

//    Danh sách các nhóm mặt hàng dưới thanh search bar
    List<HomeItemGroup> listItemGroup;

    //    Danh sách quảng cáo
    List<HomeAdvertisement> listAdvertisement;

//    Danh sách các mặt hàng giảm giá
    List<HomeDeal> listDeal;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        Nhập dữ liệu cho nhóm mặt hàng gợi ý dưới thanh search bar
        listItemGroup = new ArrayList<>();
        listItemGroup.add(new HomeItemGroup("Đồ gia dụng", R.drawable.housewares));
        listItemGroup.add(new HomeItemGroup("Thực phẩm", R.drawable.food));
        listItemGroup.add(new HomeItemGroup("Điện thoại và Đồng hồ thông minh", R.drawable.phones_and_watches));
        listItemGroup.add(new HomeItemGroup("Máy tính", R.drawable.computers));
        listItemGroup.add(new HomeItemGroup("Thời trang", R.drawable.thoi_trang_tre_em));
        listItemGroup.add(new HomeItemGroup("TV - Tủ lạnh - Máy giặt", R.drawable.ti_vi_tu_lanh_may_giat));
        listItemGroup.add(new HomeItemGroup("Giày dép", R.drawable.giay_dep));
        listItemGroup.add(new HomeItemGroup("Board Games", R.drawable.board_game));
        listItemGroup.add(new HomeItemGroup("Bia - Rượu - Nước ngọt", R.drawable.bia_ruou_nuoc_ngot));


//        Nhập dữ liệu cho banner quảng cáo
        listAdvertisement = new ArrayList<>();
        listAdvertisement.add(new HomeAdvertisement("Một vài câu quảng cáo cho một sản phẩm mới nào đớ bla bla", R.drawable.clothes));
        listAdvertisement.add(new HomeAdvertisement("Một vài câu quảng cáo cho một sản phẩm mới nào đớ bla bla", R.drawable.clothes));
        listAdvertisement.add(new HomeAdvertisement("Một vài câu quảng cáo cho một sản phẩm mới nào đớ bla bla", R.drawable.clothes));
        listAdvertisement.add(new HomeAdvertisement("Một vài câu quảng cáo cho một sản phẩm mới nào đớ bla bla", R.drawable.clothes));
        listAdvertisement.add(new HomeAdvertisement("Một vài câu quảng cáo cho một sản phẩm mới nào đớ bla bla", R.drawable.clothes));
        listAdvertisement.add(new HomeAdvertisement("Một vài câu quảng cáo cho một sản phẩm mới nào đớ bla bla", R.drawable.clothes));
        listAdvertisement.add(new HomeAdvertisement("Một vài câu quảng cáo cho một sản phẩm mới nào đớ bla bla", R.drawable.clothes));
        listAdvertisement.add(new HomeAdvertisement("Một vài câu quảng cáo cho một sản phẩm mới nào đớ bla bla", R.drawable.clothes));
        listAdvertisement.add(new HomeAdvertisement("Một vài câu quảng cáo cho một sản phẩm mới nào đớ bla bla", R.drawable.clothes));

//        Nhập dữ liệu cho nhóm mặt hàng giảm giá
        listDeal = new ArrayList<>();
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));
        listDeal.add(new HomeDeal("Máy Ảnh Nikon D3500 KIT 18-55 VR (24.2MP) - Hàng Chính Hãng", R.drawable.nikon, 9590000, 14990000));


        View view = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView itemGroupRecyclerView = view.findViewById(R.id.item_group_recyclerview);
        RecyclerView dealRecyclerView = view.findViewById(R.id.deal_recyclerview);
        RecyclerView advertisementRecyclerView = view.findViewById(R.id.advertisement_recyclerview);


        HomeItemGroupAdapter itemGroupAdapter = new HomeItemGroupAdapter(getActivity(), listItemGroup);
        HomeDealAdapter dealAdapter = new HomeDealAdapter(getActivity(), listDeal);
        HomeAdvertisementAdapter advertisementAdapter = new HomeAdvertisementAdapter(getActivity(), listAdvertisement);


        LinearLayoutManager itemGroupLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager dealLayoutManager = new GridLayoutManager(getActivity(), 2);
        LinearLayoutManager advertisementLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);


        itemGroupRecyclerView.setLayoutManager(itemGroupLayoutManager);
        itemGroupRecyclerView.setAdapter(itemGroupAdapter);

        advertisementRecyclerView.setLayoutManager(advertisementLayoutManager);
        advertisementRecyclerView.setAdapter(advertisementAdapter);

        dealRecyclerView.setLayoutManager(dealLayoutManager);
        dealRecyclerView.setAdapter(dealAdapter);

        return view;

    }
}
