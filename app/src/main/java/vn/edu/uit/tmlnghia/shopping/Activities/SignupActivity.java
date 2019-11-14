package vn.edu.uit.tmlnghia.shopping.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import vn.edu.uit.tmlnghia.shopping.R;

public class SignupActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

//        TODO Thiết lập thanh action bar, Sửa lại nút close
        getSupportActionBar().setTitle(R.string.sign_up);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close_action);

        TextView signupButton = this.findViewById(R.id.sign_up_button);
        TextView loginButton = this.findViewById(R.id.login_button);


//        TODO Thiết lập hành động nhấn cho nút đăng ký
//        Kiểm tra dữ liệu, lấy dữ liệu và thông báo thành công
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                TODO Hiển thị thông báo đăng ký thành công
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignupActivity.this);
                LayoutInflater mInflater = LayoutInflater.from(v.getContext());
                View view = mInflater.inflate(R.layout.signup_confirm_dialog, null);
                mBuilder.setView(view);

                TextView notNowButton = view.findViewById(R.id.not_now);
                TextView loginButton = view.findViewById(R.id.login_button);

//                TODO Thiết lập hành động nhấn cho nút không phải bây giờ
                notNowButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), MainActivity.class);
                        v.getContext().startActivity(intent);
                    }
                });

//                TODO Thiết lập hành động nhấn cho nút đăng nhập
                loginButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), LoginActivity.class);
                        v.getContext().startActivity(intent);
                    }
                });

                AlertDialog dialog = mBuilder.create();
                dialog.show();

            }
        });

//        TODO Thiết lập hành động nhấn cho nút đăng nhập
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                v.getContext().startActivity(intent);

            }
        });

    }
}
