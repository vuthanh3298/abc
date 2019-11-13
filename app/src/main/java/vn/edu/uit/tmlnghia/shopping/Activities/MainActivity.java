package vn.edu.uit.tmlnghia.shopping.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import vn.edu.uit.tmlnghia.shopping.R;
import vn.edu.uit.tmlnghia.shopping.fragments.CategoryFragment;
import vn.edu.uit.tmlnghia.shopping.fragments.HomeFragment;
import vn.edu.uit.tmlnghia.shopping.fragments.LoggedInAccountFragment;
import vn.edu.uit.tmlnghia.shopping.fragments.NotLoginAccountFragment;
import vn.edu.uit.tmlnghia.shopping.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//  Tạo thanh điều hướng bên dưới cho activity
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

//        Tạo thanh actions bar
        getMenuInflater().inflate(R.menu.main_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

//            Gán fragment cho thanh điều hướng bên dưới
            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.nav_category:
                    selectedFragment = new CategoryFragment();
                    break;
                case R.id.nav_search:
                    selectedFragment = new SearchFragment();
                    break;
                case R.id.nav_account_information:

//                    TODO Thêm điều kiện để hiển thị loại màn hình tài khoản khi bấm vào biểu tượng tài khoản dưới thanh nav
//                    Nếu tài khoản chưa đăng nhập thì hiển thị màn hình NotLoginAccountFragment
//                    Nếu tài khoản đã đăng nhập thì hiển thị màn hình LoggedInAccountFragment
                    if (true)
                        selectedFragment = new LoggedInAccountFragment();
                    else
                        selectedFragment = new NotLoginAccountFragment();
                    break;
            }

            assert selectedFragment != null;
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(this, "Về ứng dụng", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(this, "Giúp đỡ", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.shopping_cart:

                //    TODO Gán hành động cho việc nhấn vào giỏ hàng trên actions bar, chuyển đến màn hình giỏ hàng
                Intent intent = new Intent(this, ShoppingCartActivity.class);
                this.startActivity(intent);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
