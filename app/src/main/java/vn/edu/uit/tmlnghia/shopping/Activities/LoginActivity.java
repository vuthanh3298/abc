package vn.edu.uit.tmlnghia.shopping.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URLEncoder;

import vn.edu.uit.tmlnghia.shopping.R;
import vn.edu.uit.tmlnghia.shopping.until.UserPresent;
import vn.edu.uit.tmlnghia.shopping.until.Webserviecs;

public class LoginActivity extends AppCompatActivity {

    TextView loginButton;
    TextView signupButton;
    TextView forgotPassword;
    TextView facebook;
    TextView zalo;
    TextView google;

    EditText edtEmail, edtPassword;

    int values = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent intent = getIntent();
        values = intent.getIntExtra("chitietsanpham",-1);

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

        edtEmail = this.findViewById(R.id.login_id);
        edtPassword = this.findViewById(R.id.login_password);

//        TODO Thiết lập hành động nhấn cho nút đăng nhập
//        Kiểm tra dữ liệu, chuyển về màn hình home
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String params = "?email=" + URLEncoder.encode(edtEmail.getText().toString()) +
                                "&password=" + URLEncoder.encode(edtPassword.getText().toString());
                loginTask task = new loginTask();
                task.execute(params);
            }
        });

//        TODO Thiết lập hành động nhấn cho nút đăng ký
//        Chuyển sang màn hình đăng ký
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                LoginActivity.this.startActivity(intent);
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

    private void openMain(){
        Intent intent;
        if(values == 1){
            finish();
            return;
        } else {
            intent = new Intent(LoginActivity.this, MainActivity.class);
        }
        LoginActivity.this.startActivity(intent);
    }

    class loginTask extends AsyncTask<String, Void, Boolean>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean.booleanValue() == true){
                openMain();
            } else {
                Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected Boolean doInBackground(String... strings) {
            try{
                JSONArray jsonArray = Webserviecs.getJsonArray("api/users" + strings[0]);
                if(jsonArray.length() > 0){
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    if(jsonObject.has("_id")) {
                        UserPresent.user_id = jsonObject.getString("_id");
                        return true;
                    } else {
                        return false;
                    }
                }
            } catch (Exception ex){
                Log.e("Loi: ", ex.toString());
            }
            return false;
        }
    }
}
