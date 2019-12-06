package vn.edu.uit.tmlnghia.shopping.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;

import vn.edu.uit.tmlnghia.shopping.R;
import vn.edu.uit.tmlnghia.shopping.models.User;
import vn.edu.uit.tmlnghia.shopping.until.Webserviecs;

public class SignupActivity extends AppCompatActivity {

    TextView txtTen, txtEmail, txtSDT, txtPassword, txtConfirm;

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

        txtTen = this.findViewById(R.id.sign_up_name);
        txtEmail = this.findViewById(R.id.sign_up_email);
        txtSDT = this.findViewById(R.id.sign_up_phone);
        txtPassword = this.findViewById(R.id.sign_up_password);
        txtConfirm = this.findViewById(R.id.sign_up_confirm_password);




//        TODO Thiết lập hành động nhấn cho nút đăng ký
//        Kiểm tra dữ liệu, lấy dữ liệu và thông báo thành công
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(!(txtPassword.getText().toString().equals(txtConfirm.getText().toString()))){
                Toast.makeText(SignupActivity.this, "Xác nhận mật khẩu không trùng nhau", Toast.LENGTH_LONG).show();
                return;
            }
            User user = new User(txtTen.getText().toString(), txtEmail.getText().toString(), txtPassword.getText().toString(), txtSDT.getText().toString());
            createUserTask task = new createUserTask();
            task.execute(user);
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

    private void showDialog(){
//      TODO Hiển thị thông báo đăng ký thành công
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(SignupActivity.this);
        LayoutInflater mInflater = LayoutInflater.from(SignupActivity.this);
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

    class createUserTask extends AsyncTask<User, Void, Boolean>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean.booleanValue() == true){
                showDialog();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Boolean doInBackground(User... users) {
            try{
                User user = users[0];
                String params = "?name=" + URLEncoder.encode(user.getName()) +
                                "&email=" + URLEncoder.encode(user.getEmail()) +
                                "&phone=" + URLEncoder.encode(user.getPhone()) +
                                "&password=" + URLEncoder.encode(user.getPassword());
                return Webserviecs.postAPI("api/users/create" + params);
            } catch (Exception ex){
                Log.e("Loi: ", ex.toString());
            }
            return null;
        }
    }
}
