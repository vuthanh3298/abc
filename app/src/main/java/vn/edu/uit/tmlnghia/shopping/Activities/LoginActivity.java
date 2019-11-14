package vn.edu.uit.tmlnghia.shopping.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import vn.edu.uit.tmlnghia.shopping.R;

public class LoginActivity extends AppCompatActivity {

    TextView loginButton;
    TextView signupButton;
    TextView forgotPassword;
    TextView facebook;
    TextView zalo;
    TextView google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        TODO Thiết lập thanh action bar, thay đổi nút bấm close
        getSupportActionBar().setTitle(R.string.login);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close_action);

        loginButton = this.findViewById(R.id.login_button);
        signupButton = this.findViewById(R.id.sign_up_button);
        forgotPassword = this.findViewById(R.id.forgot_password);
        facebook = this.findViewById(R.id.facebook);
        zalo = this.findViewById(R.id.zalo);
        google = this.findViewById(R.id.google);

//        TODO Thiết lập hành động nhấn cho nút đăng nhập
//        Kiểm tra dữ liệu, chuyển về màn hình home
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
            }
        });

//        TODO Thiết lập hành động nhấn cho nút đăng ký
//        Chuyển sang màn hình đăng ký
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SignupActivity.class);
                v.getContext().startActivity(intent);
            }
        });

//        TODO Thiết lập hành động nhấn cho chức năng quên mật khẩu
//        Chuyển đến màn hình đặt lại mật khẩu
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Quên mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

//        TODO Thiết lập hành động nhấn cho những cách đăng nhập khác
//        Đăng nhập bằng Facebook
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Đăng nhập bằng Facebook", Toast.LENGTH_SHORT).show();
            }
        });

//        Đăng nhập bằng Zalo
        zalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Đăng nhập bằng Zalo", Toast.LENGTH_SHORT).show();
            }
        });

//        Đăng nhập bằng Google
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Đăng nhập bằng Google", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
